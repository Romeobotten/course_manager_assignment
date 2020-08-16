package se.lexicon.course_manager_assignment.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class StudentTest {

    Student pelle = new Student(1, "Per Person", "pelle@hotmail.com","Presidentgatan 4");
    Student kalle = new Student(2, "Karl Kalson", "kalle@hotmail.com", "Kejsargatan 21");
    Student number3 = new Student(3, "Treben Ek", "null@gmail.com", "Gatan 3");

    @Test
    void testGetId() {
        int number1 = pelle.getId();
        int number2 = kalle.getId();
//        System.out.println(number1 + " - " + number2);
        Assert.assertTrue(number1 + 1 == number2);
    }


    @Test
    void testSetAndGetNameEmailAndAddress() {
        String b3 = number3.getName();
        number3.setName("Bo Ek");
        number3.setEmail("bosse@algonet.se");
        number3.setAddress("Åvägen 3");
        Assert.assertTrue(b3 == "Treben Ek" && "Bo Ek" == number3.getName() &&
                "bosse@algonet.se" == number3.getEmail() && "Åvägen 3" == number3.getAddress());
    }

    @Test
    void testEquals() {
        Student per = pelle;
        Assert.assertEquals(pelle, per);
    }

    @Test
    void testHashCode() {
        Student karl = kalle;
        Assert.assertTrue(karl.hashCode() == kalle.hashCode());
    }

    @Test
    void testToString() {
        String first = "Student{" + "id=" + pelle.getId() +
                ", name='" + pelle.getName() + '\'' +
                ", email='" + pelle.getEmail() + '\'' +
                ", address='" + pelle.getAddress() + '\'' + '}';
//        System.out.println(first);
        String second = "Student{id=1, name='Per Person', email='pelle@hotmail.com', " +
                "address='Presidentgatan 4'}";
        Assert.assertTrue(first.equals(second));
    }
}
