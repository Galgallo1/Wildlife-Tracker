import jdk.dynalink.linker.MethodHandleTransformer;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        get("wildlife/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "new_wildlife.hbs");
        }, new HandlebarsTemplateEngine());

        /*post("/wildlife/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

        }, new HandlebarsTemplateEngine());*/
    }

}
