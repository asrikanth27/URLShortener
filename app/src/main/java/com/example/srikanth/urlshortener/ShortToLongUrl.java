package com.example.srikanth.urlshortener;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by srikanth on 26/5/17.
 */

public class ShortToLongUrl implements Callback<ShortToLongUrlHelper> {

    private Context context;
    private UrlShortenerService service;
    private MainActivity mainActivity;
    private String resultUrl = "";

    public ShortToLongUrl(Context context, UrlShortenerService service, MainActivity mainActivity){
        this.context = context;
        this.service = service;
        this.mainActivity = mainActivity;
    }

    public void performConversion(String url){
        Call<ShortToLongUrlHelper> call = service.getLongUrl(context.getString(R.string.APIKEY), url);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ShortToLongUrlHelper> call, Response<ShortToLongUrlHelper> response) {
        ShortToLongUrlHelper longUrlHelper = response.body();
        if(longUrlHelper!=null && longUrlHelper.getStatus().equalsIgnoreCase("ok")){
            resultUrl = longUrlHelper.getLongUrl();
            mainActivity.textView.setText(resultUrl);
        }
        else{
            Toast.makeText(context, "Null object received", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFailure(Call<ShortToLongUrlHelper> call, Throwable t) {
        Toast.makeText(context, "Unable to fetch URL", Toast.LENGTH_SHORT).show();
        Log.i("Main Activity", "Call Failed", t);
    }
}
