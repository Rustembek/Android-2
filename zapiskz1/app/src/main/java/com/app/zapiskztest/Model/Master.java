package com.app.zapiskztest.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Master {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("experience")
    @Expose
    private String experience;
    @SerializedName("profession")
    @Expose
    private String profession;
    @SerializedName("serviceIds")
    @Expose
    private List<Integer> serviceIds = null;
    @SerializedName("avatarUrl")
    @Expose
    private String avatarUrl;
    @SerializedName("workingDays")
    @Expose
    private List<Object> workingDays = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<Integer> getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(List<Integer> serviceIds) {
        this.serviceIds = serviceIds;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public List<Object> getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(List<Object> workingDays) {
        this.workingDays = workingDays;
    }

}