/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futureTracking.Repository;

import com.futureTracking.Entity.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author maxim
 */
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
