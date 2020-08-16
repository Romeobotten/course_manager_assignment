package se.lexicon.course_manager_assignment.data.service.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.course_manager_assignment.data.dao.CourseDao;
import se.lexicon.course_manager_assignment.data.dao.StudentDao;
import se.lexicon.course_manager_assignment.data.service.converter.Converters;
import se.lexicon.course_manager_assignment.dto.forms.CreateCourseForm;
import se.lexicon.course_manager_assignment.dto.forms.UpdateCourseForm;
import se.lexicon.course_manager_assignment.dto.views.CourseView;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;

import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CourseManager implements CourseService {

    private final CourseDao courseDao;
    private final StudentDao studentDao;
    private final Converters converters;

    @Autowired
    public CourseManager(CourseDao courseDao, StudentDao studentDao, Converters converters) {
        this.courseDao = courseDao;
        this.studentDao = studentDao;
        this.converters = converters;
    }

    @Override
    public CourseView create(CreateCourseForm form) {
        Course course = courseDao.createCourse(form.getCourseName(), form.getStartDate(), form.getWeekDuration());
        return converters.courseToCourseView(course);
    }

    @Override
    public CourseView update(UpdateCourseForm form) {
        Course UpdateCourse = courseDao.findById(form.getId());

        if (UpdateCourse != null) {
            UpdateCourse.setCourseName(form.getCourseName());
            UpdateCourse.setStartDate(form.getStartDate());
            UpdateCourse.setWeekDuration(form.getWeekDuration());
            return converters.courseToCourseView(UpdateCourse);
        } else return null;
    }

    @Override
    public List<CourseView> searchByCourseName(String courseName) {
        Collection<Course> courseList; // ------------
        courseList = courseDao.findByNameContains(courseName);
        return converters.coursesToCourseViews(courseList);
    }

    @Override
    public List<CourseView> searchByDateBefore(LocalDate end) {
        Collection<Course> courseList; // Not needed?
        courseList = courseDao.findByDateBefore(end);
        return converters.coursesToCourseViews(courseList);
    }

    @Override
    public List<CourseView> searchByDateAfter(LocalDate start) {
        Collection<Course> courseList; // --------------
        courseList = courseDao.findByDateAfter(start);
        return converters.coursesToCourseViews(courseList);
    }

    @Override
    public boolean addStudentToCourse(int courseId, int studentId) {
        Course course = courseDao.findById(courseId);
        Student student = studentDao.findById(studentId);

        if (course == null || student == null) {
            return false;
        } else return course.enrollStudent(student);
    }

    @Override
    public boolean removeStudentFromCourse(int courseId, int studentId) {
        Course course = courseDao.findById(courseId);
        Collection<Course> courseList; // init Not needed?
        courseList = courseDao.findByStudentId(studentId);
        Student student = studentDao.findById(studentId);

        if (course == null) {
            return false;
        } else if(courseList.isEmpty()) {
            return false;
        } else if(courseList.contains(course)) { // Ok now?
            return course.unenrollStudent(student);
        } else return false;
    }

    @Override
    public CourseView findById(int id) {
        Course course = courseDao.findById(id);
        if (course == null) {
            return null;
        } else {
            return converters.courseToCourseView(course);
        }
    }

    @Override
    public List<CourseView> findAll() {
        Collection<Course> courseList; // ************
        courseList = courseDao.findAll();
        return converters.coursesToCourseViews(courseList);
    }

    @Override
    public List<CourseView> findByStudentId(int studentId) {
        Collection<Course> courseList; //+++++++++++++++++++
        courseList = courseDao.findByStudentId(studentId);
        return converters.coursesToCourseViews(courseList);
    }

    @Override
    public boolean deleteCourse(int id) {
        Course course = courseDao.findById(id);
        if (course == null) {
            return false;
        } else {
            return courseDao.removeCourse(course);
        }
    }
}
