package se.lexicon.course_manager_assignment.data.dao;

import se.lexicon.course_manager_assignment.model.Course;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class CourseCollectionRepository implements CourseDao{

    private Collection<Course> courses;

    public CourseCollectionRepository(Collection<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {
        Course course = new Course(courseName, startDate, weekDuration);
        this.courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        Iterator<Course> iterator = courses.iterator();

        while(iterator.hasNext()) {
            Course course = iterator.next();
                if(course.getId() == id) {
                    return course;
                }
            }
        return null;
    }

    @Override
    public Collection<Course> findByNameContains(String name) {
        Collection<Course> subcourse = new HashSet<>();
        Iterator<Course> iterator = courses.iterator();
        while(iterator.hasNext()) {
            Course course = iterator.next();
            if(course.getCourseName().equals(name)) {
                subcourse.add(course);
            }
        }
        return subcourse;
    }

    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {
        Collection<Course> subcourses = new HashSet<>();
        Iterator<Course> iterator = courses.iterator();

        while(iterator.hasNext()) {
            Course course = iterator.next();
            if(course.getStartDate().plusWeeks((long)course.getWeekDuration()).isBefore(end)) {
                subcourses.add(course);
            }
        }
        return subcourses;
    }

    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {
        Collection<Course> subcourses = new HashSet<>();
        Iterator<Course> iterator = courses.iterator();

        while(iterator.hasNext()) {
            Course course = iterator.next();
            if(course.getStartDate().isAfter(start)) {
                subcourses.add(course);
            }
        }
        return subcourses;
    }

    @Override
    public Collection<Course> findAll() {
        return courses;
    }

    @Override
    public Collection<Course> findByStudentId(int studentId) {
        Collection<Course> subcourses = new HashSet<>();
        Iterator<Course> iterator = courses.iterator();

        while(iterator.hasNext()) {
            Course course = iterator.next();
            if(course.getStudents().contains(studentId)) {
                subcourses.add(course);
            }
        }
        return subcourses;
    }

    @Override
    public boolean removeCourse(Course course) {
        if(courses.contains(course)) {
            courses.remove(course);
            return true;
        } else return false;
    }

    @Override
    public void clear() {
        courses.clear();
        this.courses = new HashSet<>(); // Why Hashset?
    }
}
