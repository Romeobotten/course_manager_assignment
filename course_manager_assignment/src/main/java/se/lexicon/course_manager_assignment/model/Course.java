package se.lexicon.course_manager_assignment.model;

import se.lexicon.course_manager_assignment.data.sequencers.CourseSequencer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Course {

    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private Collection<Student> students;

    public Course(String courseName, LocalDate startDate, int weekDuration) {
        this.id = CourseSequencer.nextCourseId(); // from data/sequencers
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = new ArrayList<>();
    }

    public int getId() { // no setter for id
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public Collection<Student> getStudents() {
        System.out.println(students.toString());
        if(students == null) {
            return null;
        } else return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    public boolean enrollStudent(Student student) {
        if(getStudents() == null) {
            return false;
        } else if(student.equals(null)) {
            System.out.println("Student var null");
            return false;
        } else {
            students.add(student);
            System.out.println("Added: " + student.toString());
            return true;
        }
    }

    public boolean unenrollStudent(Student student) {

            if(students.contains(student)) {
            students.remove(student);
            System.out.println("Removed: " + student.toString());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id &&
                courseName.equals(course.courseName) &&
                Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, students);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                ", students=" + students +
                '}';
    }
}
