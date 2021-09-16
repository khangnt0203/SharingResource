/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khangnt.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author ACER
 */
public class RentalDTO implements Serializable {

    private int id;
    private int resourceId;
    private int userId;
    private int numberRentalDay;
    private String resourceName;
    private String userName;
    private Date rentDate;
    private String status;

    public RentalDTO() {
    }

    public RentalDTO(int resourceId, int userId, int numberRentalDay, String status) {
        this.resourceId = resourceId;
        this.userId = userId;
        this.numberRentalDay = numberRentalDay;
        this.status = status;
    }

    public RentalDTO(int id, String resourceName, String userName, Date rentDate, String status) {
        this.id = id;
        this.resourceName = resourceName;
        this.userName = userName;
        this.rentDate = rentDate;
        this.status = status;
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
     * @return the resourceId
     */
    public int getResourceId() {
        return resourceId;
    }

    /**
     * @param resourceId the resourceId to set
     */
    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the numberRentalDay
     */
    public int getNumberRentalDay() {
        return numberRentalDay;
    }

    /**
     * @param numberRentalDay the numberRentalDay to set
     */
    public void setNumberRentalDay(int numberRentalDay) {
        this.numberRentalDay = numberRentalDay;
    }

    /**
     * @return the resourceName
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * @param resourceName the resourceName to set
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the rentDate
     */
    public Date getRentDate() {
        return rentDate;
    }

    /**
     * @param rentDate the rentDate to set
     */
    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
