package se.lexicon.course_manager_assignment.data.service.converter;

import org.springframework.stereotype.Component;
import se.lexicon.course_manager_assignment.dto.views.CourseView;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ModelToDto implements Converters {
    @Override
    public StudentView studentToStudentView(Student student) {
        return new StudentView(student.getId(),student.getName(),
                student.getEmail(),student.getAddress());
    }

    @Override
    public CourseView courseToCourseView(Course course) { // This is done
        return new CourseView(course.getId(),course.getCourseName(),
                course.getStartDate(),course.getWeekDuration(),studentsToStudentViews(course.getStudents()));
    }

    @Override
    public List<CourseView> coursesToCourseViews(Collection<Course> courses) {
//        List<CourseView> list = (List)courses; // This is not working?
        if(courses == null) {
            courses = new ArrayList<>();
        }
        List<CourseView> list = new ArrayList<>();
        for(Course course: courses) {
            list.add(courseToCourseView(course));
        }
        return list;
    }

    @Override
    public List<StudentView> studentsToStudentViews(Collection<Student> students) {

        if(students == null) {
            students = new ArrayList<>();
        }
        List<StudentView> list = new ArrayList<>();
        for(Student student: students) {
            list.add(studentToStudentView(student));
        }
        return list;
    }
}
