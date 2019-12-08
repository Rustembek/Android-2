package com.app.zapiskztest.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Instagram {

    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("postsCount")
    @Expose
    private int postsCount;
    @SerializedName("imageUrls")
    @Expose
    private List<String> imageUrls = null;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(int postsCount) {
        this.postsCount = postsCount;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

}