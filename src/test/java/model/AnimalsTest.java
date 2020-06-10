package model;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalsTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void getName() {
        Animals animal = new Animals(1,"Lion");
        assertEquals("Lion", animal.getName());
    }

    @Test
    public void all() {
        Animals animalTest = new Animals(1,"Lion");
        animalTest.save();
        Animals animalTest1 = new Animals(1,"Cat");
        animalTest1.save();
        assertEquals(2, Animals.all().size());
        
    }

    @Test
    public void getId() {


    }

    @Test
    public void getType() {
        Animals animals = new Animals(1,"Lion");
        assertEquals("animal", animals.getType());
    }

    @Test
    public void testEquals() {
        Animals animal = new Animals(1,"Lion");
        Animals animal1 = new Animals(1,"Lion");
        assertTrue(animal.equals(animal1));
    }

   @Test
    public void save() {
        Animals animalTest = new Animals(1,"cat");
        animalTest.save();
        assertTrue(Animals.all().get(0).equals(animalTest));
        //catch(NullPointerException e) {
          //  System.out.println("NullPointerException thrown!");


    }
}