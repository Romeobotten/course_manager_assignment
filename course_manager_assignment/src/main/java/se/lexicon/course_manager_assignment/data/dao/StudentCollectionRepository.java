package se.lexicon.course_manager_assignment.data.dao;


import se.lexicon.course_manager_assignment.model.Student;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;


public class StudentCollectionRepository implements StudentDao {

    private Collection<Student> students;

    public StudentCollectionRepository(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public Student createStudent(String name, String email, String address) {
        Student student = new Student(name, email, address);
        return student;
    }

    @Override
    public Student findByEmailIgnoreCase(String email) {


        return null;
    }

    @Override
    public Collection<Student> findByNameContains(String name) {
        students.contains(name);

        return null;
    }

    @Override
    public Student findById(int id) {
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()) {
            Student student = iterator.next();
            if(student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Collection<Student> findAll() {
        return null;
    }

    @Override
    public boolean removeStudent(Student student) {
        if(students.contains(student)) {
            removeStudent(student);
            return true;
        } else return false;
    }

    @Override
    public void clear() {
        this.students = new HashSet<>();
    }
}
