package com.example.srikanth.urlshortener;

/**
 * Created by srikanth on 25/5/17.
 */

public class ShortToLongUrlHelper {
    private String kind;
    private String id;
    private String longUrl;
    private String status;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
