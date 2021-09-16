/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khangnt.dto;

import java.io.Serializable;

/**
 *
 * @author ACER
 */
public class ResourceDTO implements Serializable {

    private int id;
    private String name;
    private String color;
    private int quantity;
    private int usingDate;
    private String description;
    private String categoryName;
    private String categoryDescription;

    public ResourceDTO() {
    }

    public ResourceDTO(int id, String name, String color, int quantity, int usingDate, String description, String categoryName, String categoryDescription) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.quantity = quantity;
        this.usingDate = usingDate;
        this.description = description;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the usingDate
     */
    public int getUsingDate() {
        return usingDate;
    }

    /**
     * @param usingDate the usingDate to set
     */
    public void setUsingDate(int usingDate) {
        this.usingDate = usingDate;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return the categoryDescription
     */
    public String getCategoryDescription() {
        return categoryDescription;
    }

    /**
     * @param categoryDescription the categoryDescription to set
     */
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

}
