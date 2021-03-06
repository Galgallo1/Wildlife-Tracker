package model;

import org.sql2o.Connection;
import java.util.List;

public class Endangered extends Wildlife{
   /* public static final String HEALTHY ="healthy";
    public static final String OKAY ="okay";
    public static final String ILL ="ill";
    public static final String NEWBORN ="newborn";
    public static final String YOUNG ="young";
    public static final String ADULT ="adult";*/

    public static final String DATABASE_TYPE = "endangered";

    private String age;
    private String health;

    public Endangered(int id,String name, String age, String health){
        this.id=id;
        this.name = name;
        this.type = DATABASE_TYPE;
        this.age=age;
        this.health=health;
    }

    public String getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }

    public static List<Endangered> all(){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM animalz WHERE type='endangered'";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Endangered.class);
        }
    }

    public void saveAge(String age){
        try(Connection con = DB.sql2o.open()){
            String update = "UPDATE animalz SET age=:age WHERE id=:id";
            con.createQuery(update)
                    .addParameter("age", this.age)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }

    public void saveHealth(String health){
        String sql ="UPDATE animalz SET health=:health WHERE id=:id";
        try (Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("health", this.health)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }


    public void saveEndangered() {
        try (Connection con = DB.sql2o.open()) {
            String query = "INSERT INTO animalz(id, name, type, age, health) VALUES(:id,:name, :type, :age, :health)";
            this.id = (int)con.createQuery(query, true)
                    .addParameter("id", this.id)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .addParameter("age", this.age)
                    .addParameter("health", this.health)
                    .executeUpdate()
                    .getKey();

        }

    }
}
