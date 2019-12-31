/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futureTracking.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.log4j.Logger;

/**
 *
 * @author maxim
 */
@Entity
@Table(name = "RECIPE")
public class Recipe implements Serializable {

    static Logger logger = Logger.getLogger(Recipe.class);

    @Id
    @GeneratedValue
    @Column(name = "id_recipe")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private int category;

    @Column(name = "description")
    private String description;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "person")
    private int person;

    @Column(name = "duration")
    private int duration;

    @Column(name = "level")
    private int level;

    @Column(name = "url")
    private String url;

    public Recipe() {

    }

    public int getId() {
        logger.debug("getId()");
        return id;
    }

    public void setId(int id) {
        logger.debug("setId(int id)");
        this.id = id;
    }

    public String getName() {
        logger.debug("getName()");
        return name;
    }

    public void setName(String name) {
        logger.debug("setName(String name)");
        this.name = name;
    }

    public int getCategory() {
        logger.debug("getCategory()");
        return category;
    }

    public void setCategory(int category) {
        logger.debug("setCategory(int category)");
        this.category = category;
    }

    public String getDescription() {
        logger.debug("getDescription()");
        return description;
    }

    public void setDescription(String description) {
        logger.debug("setDescription(String description)");
        this.description = description;
    }

    public String getIngredients() {
        logger.debug("getIngredients()");
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        logger.debug("setIngredients(String ingredients)");
        this.ingredients = ingredients;
    }

    public int getPerson() {
        logger.debug("getPerson()");
        return person;
    }

    public void setPerson(int person) {
        logger.debug("setPerson(int person)");
        this.person = person;
    }

    public int getDuration() {
        logger.debug("getDuration()");
        return duration;
    }

    public void setDuration(int duration) {
        logger.debug("setDuration(int duration)");
        this.duration = duration;
    }

    public int getLevel() {
        logger.debug("getId()");
        return level;
    }

    public void setLevel(int level) {
        logger.debug("setLevel(int level)");
        this.level = level;
    }

    public String getUrl() {
        logger.debug("getUrl()");
        return url;
    }

    public void setUrl(String url) {
        logger.debug("setUrl(String url)");
        this.url = url;
    }

}
