package se.lexicon.course_manager_assignment.data.dao;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager_assignment.data.sequencers.StudentSequencer;
import se.lexicon.course_manager_assignment.model.Student;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(classes = {StudentCollectionRepository.class})
public class StudentCollectionRepositoryTest {

    @Autowired
    private StudentDao testObject;
//    private StudentCollectionRepository newTestObject;

    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertFalse(testObject == null);
    }

    //Write your tests here


    @BeforeEach
    void setUp() {
//        Student pelle = new Student("Per Person", "pelle@hotmail.com","Presidentgatan 4");
//        Student kalle = new Student("Karl Kalson", "kalle@hotmail.com", "Kejsargatan 21");
        StudentSequencer.setStudentSequencer(0);
//        StudentCollectionRepository newTestObject = null;
//        Student pelle = testObject.createStudent("Per Person", "pelle@hotmail.com","Presidentgatan 4");
//        Student kalle = testObject.createStudent("Karl Kalson", "kalle@hotmail.com", "Kejsargatan 21");
    }

    @AfterEach
    void tearDown() {
        testObject.clear();
        StudentSequencer.setStudentSequencer(0);
    }


    @Test
    void TestFindByEmailIgnoreCase() {
        Student pelle = testObject.createStudent("Per Person", "pelle@hotmail.com","Presidentgatan 4");

        String email = "pelle@hotmail.com";

        Assert.assertTrue(testObject.findByEmailIgnoreCase("pelle@hotmail.com").equals(pelle));
//        testObject.removeStudent(pelle);
//        Assert.assertTrue(testObject.findByEmailIgnoreCase("pelle@hotmail.com").equals(pelle));
    }

    @Test
    void TestFindByNameContains() {
        Student kalle = testObject.createStudent("Karl Kalson", "kalle@hotmail.com", "Kejsargatan 21");
        String name = "Karl Kalson";
        Assert.assertTrue(testObject.findByNameContains(name).size() == 1);
    }

    @Test
    void testFindById() {
        Student kalle = testObject.createStudent("Karl Kalson", "kalle@hotmail.com", "Kejsargatan 21");
        int id = 1;
        Assert.assertTrue(testObject.findById(id).equals(kalle));
    }

    @Test
    void testRemoveStudent() {
        Student kalle = testObject.createStudent("Karl Kalson", "kalle@hotmail.com", "Kejsargatan 21");
//        testObject.removeStudent(kalle);
        System.out.println(testObject.toString());
        Assert.assertTrue(testObject.removeStudent(kalle));
    }

}
