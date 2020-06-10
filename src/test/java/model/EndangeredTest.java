package model;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void getAge() {
        Endangered endangered = new Endangered(1,"rhino","young","okay");
        endangered.saveEndangered();
        //endangered.saveAge("young");
        assertEquals("young",Endangered.all().get(0).getAge());
    }

    @Test
    public void getHealth() {
        Endangered endangered = new Endangered(1,"rhino","young","okay");
        endangered.saveEndangered();
        endangered.saveHealth("okay");
        assertEquals("okay", endangered.getHealth());
    }

    @Test
    public void all() {
        Endangered endangered = new Endangered(1,"rhino","young","okay");
        endangered.saveEndangered();
        assertEquals(endangered, Endangered.all().get(0));
    }

    @Test
    public void saveAge() {
        Endangered endangered = new Endangered(1,"rhino","young","okay");
        endangered.saveEndangered();
        endangered.saveAge("young");
        assertEquals("young", Endangered.all().get(0).getAge());
    }

    @Test
    public void saveHealth() {
        Endangered endangered = new Endangered(1,"rhino","young","okay");
        endangered.saveEndangered();
        endangered.saveHealth("okay");
        assertEquals("okay", Endangered.all().get(0).getHealth());
    }
}