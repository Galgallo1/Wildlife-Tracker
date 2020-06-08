package model;

import org.sql2o.Connection;

import java.util.List;

public class Animals extends Wildlife {
    public static final String DATABASE_TYPE = "animal";

    public Animals (String name){
        this.name = name;
        this.type = DATABASE_TYPE;
    }

    public static List<Animals> all (){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT FROM wildlife WHERE type='animal'";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animals.class);
        }
    }
}
