package se.lexicon.course_manager_assignment.data.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.course_manager_assignment.data.dao.CourseDao;
import se.lexicon.course_manager_assignment.data.dao.StudentDao;
import se.lexicon.course_manager_assignment.data.service.converter.Converters;
import se.lexicon.course_manager_assignment.dto.forms.CreateStudentForm;
import se.lexicon.course_manager_assignment.dto.forms.UpdateStudentForm;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class StudentManager implements StudentService {

    private final StudentDao studentDao;
    private final CourseDao courseDao;
    private final Converters converters;

    @Autowired
    public StudentManager(StudentDao studentDao, CourseDao courseDao, Converters converters) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
        this.converters = converters;
    }

    @Override
    public StudentView create(CreateStudentForm form) {
        Student student = studentDao.createStudent(form.getName(), form.getEmail(), form.getAddress());
        return converters.studentToStudentView(student);
    }

    @Override
    public StudentView update(UpdateStudentForm form) {
        Student UpdateStudent = studentDao.findById(form.getId());
        if (UpdateStudent != null) {
            UpdateStudent.setName(form.getName());
            UpdateStudent.setEmail(form.getEmail());
            UpdateStudent.setAddress(form.getAddress());
            return converters.studentToStudentView(UpdateStudent);
        }
        return null;
    }

    @Override
    public StudentView findById(int id) {
        Student student = studentDao.findById(id);
        if (student == null) {
            return null;
        } else {
            return converters.studentToStudentView(student);
        }
    }

    @Override
    public StudentView searchByEmail(String email) {
        Student student = studentDao.findByEmailIgnoreCase(email);
        if (student == null) {
            return null;
        } else {
            return converters.studentToStudentView(student);
        }
    }

    @Override
    public List<StudentView> searchByName(String name) {
        Collection<Student> studentList = new ArrayList<>();
        studentList = studentDao.findByNameContains(name);
        return converters.studentsToStudentViews(studentList);
    }

    @Override
    public List<StudentView> findAll() {
        Collection<Student> studentList = new ArrayList<>();
        studentList = studentDao.findAll();
        return converters.studentsToStudentViews(studentList);
    }

    @Override
    public boolean deleteStudent(int id) {
        Student student = studentDao.findById(id);
        if (student == null) {
            return false;
        } else {
            studentDao.removeStudent(student);
            return true;
        }
    }
}
