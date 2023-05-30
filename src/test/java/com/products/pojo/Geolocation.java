package com.products.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geolocation {
    private String lat;
    @JsonProperty("long")
    private String mylong;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getMylong() {
        return mylong;
    }

    public void setMylong(String mylong) {
        this.mylong = mylong;
    }
}
