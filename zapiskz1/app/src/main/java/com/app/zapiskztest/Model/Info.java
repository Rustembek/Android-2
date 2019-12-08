package com.app.zapiskztest.Model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("salon")
    @Expose
    private SalonInfo salon_info;
    @SerializedName("masters")
    @Expose
    private ArrayList<Master> masters = null;
    @SerializedName("services")
    @Expose
    private List<Service> services = null;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("instagram")
    @Expose
    private Instagram instagram;

    public SalonInfo getSalon() {
        return salon_info;
    }

    public void setSalon(SalonInfo salon_info) {
        this.salon_info = salon_info;
    }

    public ArrayList<Master> getMasters() {
        return masters;
    }

    public void setMasters(ArrayList<Master> masters) {
        this.masters = masters;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Instagram getInstagram() {
        return instagram;
    }

    public void setInstagram(Instagram instagram) {
        this.instagram = instagram;
    }

}