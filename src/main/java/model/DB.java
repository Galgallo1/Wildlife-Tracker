package model;

import org.sql2o.Sql2o;

public class DB {
    //public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "gaalo", "1234");
    String connectionString = "jdbc:postgresql://ec2-3-231-16-122.compute-1.amazonaws.com:5432/dfkv24r3dm8do0"; //!
    Sql2o sql2o = new Sql2o(connectionString, "dgcktkncwavuqf", "5426a79a23c52e020bd58eb0173b8dba44d741062270fde0cca4a6ce2935d20e"); //!
}
