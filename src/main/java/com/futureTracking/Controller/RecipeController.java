/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futureTracking.Controller;

import com.futureTracking.Entity.Recipe;
import com.futureTracking.Repository.RecipeRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author maxim
 */

@CrossOrigin(origins = "*")
@RestController
public class RecipeController {
    
    static Logger logger = Logger.getLogger(RecipeController.class);

    @Autowired
    private RecipeRepository recipeRepository;

    @ResponseBody
    @GetMapping("/getRecipes")
    public String showAllRecipes() {
        
        logger.debug("Appel de la méthode: showAllRecipes() via url: /getRecipes");

        List<Recipe> recipes = new ArrayList<>();
        Iterable<Recipe> recipesIterable = this.recipeRepository.findAll();
        
        recipesIterable.forEach(recipes::add);

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        String JSONObject = gson.toJson(recipes);
        

        return JSONObject;
    }
}
