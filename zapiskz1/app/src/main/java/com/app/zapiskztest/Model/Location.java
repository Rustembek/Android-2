package com.app.zapiskztest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("markerX")
    @Expose
    private double markerX;
    @SerializedName("markerY")
    @Expose
    private double markerY;
    @SerializedName("centerX")
    @Expose
    private double centerX;
    @SerializedName("centerY")
    @Expose
    private double centerY;
    @SerializedName("zoom")
    @Expose
    private int zoom;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMarkerX() {
        return markerX;
    }

    public void setMarkerX(double markerX) {
        this.markerX = markerX;
    }

    public double getMarkerY() {
        return markerY;
    }

    public void setMarkerY(double markerY) {
        this.markerY = markerY;
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

}