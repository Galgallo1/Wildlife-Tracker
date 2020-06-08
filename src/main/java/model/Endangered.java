package model;

import org.sql2o.Connection;
import java.util.List;

public class Endangered extends Wildlife{
    public static final String HEALTHY ="healthy";
    public static final String OKAY ="okay";
    public static final String ILL ="ill";
    public static final String NEWBORN ="newborn";
    public static final String YOUNG ="young";
    public static final String ADULT ="adult";

    public static final String DATABASE_TYPE = "endangered";

    private int age;
    private String health;

    public Endangered(String name){
        this.name = name;
        this.type = DATABASE_TYPE;
    }

    public int getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }

    public static List<Endangered> all(){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT FROM wildlife WHERE type='endangered'";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Endangered.class);
        }
    }

    public void saveAge(int age){
        try(Connection con = DB.sql2o.open()){
            String update = "UPDATE wildlife SET age=:age WHERE id=:id";
            con.createQuery(update)
                    .addParameter("age", this.age)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }

    public void saveHealth(String health){
        String sql ="UPDATE wildlife SET health=:health WHERE id=:id";
        try (Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("health", health)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }


    /*public void save() {
        try (Connection con = DB.sql2o.open()) {
            String query = "INSERT INTO wildlife(name, type) VALUES(:name,:type)";
            con.createQuery(query, true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();

        }

    }*/
}
