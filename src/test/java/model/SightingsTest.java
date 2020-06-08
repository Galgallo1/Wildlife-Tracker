package model;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SightingsTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void getId() {
        Sightings sightings = new Sightings(1, "Area 1", "Ali");
        assertEquals(1, sightings.getAnimal_id());
    }

    @Test
    public void getAnimal_id() {
        Sightings sightings = new Sightings(1, "Area 1", "Ali");
        assertEquals(1, sightings.getAnimal_id());
    }

    @Test
    public void getLocation() {
        Sightings sightings = new Sightings(1, "Area 1", "Ali");
        assertEquals("Area 1", sightings.getLocation());
    }

    @Test
    public void getRanger_name() {
        Sightings sightings = new Sightings(1, "Area 1", "Ali");
        assertEquals("Ali", sightings.getRanger_name());
    }

    @Test
    public void save() {
        Sightings sightings = new Sightings(1, "Area 1", "Ali");
        sightings.save();
        assertEquals(sightings, Sightings.all().get(0));
    }

    @Test
    public void all() {
        Sightings sightings1 = new Sightings(1, "Area 3", "Aziz");
        sightings1.save();
        Sightings sightings2 = new Sightings(1, "abdi", "Alio");
        sightings2.save();
        assertEquals(2, Sightings.all().size());

    }

    @Test
    public void testEquals() {
        Sightings sightings1 = new Sightings(1, "Area 3", "Aziz");
        Sightings sightings2 = new Sightings(1, "Area 3", "Aziz");
        assertTrue(sightings1.equals(sightings2));
    }
}