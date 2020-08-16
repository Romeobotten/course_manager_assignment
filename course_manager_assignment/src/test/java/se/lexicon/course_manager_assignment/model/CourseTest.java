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

    Course luxorBasic = new Course(1, "ABC80 Basic", LocalDate.of(2020, 9,1),5);
    Student pelle = new Student(1, "Per Person", "pelle@hotmail.com","Presidentgatan 4");
    Student kalle = new Student(2, "Karl Kalson", "kalle@hotmail.com", "Kejsargatan 21");

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
        String viewStudent = luxorBasic.getStudents().toString();

        Assert.assertEquals("[]", empty);
        Assert.assertTrue(luxorBasic.getStudents().size() == 1);
        Assert.assertEquals("[Student{id=2, name='Karl Kalson', email='kalle@hotmail.com', address='Kejsargatan 21'}]", viewStudent);
    }

    @Test
    void testGetId() {

        Assert.assertTrue(luxorBasic.getId() == 1);
    }

    @Test
    void TestGetAndSetCourseName() {
        luxorBasic.setCourseName("Vic64 Basic");
        String vic64 = luxorBasic.getCourseName();
        luxorBasic.setCourseName("ABC80 Basic");
        String abc80 = luxorBasic.getCourseName();
        Assert.assertTrue(vic64 == "Vic64 Basic" && abc80 == "ABC80 Basic");
    }

    @Test
    void testGetAndSetStartDate() {
        luxorBasic.setStartDate(LocalDate.of(2020,10,31));
        String halloween = luxorBasic.getStartDate().toString();
        luxorBasic.setStartDate(LocalDate.of(2020,12,13));
        String lucia = luxorBasic.getStartDate().toString();
        Assert.assertTrue(halloween.equals("2020-10-31") && lucia.equals("2020-12-13"));
    }

    @Test
    void testGetAndSetWeekDuration() {
        luxorBasic.setWeekDuration(25);
        int longTime = luxorBasic.getWeekDuration();
        luxorBasic.setWeekDuration(5);
        int shortTime = luxorBasic.getWeekDuration();
        Assert.assertTrue(longTime == 25 && shortTime == 5);
    }

    @Test
    void testEquals() {
        Course abcBasic = luxorBasic;
        Assert.assertEquals(abcBasic, luxorBasic);
    }

    @Test
    void testHashCode() {
        Course abcBasic = luxorBasic;
        Assert.assertTrue(abcBasic.hashCode() == luxorBasic.hashCode());
    }

    @Test
    void testToString() {
        luxorBasic.enrollStudent(pelle);
        String expected = "Course{id=1, courseName='ABC80 Basic', startDate=2020-09-01, weekDuration=5, " +
                "students=[Student{id=1, name='Per Person', email='pelle@hotmail.com', address='Presidentgatan 4'}]}";
//        System.out.println(luxorBasic.toString());
        Assert.assertEquals(expected,luxorBasic.toString());
    }
}
