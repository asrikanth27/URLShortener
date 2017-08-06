package com.example.srikanth.urlshortener;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

/**
 * Created by srikanth on 26/5/17.
 */

public class LongToShortUrl implements Callback<LongToShortUrlHelper> {

    private Context context;
    private UrlShortenerService service;
    private String resultUrl = "";
    private MainActivity mainActivity;
    public LongToShortUrl(Context context, UrlShortenerService service, MainActivity mainActivity){
        this.context = context;
        this.service = service;
        this.mainActivity = mainActivity;
    }

    public void performConversion(String url){
        //SendLongUrl u = new SendLongUrl(context.getString(R.string.APIKEY));
        JsonObject json = new JsonObject();
        json.addProperty("longUrl", url);
        Call<LongToShortUrlHelper> call = service.getShortUrl(json);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<LongToShortUrlHelper> call, Response<LongToShortUrlHelper> response) {
        LongToShortUrlHelper longUrlHelper = response.body();
        if(longUrlHelper!=null){
            resultUrl = longUrlHelper.getId();
            mainActivity.textView.setText(resultUrl);
        }
        else{
            Log.i("LongToShortUrl-message", response.message());
            Log.i("LongToShortUrl-error", response.errorBody().toString());
            Toast.makeText(context, "Null object received", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFailure(Call<LongToShortUrlHelper> call, Throwable t) {
        Toast.makeText(context, "Unable to fetch URL", Toast.LENGTH_SHORT).show();
        Log.i("Main Activity", "Call Failed", t);
    }
}
