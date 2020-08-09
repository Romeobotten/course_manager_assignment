package se.lexicon.course_manager_assignment.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class StudentTest {
//    StudentSequencer testStudents = new StudentSequencer();
//    testStudents.setStudentSequencer(0);


    Student pelle = new Student("Per Person", "pelle@hotmail.com","Presidentgatan 4");
    Student kalle = new Student("Karl Kalson", "kalle@hotmail.com", "Kejsargatan 21");
    Student number3 = new Student("Treben Ek", "null@gmail.com", "Gatan 3");

    @Test
    void getId() {
        int number1 = pelle.getId();
        int number2 = kalle.getId();
        System.out.println(number1 + " - " + number2);
        Assert.assertTrue(number1 + 1 == number2);
    }

    @Test
    void getName() {
        String name = kalle.getName();
        Assert.assertTrue(name == "Karl Kalson");
    }

    @Test
    void setNameEmailAndAddress() {
        number3.setName("Bo Ek");
        number3.setEmail("bosse@algonet.se");
        number3.setAddress("Åvägen 3");
        Assert.assertTrue("Bo Ek" == number3.getName() &&
                "bosse@algonet.se" == number3.getEmail() && "Åvägen 3" == number3.getAddress());
    }

    @Test
    void getEmail() {
        String email = pelle.getEmail();
        Assert.assertTrue(email == "pelle@hotmail.com");
    }

    @Test
    void getAddress() {
        String address = pelle.getAddress();
        Assert.assertTrue(address == "Presidentgatan 4");
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
        String first = "Student{" + "id=" + pelle.getId() +
                ", name='" + pelle.getName() + '\'' +
                ", email='" + pelle.getEmail() + '\'' +
                ", address='" + pelle.getAddress() + '\'' + '}';
        System.out.println(first);
        String second = "Student{id=1, name='Per Person', email='pelle@hotmail.com', " +
                "address='Presidentgatan 4'}";
        Assert.assertTrue(first.equals(second));
    }
}
