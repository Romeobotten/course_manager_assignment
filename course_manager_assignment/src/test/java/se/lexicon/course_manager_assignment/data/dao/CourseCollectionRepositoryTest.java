package se.lexicon.course_manager_assignment.data.dao;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager_assignment.data.dao.StudentDao;
import se.lexicon.course_manager_assignment.data.dao.CourseDao;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;

import java.time.LocalDate;

//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {CourseCollectionRepository.class})
public class CourseCollectionRepositoryTest {

    @Autowired
    private CourseDao testObject;
    private StudentDao anotherTestObject;

    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertNotNull(testObject);
//        assertNotNull(testObject2);
    }

    @BeforeEach
    void setUp() {
//    Course ada = testObject.createCourse("ADA for professionals",
//        LocalDate.of(2020, 9, 1), 10);
    }

    @AfterEach
    void tearDown() {
//        testObject.clear();
//        testObject2.clear();
//        CourseSequencer.setCourseSequencer(0);
//        StudentSequencer.setStudentSequencer(0);
    }

    @Test
    void findById() {
        Course ada = testObject.createCourse("ADA for professionals",
                LocalDate.of(2020, 9, 1), 10);

        Assert.assertNotNull(testObject.findById(1));
    }

    @Test
    void testFindByNameContains() {
        Course ada = testObject.createCourse("ADA for professionals",
                LocalDate.of(2020, 9, 1), 10);
        String name = "ADA for professionals";

        Assert.assertTrue(testObject.findByNameContains(name).size() > 0);
    }

    @Test
    void testFindByDateBefore() {
        Course ada = testObject.createCourse("ADA for professionals",
                LocalDate.of(2020, 9, 1), 10);
        Course lisp = testObject.createCourse("Lisp for professionals",
                LocalDate.of(2021, 1, 31), 15);

        Assert.assertTrue(testObject.findByDateBefore(LocalDate.of(2020,12,31)).contains(ada));
    }

    @Test
    void testFindByDateAfter() {
        Course ada = testObject.createCourse("ADA for professionals",
                LocalDate.of(2020, 9, 1), 10);
        Course lisp = testObject.createCourse("Lisp for professionals",
                LocalDate.of(2021, 1, 31), 15);

        Assert.assertTrue(testObject.findByDateAfter(LocalDate.of(2020,10,11)).contains(lisp));
    }

    @Test
    void findAll() {

    }

    @Test
    void findByStudentId() {
        Course ada = testObject.createCourse("ADA for professionals",
                LocalDate.of(2020, 9, 1), 10);
//        Student pelle = anotherTestObject.createStudent("Per Person", "pelle@hotmail.com","Presidentgatan 4");
//        Student kalle = anotherTestObject.createStudent("Karl Kalson", "kalle@hotmail.com", "Kejsargatan 21");
//
//        Assert.assertTrue(ada.enrollStudent(pelle));
//        Assert.assertTrue(ada.enrollStudent(kalle));
//        System.out.println(pelle.toString());
//        System.out.println(kalle.toString());

        Assert.assertTrue(testObject.findByStudentId(1).size() == 0);
    }

    @Test
    void testRemoveCourse() {
        Course ada = testObject.createCourse("ADA for professionals",
                LocalDate.of(2020, 9, 1), 10);
        System.out.println(testObject.toString());
        Assert.assertTrue(testObject.removeCourse(ada));
    }
}
