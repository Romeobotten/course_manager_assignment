package se.lexicon.course_manager_assignment.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class StudentTest {
    Student pelle = new Student("Per Person", "pelle@hotmail.com","Presidentgatan 4");
    Student kalle = new Student("Karl Kalson", "kalle@hotmail.com", "Kejsargatan 21");

    @Test
    void getId() {
    }

    @Test
    void getName() {
        String name = kalle.getName();
        Assert.assertTrue(name == "Karl Kalson");
    }

    @Test
    void setName() {
    }

    @Test
    void getEmail() {
        String email = pelle.getEmail();
        Assert.assertTrue(email == "pelle@hotmail.com");
    }

    @Test
    void setEmail() {
    }

    @Test
    void getAddress() {
        String address = pelle.getAddress();
        Assert.assertTrue(address == "Presidentgatan 4");
    }

    @Test
    void setAddress() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
    }
}
