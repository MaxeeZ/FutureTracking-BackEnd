/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futureTracking.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maxim
 */
public class RecipeTest {

    @Test
    public void typeAnnotations() {
        // assert
        AssertAnnotations.assertType(
                Recipe.class, Entity.class, Table.class);
    }

    public RecipeTest() {
    }


    @Test
  public void entity() {
    // setup
    Entity a
    = ReflectTool.getClassAnnotation(Recipe.class, Entity.class);
 
    // assert
    Assert.assertEquals("", a.name());
  }
 
 
  @Test
  public void tableAnnotation() {
    // setup
    Table t
    = ReflectTool.getClassAnnotation(Recipe.class, Table.class);
 
    // assert
    Assert.assertEquals("RECIPE", t.name());
  }
 
 
  @Test
  public void idAnnotation() {
    // setup
    GeneratedValue a
    = ReflectTool.getFieldAnnotation(Recipe.class, "id", GeneratedValue.class);
 
    // assert
    Assert.assertEquals("", a.generator());
    Assert.assertEquals(GenerationType.AUTO, a.strategy());
  }
 
 
  @Test
  public void nameAnnotation() {
    // setup
    Column c
    = ReflectTool.getFieldAnnotation(Recipe.class, "name", Column.class);
 
    // assert
    Assert.assertEquals("name", c.name());
  }
 
 
  @Test
  public void categoryAnnotation() {
    // setup
    Column c
    = ReflectTool.getFieldAnnotation(Recipe.class, "category", Column.class);
 
    // assert
    Assert.assertEquals("category", c.name());
  }
  
  @Test
  public void descriptionAnnotation() {
    // setup
    Column c
    = ReflectTool.getFieldAnnotation(Recipe.class, "description", Column.class);
 
    // assert
    Assert.assertEquals("description", c.name());
  }
  
  @Test
  public void ingredientsAnnotation() {
    // setup
    Column c
    = ReflectTool.getFieldAnnotation(Recipe.class, "ingredients", Column.class);
 
    // assert
    Assert.assertEquals("ingredients", c.name());
  }
  
  @Test
  public void personAnnotation() {
    // setup
    Column c
    = ReflectTool.getFieldAnnotation(Recipe.class, "person", Column.class);
 
    // assert
    Assert.assertEquals("person", c.name());
  }
  
  @Test
  public void durationAnnotation() {
    // setup
    Column c
    = ReflectTool.getFieldAnnotation(Recipe.class, "duration", Column.class);
 
    // assert
    Assert.assertEquals("duration", c.name());
  }
  
  @Test
  public void levelAnnotation() {
    // setup
    Column c
    = ReflectTool.getFieldAnnotation(Recipe.class, "level", Column.class);
 
    // assert
    Assert.assertEquals("level", c.name());
  }
  
  @Test
  public void urlAnnotation() {
    // setup
    Column c
    = ReflectTool.getFieldAnnotation(Recipe.class, "url", Column.class);
 
    // assert
    Assert.assertEquals("url", c.name());
  }
   
}
