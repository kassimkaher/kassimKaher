package com.example.trip.model;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiInterface {


    @GET("/api/orders/oneway")

    Call <List<Tripjson>> getTrip(@Query("from") String from, @Query("to") String to, @Query("data") String dat, @Query("type") String type, @Query("chd") String chd, @Query("adt") String adt, @Query("Infant") String infant);

}