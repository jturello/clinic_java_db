import java.util.Map;
import java.util.HashMap;
import java.util.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    // staticFileLocation("/public");
    // String layout = "templates/layout.vtl";
    //
    // get("/", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //
    //   model.put("categories", Category.all());
    //   model.put("template", "templates/categories.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    //
    //   get("/categories", (request, response) -> {
    //     HashMap<String, Object> model = new HashMap<String, Object>();
    //     model.put("categories", Category.all());
    //     model.put("template", "templates/categories.vtl");
    //     return new ModelAndView(model, layout);
    //   }, new VelocityTemplateEngine());
    //
    //
    //   post("/categories", (request,response) -> {
    //       HashMap<String, Object> model = new HashMap<String, Object>();
    //       String categoryName = request.queryParams("categoryName");
    //       Category newCategory = new Category(categoryName);
    //       newCategory.save();
    //       List<Category> myCategories = Category.all();
    //       model.put("categories", myCategories);
    //       model.put("template", "templates/categories.vtl");
    //       return new ModelAndView(model, layout);
    //     }, new VelocityTemplateEngine());
    //
    //
    //   get("/categories/new", (request, response) -> {
    //      HashMap<String, Object> model = new HashMap<String, Object>();
    //      model.put("template", "templates/category-form.vtl");
    //      return new ModelAndView(model, layout);
    //    }, new VelocityTemplateEngine());
    //
    //  get("/categories/:id", (request, response) -> {
    //    HashMap<String, Object> model = new HashMap<String, Object>();
    //    Category category = Category.find(Integer.parseInt(request.params(":id")));
    //    List<Task> tasks = category.getTasks();
    //    model.put("category", category);
    //    model.put("tasks", tasks);
    //    model.put("template", "templates/category.vtl");
    //    return new ModelAndView(model, layout);
    //  }, new VelocityTemplateEngine());
    //
    //  get("/tasks/:id", (request, response) -> {
    //    HashMap<String, Object> model = new HashMap<String, Object>();
    //    Task task = Task.find(Integer.parseInt(request.params(":id")));
    //    model.put("task", task);
    //    model.put("template", "templates/task.vtl");
    //    return new ModelAndView(model, layout);
    //  }, new VelocityTemplateEngine());
    //
    //  get("/categories/:id/tasks/new", (request, response) -> {
    //    HashMap<String, Object> model = new HashMap<String, Object>();
    //
    //    Category category = Category.find(Integer.parseInt(request.params(":id")));
    //
    //    model.put("category", category);
    //    model.put("template", "templates/category-task-form.vtl");
    //    return new ModelAndView(model, layout);
    //  }, new VelocityTemplateEngine());
    //
    //
    //  delete("/categories/delete", (request, response) -> {
    //    HashMap<String, Object> model = new HashMap<String, Object>();
    //    Category.deleteAll();
    //
    //    model.put("categories", Category.all());
    //    model.put("template", "templates/categories.vtl");
    //    return new ModelAndView(model, layout);
    //  }, new VelocityTemplateEngine());
    //
    //
    // post("/tasks", (request,response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //
    //   Category category = Category.find(Integer.parseInt(request.queryParams("categoryId")));
    //
    //   String description = request.queryParams("description");
    //   Task newTask = new Task(description, Integer.parseInt(request.queryParams("categoryId")));
    //
    //   newTask.save();
    //   model.put("category", category);
    //   model.put("template", "templates/category.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
  }
}
