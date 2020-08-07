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
        students.add(student);
        return student;
    }

    @Override
    public Student findByEmailIgnoreCase(String email) {
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()) {
            Student student = iterator.next();
            if(student.getEmail().equals(email)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Collection<Student> findByNameContains(String name) {
        Collection<Student> substudents = new HashSet<>();
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()) {
            Student student = iterator.next();
            if(student.getName().equals(name)) {
                substudents.add(student);
            }
        }
        return substudents;
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
        return students;
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
        students.clear();
        this.students = new HashSet<>(); // Why Hashset?
    }
}
