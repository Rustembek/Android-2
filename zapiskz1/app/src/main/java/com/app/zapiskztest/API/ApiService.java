package com.app.zapiskztest.API;

import com.app.zapiskztest.Model.Info;
import com.app.zapiskztest.Model.SalonList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/rest/v1/salon/getPopular")
    Call<SalonList> getSalonsPopular();

    @GET("/rest/v1/salon/getRecommended")
    Call<SalonList> getSalonsRecommended();

    @GET("/rest/v1/salon/getRecentlyAdded")
    Call<SalonList> getSalonsRecentlyAdded();

    @GET("/rest/v1/salon/page")
    Call<Info> getSalonInfo(@Query("id") Integer chosedId);
}
