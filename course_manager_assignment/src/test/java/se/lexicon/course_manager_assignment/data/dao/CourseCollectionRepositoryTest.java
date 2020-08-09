package se.lexicon.course_manager_assignment.data.dao;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager_assignment.data.sequencers.CourseSequencer;
import se.lexicon.course_manager_assignment.model.Course;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(classes = {CourseCollectionRepository.class})
public class CourseCollectionRepositoryTest {

    @Autowired
    private CourseDao testObject;

    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertFalse(testObject == null);
    }

    //Write your tests here


    @AfterEach
    void tearDown() {
        testObject.clear();
        CourseSequencer.setCourseSequencer(0);
    }

    @BeforeEach
    void setUp() {

    }


    @Test
    void findById() {


    }

    @Test
    void findByNameContains() {
        Course ada = testObject.createCourse("ADA for professionals",
                LocalDate.of(2020, 9, 1), 10);
        String name = "ADA for professionals";
        Assert.assertTrue(testObject.findByNameContains(name).size() > 0);
    }

    @Test
    void findByDateBefore() {
        Course ada = testObject.createCourse("ADA for professionals",
                LocalDate.of(2020, 9, 1), 10);
        Course lisp = testObject.createCourse("Lisp for professionals",
                LocalDate.of(2019, 12, 31), 15);
        Assert.assertTrue(testObject.findByDateBefore(LocalDate.of(2020,5,31)).contains(lisp));

    }

    @Test
    void findByDateAfter() {
        Course ada = testObject.createCourse("ADA for professionals",
                LocalDate.of(2020, 9, 1), 10);
        Course lisp = testObject.createCourse("Lisp for professionals",
                LocalDate.of(2019, 12, 31), 15);
        Assert.assertTrue(testObject.findByDateAfter(LocalDate.of(2020,5,31)).contains(ada));

    }

    @Test
    void findAll() {

    }

    @Test
    void findByStudentId() {

    }

    @Test
    void removeCourse() {
        Course ada = testObject.createCourse("ADA for professionals",
                LocalDate.of(2020, 9, 1), 10);
        System.out.println(testObject.toString());
        Assert.assertTrue(testObject.removeCourse(ada));
    }
}
