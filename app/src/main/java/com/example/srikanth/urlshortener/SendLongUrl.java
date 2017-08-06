package com.example.srikanth.urlshortener;

import com.google.gson.annotations.SerializedName;

/**
 * Created by srikanth on 30/5/17.
 */

public class SendLongUrl {

    @SerializedName("longUrl") String longurl;

    SendLongUrl(String lUrl){
        longurl = lUrl;
    }
}
