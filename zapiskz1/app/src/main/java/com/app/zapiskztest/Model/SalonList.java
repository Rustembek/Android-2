package com.app.zapiskztest.Model;

import java.util.ArrayList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SalonList {
    @SerializedName("salons")
    @Expose
    // private List<Salon> salons = null;
    private ArrayList<Salon> salons = new ArrayList<>();

    public ArrayList<Salon> getSalons() {
        return salons;
    }

    /*public void setSalons(List<Salon> salons) {
        this.salons = salons;
    }
*/
    public void setSalons(ArrayList<Salon> salons) {
        this.salons = salons;
    }
}
