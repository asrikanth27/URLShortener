package com.example.srikanth.urlshortener;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.OPTIONS;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * Created by srikanth on 25/5/17.
 */

public interface UrlShortenerService {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/urlshortener/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Headers("Content-Type: application/json")
    @POST("v1/url?key=AIzaSyANF276a1z0JrDNOFKLRUFHLIzkzeMb4-k")
        Call<LongToShortUrlHelper> getShortUrl(@Body JsonObject longUrl);

    @GET("v1/url")
        Call<ShortToLongUrlHelper> getLongUrl(@Query("key") String apikey, @Query("shortUrl") String shortUrl);

}
