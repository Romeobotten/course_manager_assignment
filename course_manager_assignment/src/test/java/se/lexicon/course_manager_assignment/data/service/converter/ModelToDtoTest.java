package se.lexicon.course_manager_assignment.data.service.converter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager_assignment.data.dao.CourseDao;
import se.lexicon.course_manager_assignment.data.sequencers.CourseSequencer;
import se.lexicon.course_manager_assignment.data.sequencers.StudentSequencer;
import se.lexicon.course_manager_assignment.dto.views.CourseView;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = {ModelToDto.class})
public class ModelToDtoTest {

    @Autowired
    private Converters testObject;

    Course luxorBasic = new Course(1, "ABC80 Basic", LocalDate.of(2020, 9,1),5);
    Student pelle = new Student(1, "Per Person", "pelle@hotmail.com","Presidentgatan 4");
    Student kalle = new Student(2, "Karl Kalson", "kalle@hotmail.com", "Kejsargatan 21");


    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertNotNull(testObject);
    }

    @BeforeEach
    void setUp() {

   }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testStudentToStudentView() { // I should use View.equals here
        StudentView mrP = testObject.studentToStudentView(pelle);
        Assert.assertEquals(mrP.hashCode(), pelle.hashCode());
    }

    @Test
    void testCourseToCourseView() { // I should use View.equals here too
        luxorBasic.enrollStudent(kalle);
        luxorBasic.enrollStudent(pelle);
        CourseView abcBasic = testObject.courseToCourseView(luxorBasic);
        Assert.assertEquals(abcBasic.hashCode(), luxorBasic.hashCode());
    }

    @Test
    void testCoursesToCourseViews() {
        Collection<Course> testCourses = new ArrayList<>();
        testCourses.add(luxorBasic);
        List<CourseView> courseViews = new ArrayList<>();

        Assert.assertTrue(courseViews.addAll(testObject.coursesToCourseViews(testCourses)));
    }

    @Test
    void testStudentsToStudentViews() {
        Collection<Student> testStudents = new ArrayList<>();
        testStudents.add(kalle);
        List<StudentView> studentViews = new ArrayList<>();

        Assert.assertTrue(studentViews.addAll(testObject.studentsToStudentViews(testStudents)));

//        Assert.assertTrue(studentViews.containsAll(testStudents)); // not working
    }
}
