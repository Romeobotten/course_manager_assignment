package se.lexicon.course_manager_assignment.data.service.student;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager_assignment.data.dao.CourseCollectionRepository;
import se.lexicon.course_manager_assignment.data.dao.StudentCollectionRepository;
import se.lexicon.course_manager_assignment.data.dao.StudentDao;
import se.lexicon.course_manager_assignment.data.sequencers.CourseSequencer;
import se.lexicon.course_manager_assignment.data.sequencers.StudentSequencer;
import se.lexicon.course_manager_assignment.data.service.converter.ModelToDto;
import se.lexicon.course_manager_assignment.dto.forms.CreateStudentForm;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Student;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {StudentManager.class, CourseCollectionRepository.class, StudentCollectionRepository.class, ModelToDto.class})
public class StudentManagerTest {

    @Autowired
    private StudentService testObject;
    private StudentDao studentDao;
    private CreateStudentForm form;


    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertNotNull(testObject);
        assertNotNull(studentDao);
    }

    //Write your tests here
    @BeforeEach
    void setUp() {
        StudentSequencer.setStudentSequencer(0);
//        Student pelle = studentDao.createStudent("Per Person", "pelle@lexicon.se", "Pegatan 11");
        form.setId(1);
        form.setName("Per Person");
        form.setEmail("pelle@lexicon.se");
        form.setAddress("Pegatan 11");
    }

    @AfterEach
    void tearDown() {
        StudentSequencer.setStudentSequencer(0);
        studentDao.clear();
    }

    @Test
    void testCreate() {
       testObject.create(form);

        Assert.assertTrue(testObject.findById(1) == testObject.searchByEmail("pelle@lexicon.se"));
    }

    @Test
    void testUpdate() {
//        testObject.update(form);
    }

    @Test
    void testFindById() {

    }

    @Test
    void testSearchByEmail() {
//        String email = testObject.searchByEmail("pelle@lexicon.se");

    }

    @Test
    void testSearchByName() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testDeleteStudent() {

    }
}
