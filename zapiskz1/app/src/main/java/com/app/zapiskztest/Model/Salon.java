package com.app.zapiskztest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Salon {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("checkRating")
    @Expose
    private Double checkRating;

    @SerializedName("pictureUrl")
    @Expose
    private String pictureUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Salon withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Salon withName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Salon withType(String type) {
        this.type = type;
        return this;
    }

    public Double getCheckRating() {
        return checkRating;
    }

    public void setCheckRating(Double checkRating) {
        this.checkRating = checkRating;
    }

    public Salon withCheckRating(Double checkRating) {
        this.checkRating = checkRating;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Salon withPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

}