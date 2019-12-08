package com.app.zapiskztest.Model;
/*

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SalonInfo {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("workStartTime")
    @Expose
    private String workStartTime;
    @SerializedName("workEndTime")
    @Expose
    private String workEndTime;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("checkRating")
    @Expose
    private double checkRating;
    @SerializedName("instagramProfile")
    @Expose
    private String instagramProfile;
    @SerializedName("avatarUrl")
    @Expose
    private String avatarUrl;
    @SerializedName("reviewCount")
    @Expose
    private int reviewCount;
    @SerializedName("averageRating")
    @Expose
    private int averageRating;
    @SerializedName("phoneNumbers")
    @Expose
    private List<String> phoneNumbers = null;
    @SerializedName("todayReservationsCount")
    @Expose
    private Object todayReservationsCount;
    @SerializedName("pictures")
    @Expose
    private List<String> pictures = null;

    public int getAverageRating(){
        if (averageRating>0){
            return averageRating.toString();
        }
        return null;}
    public int getReviewCount(){
        if (averageRating!=null){
            return reviewCount.toString();
        }
        return null;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(String workStartTime) {
        this.workStartTime = workStartTime;
    }

    public String getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(String workEndTime) {
        this.workEndTime = workEndTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCheckRating() {
        return checkRating;
    }

    public void setCheckRating(double checkRating) {
        this.checkRating = checkRating;
    }

    public String getInstagramProfile() {
        return instagramProfile;
    }

    public void setInstagramProfile(String instagramProfile) {
        this.instagramProfile = instagramProfile;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Object getTodayReservationsCount() {
        return todayReservationsCount;
    }

    public void setTodayReservationsCount(Object todayReservationsCount) {
        this.todayReservationsCount = todayReservationsCount;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

}*/


import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SalonInfo {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("workStartTime")
    @Expose
    private String workStartTime;
    @SerializedName("workEndTime")
    @Expose
    private String workEndTime;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("checkRating")
    @Expose
    private Double checkRating;
    @SerializedName("instagramProfile")
    @Expose
    private String instagramProfile;
    @SerializedName("avatarUrl")
    @Expose
    private String avatarUrl;
    @SerializedName("reviewCount")
    @Expose
    private Integer reviewCount;
    @SerializedName("averageRating")
    @Expose
    private Double averageRating;
    @SerializedName("phoneNumbers")
    @Expose
    private List<String> phoneNumbers = null;
    @SerializedName("todayReservationsCount")
    @Expose
    private Object todayReservationsCount;
    @SerializedName("pictures")
    @Expose
    private ArrayList<String> pictures = null;

    public Integer getId() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(String workStartTime) {
        this.workStartTime = workStartTime;
    }

    public String getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(String workEndTime) {
        this.workEndTime = workEndTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getCheckRating() {
        return checkRating;
    }

    public void setCheckRating(double checkRating) {
        this.checkRating = checkRating;
    }

    public String getInstagramProfile() {
        if (instagramProfile!=null){
            return instagramProfile;
        }
        return "";
    }

    public void setInstagramProfile(String instagramProfile) {
        this.instagramProfile = instagramProfile;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getReviewCount() {
        if (reviewCount!=null){
            return reviewCount;
        }
        return 0;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Double getAverageRating() {
        if (averageRating!=null){
            return averageRating;
        }
        return 0.0;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Object getTodayReservationsCount() {
        return todayReservationsCount;
    }

    public void setTodayReservationsCount(Object todayReservationsCount) {
        this.todayReservationsCount = todayReservationsCount;
    }

    public ArrayList<String> getPictures() {
        return pictures;
    }

    public void setPictures(ArrayList<String> pictures) {
        this.pictures = pictures;
    }

}