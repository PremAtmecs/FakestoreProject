package com.products.payload;

import com.github.javafaker.Faker;
import com.products.pojo.ProductsPojo;
import com.products.pojo.Rating;

public class ProductPayload {
    public static Faker faker = new Faker();
    public static ProductsPojo payload = new ProductsPojo();
    public static Rating rating = new Rating();

    public static ProductsPojo setupData(){
        rating.setRate(3.99);
        rating.setCount(11);
        payload.setTitle("test product");
        payload.setPrice((float) 14.1);
        payload.setDescription("lorem ipsum set");
        payload.setImage("https://i.pravatar.cc");
        payload.setCategory("electronic");
        payload.setRating(rating);
        return payload;
    }

    public static ProductsPojo updateData(){
        rating.setRate(3.11);
        rating.setCount(14);
        payload.setTitle("test product");
        payload.setPrice((float) 16.1);
        payload.setDescription("lorem ipsum set");
        payload.setImage("https://i.pravatar.cc");
        payload.setCategory("jewellery");
        payload.setRating(rating);
        return payload;
    }
}
