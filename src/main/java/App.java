
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import model.Animals;
import model.Endangered;
import model.Sightings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        get("wildlife-new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "wildlife-new.hbs");
        }, new HandlebarsTemplateEngine());

        post("/wildlife-new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            String name = request.queryParams("name");
            String location = request.queryParams("location");
            String rangername = request.queryParams("ranger");
            String age = request.queryParams("age");
            String health = request.queryParams("health");
            if(health == null || age == null){
                Animals animals = new Animals(animalId,name);
                animals.save();
            }else{
                Endangered endangered = new Endangered(animalId,name,age,health);
                endangered.saveEndangered();
                //endangered.saveAge(age);
                //endangered.saveHealth(health);
            }
            Sightings sightings = new Sightings(animalId, location, rangername);
            sightings.save();
            response.redirect("/all-animals");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/all-animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animals> animals = Animals.all();
            List<Endangered> endangered = Endangered.all();
            List<Sightings> sightings = Sightings.all();
            model.put("animals", animals);
            model.put("endangered", endangered);
            model.put("sightings", sightings);
            return  new ModelAndView(model, "all-animals.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sightings> sightings = Sightings.all();
            model.put("sightings", sightings);
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
