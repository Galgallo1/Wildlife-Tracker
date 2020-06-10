package model;

import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {
    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "gaalo", "1234");
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteWildlifeQuery = "DELETE FROM animalz *";
            String deleteSightings = "DELETE FROM sightings *";
            con.createQuery(deleteWildlifeQuery).executeUpdate();
            con.createQuery(deleteSightings).executeUpdate();


        }
    }

}
