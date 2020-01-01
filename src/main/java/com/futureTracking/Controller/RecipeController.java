/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futureTracking.Controller;

import com.futureTracking.Entity.Recipe;
import com.futureTracking.Repository.RecipeRepository;
import com.futureTracking.Utils.JasperPDF;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @ResponseBody
    @GetMapping("/getRecipes/{idRecipe}")
    public ResponseEntity<Resource> RecipeByIdExportToPDF(@PathVariable @NotNull @DecimalMin("0") Integer idRecipe) throws IOException {

        logger.debug("Appel de la méthode: RecipeByIdExportToPDF(Integer idRecipe) via url: /getRecipes/" + idRecipe);

        Optional<Recipe> recipesIterable = this.recipeRepository.findById(idRecipe);

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        Recipe recipe = recipesIterable.get();

        String JSONObject = gson.toJson(recipe);

        JasperPDF.ExportPDF(JSONObject);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Expires", "0");
        headers.add("Content-Type", "application/pdf");
        headers.add("Content-Disposition", "attachment; filename=" + recipe.getName() + ".pdf");

        ByteArrayResource resource;
        resource = JasperPDF.downloadReport();

        File file = new File(System.getProperty("java.io.tmpdir") + "/ReportRecipeJasperPDF");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(resource);
    }

}
