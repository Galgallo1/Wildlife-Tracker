package model;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalsTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void getName() {
        Animals animal = new Animals("Lion");
        assertEquals("Lion", animal.getName());
    }

    @Test
    public void all() {
        Animals animalTest = new Animals("Lion");
        animalTest.save();
        Animals animalTest1 = new Animals("Cat");
        animalTest1.save();
        assertEquals(2, Animals.all().size());
        
    }

    @Test
    public void getId() {


    }

    @Test
    public void getType() {
        Animals animals = new Animals("Lion");
        assertEquals("animal", animals.getType());
    }

    @Test
    public void testEquals() {
        Animals animal = new Animals("Lion");
        Animals animal1 = new Animals("Lion");
        assertTrue(animal.equals(animal1));
    }

   @Test
    public void save() {
        Animals animaltest = new Animals("cat");
        animaltest.save();
       assertEquals(Animals.all().get(0), animaltest);
    }
}