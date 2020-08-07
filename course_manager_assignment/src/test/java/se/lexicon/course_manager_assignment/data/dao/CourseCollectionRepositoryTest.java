package se.lexicon.course_manager_assignment.data.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager_assignment.data.sequencers.CourseSequencer;

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
    void createCourse() {
    }

    @Test
    void findById() {


    }

    @Test
    void findByNameContains() {
    }

    @Test
    void findByDateBefore() {
    }

    @Test
    void findByDateAfter() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByStudentId() {
    }

    @Test
    void removeCourse() {
    }

    @Test
    void clear() {
    }
}
