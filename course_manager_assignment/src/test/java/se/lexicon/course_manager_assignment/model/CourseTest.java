package se.lexicon.course_manager_assignment.model;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

//import static org.junit.Assert.assertNotNull;

//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;

public class CourseTest {
    /**
     * Arrange
     * Act
     * Assert
     */
    Course luxorBasic = new Course("ABC80 Basic", LocalDate.of(2020, 9,1),5);
    Student pelle = new Student("Per Person", "pelle@hotmail.com","Presidentgatan 4");
    Student kalle = new Student("Karl Kalson", "kalle@hotmail.com", "Kejsargatan 21");

    @BeforeEach
    void setUp() {
//        Student pelle = new Student("Per Person", "pelle@hotmail.com","Presidentgatan 4");
//        Student kalle = new Student("Karl Kalson", "kalle@hotmail.com", "Kejsargatan 21");

    }

    @Test
    void testEnrollStudent() {
//        Course luxorBasic = new Course("ABC80 Basic", LocalDate.of(2020, 9,1),5);
//        Course luxorBasic = new Course("ABC80 Basic", LocalDate.parse("2020-09-01"), 5);
//        Student pelle = new Student("Per Person", "pelle@hotmail.com","Presidentgatan 4");
//        Student kalle = new Student("Karl Kalson", "kalle@hotmail.com", "Kejsargatan 21");

        luxorBasic.enrollStudent(pelle);
//        System.out.println(pelle.toString());
        luxorBasic.enrollStudent(kalle);
//        System.out.println(kalle.toString());
        Assert.assertNotEquals("[]", luxorBasic.getStudents().toString());
    }

    @Test
    void testUnenrollStudent() {

//        Course luxorBasic = new Course("ABC80 Basic", LocalDate.parse("2020-09-01"), 5);
//        Student pelle = new Student("Per Person", "pelle@hotmail.com","Presidentgatan 4");
//        Student kalle = new Student("Karl Kalson", "kalle@hotmail.com", "Kejsargatan 21");

        luxorBasic.enrollStudent(pelle);
        luxorBasic.enrollStudent(kalle);
//        luxorBasic.enrollStudent(pelle);
//        System.out.println(kalle.toString());
        luxorBasic.unenrollStudent(pelle);
        luxorBasic.unenrollStudent(kalle);
        Assert.assertEquals("[]", luxorBasic.getStudents().toString());
    }

    @Test
    void getId() {
    }

    @Test
    void getCourseName() {
    }

    @Test
    void setCourseName() {
    }

    @Test
    void getStartDate() {
    }

    @Test
    void setStartDate() {
    }

    @Test
    void getWeekDuration() {
    }

    @Test
    void setWeekDuration() {
    }

    @Test
    void getStudents() {
    }

    @Test
    void setStudents() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
    }
}


