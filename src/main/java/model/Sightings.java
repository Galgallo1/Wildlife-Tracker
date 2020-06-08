package model;

import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Sightings {
    private int animal_id;
    private String location;
    private String ranger_name;
    private int id;

    public int getId() {
        return id;
    }

    public Sightings(int animal_id, String location, String ranger_name) {
        this.animal_id = animal_id;
        this.location = location;
        this.ranger_name = ranger_name;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public String getLocation() {
        return location;
    }

    public String getRanger_name() {
        return ranger_name;
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO sightings(animal_id, location, ranger_name) VALUES(:animal_id, :location,:ranger_name)";
            this.id =(int) con.createQuery(sql,true)
                    .addParameter("animal_id", this.animal_id)
                    .addParameter("location",this.location)
                    .addParameter("ranger_name",this.ranger_name)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Sightings> all(){
        String querySightings = "SELECT * FROM sightings";
        try (Connection con =DB.sql2o.open()){
            return con.createQuery(querySightings)
                    .executeAndFetch(Sightings.class);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sightings sightings = (Sightings) o;
        return animal_id == sightings.animal_id &&
                Objects.equals(location, sightings.location) &&
                Objects.equals(ranger_name, sightings.ranger_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animal_id, location, ranger_name);
    }
}
