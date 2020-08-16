package se.lexicon.course_manager_assignment.data.service.course;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager_assignment.data.dao.CourseCollectionRepository;
import se.lexicon.course_manager_assignment.data.dao.CourseDao;
import se.lexicon.course_manager_assignment.data.dao.StudentCollectionRepository;
import se.lexicon.course_manager_assignment.data.sequencers.CourseSequencer;
import se.lexicon.course_manager_assignment.data.service.converter.ModelToDto;
import se.lexicon.course_manager_assignment.model.Course;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {CourseManager.class, CourseCollectionRepository.class, ModelToDto.class, StudentCollectionRepository.class})
public class CourseManagerTest {

    @Autowired
    private CourseService testObject;
    private CourseDao courseDao;

    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertNotNull(testObject);
        assertNotNull(courseDao);
    }

    @BeforeEach
    void setUp() {
        CourseSequencer.setCourseSequencer(0);
        courseDao.createCourse("ADA", LocalDate.of(2020,10,31), 8);

    }

    @AfterEach
    void tearDown() {
        courseDao.clear();
        CourseSequencer.setCourseSequencer(0);
    }


    @Test
    void testCreate() {


    }

    @Test
    void testUpdate() {
    }


    @Test
    void testSearchByCourseName() {
    }

    @Test
    void testSearchByDateBefore() {
    }

    @Test
    void testSearchByDateAfter() {
    }

    @Test
    void testAddStudentToCourse() {
    }

    @Test
    void testRemoveStudentFromCourse() {
    }

    @Test
    void testFindById() {
    }

    @Test
    void testFindAll() {
    }

    @Test
    void testFindByStudentId() {
    }

    @Test
    void testDeleteCourse() {
    }
}
