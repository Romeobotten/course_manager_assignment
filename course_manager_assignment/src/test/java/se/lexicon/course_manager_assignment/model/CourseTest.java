package se.lexicon.course_manager_assignment.model;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;

//import static org.junit.Assert.assertNotNull;

//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;

public class CourseTest {
    /**
     * Arrange
     * Act
     * Assert
     */
    //        Course luxorBasic = new Course("ABC80 Basic", LocalDate.parse("2020-09-01"), 5);
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

        luxorBasic.enrollStudent(pelle);
//        System.out.println(pelle.toString());
        luxorBasic.enrollStudent(kalle);
//        System.out.println(kalle.toString());
        Assert.assertNotEquals("[]", luxorBasic.getStudents().toString());
    }

    @Test
    void testGetSetEnrollUnenrollStudent() {

        luxorBasic.enrollStudent(pelle);
        luxorBasic.enrollStudent(kalle);
        Collection<Student> testStudents = luxorBasic.getStudents();
        luxorBasic.unenrollStudent(pelle);
        luxorBasic.unenrollStudent(kalle);
        String empty = luxorBasic.getStudents().toString();
        testStudents.add(kalle);
        luxorBasic.setStudents(testStudents);

        Assert.assertEquals("[]", empty);
        Assert.assertTrue(luxorBasic.getStudents().size() == 1);
    }

    @Test
    void getId() {
        Assert.assertTrue(luxorBasic.getId() > 0);
    }

    @Test
    void getAndSetCourseName() {
        luxorBasic.setCourseName("Vic64 Basic");
        String vic64 = luxorBasic.getCourseName();
        luxorBasic.setCourseName("ABC80 Basic");
        String abc80 = luxorBasic.getCourseName();
        Assert.assertTrue(vic64 == "Vic64 Basic" && abc80 == "ABC80 Basic");
    }

    @Test
    void getAndSetStartDate() {
        luxorBasic.setStartDate(LocalDate.of(1985,10,31));
        String before = luxorBasic.getStartDate().toString();
        luxorBasic.setStartDate(LocalDate.of(2020,9,1));
        String soon = luxorBasic.getStartDate().toString();
        Assert.assertTrue(before.equals("1985-10-31") && soon.equals("2020-09-01"));
    }

    @Test
    void getAndSetWeekDuration() {
        luxorBasic.setWeekDuration(25);
        int longTime = luxorBasic.getWeekDuration();
        luxorBasic.setWeekDuration(5);
        int shortTime = luxorBasic.getWeekDuration();
        Assert.assertTrue(longTime == 25 && shortTime == 5);
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
        Student pelle = new Student("Per Person", "pelle@hotmail.com","Presidentgatan 4");
        luxorBasic.enrollStudent(pelle);
        String expected = "Course{id=2, courseName='ABC80 Basic', startDate=2020-09-01, weekDuration=5, " +
                "students=[Student{id=5, name='Per Person', email='pelle@hotmail.com', address='Presidentgatan 4'}]}";
        System.out.println(luxorBasic.toString());
        Assert.assertEquals(expected,luxorBasic.toString());
    }
}
