package com.products.payload;

import com.github.javafaker.Faker;
import com.products.constant.FilePathConstant;
import com.products.constant.KeyConstant;
import com.products.pojo.ProductsPojo;
import com.products.pojo.Rating;
import com.products.utilities.PropertyParser;

public class ProductPayload {
    public static Faker faker = new Faker();
    public static ProductsPojo payload = new ProductsPojo();
    public static Rating rating = new Rating();
    public static PropertyParser productData = new PropertyParser(FilePathConstant.PRODUCT_DATA_PATH);

    public static ProductsPojo setupData(){
        rating.setRate(Double.parseDouble(productData.getPropertyValue(KeyConstant.RATE)));
        rating.setCount(Integer.parseInt(productData.getPropertyValue(KeyConstant.COUNT)));
        payload.setTitle(productData.getPropertyValue(KeyConstant.TITLE));
        payload.setPrice(Double.parseDouble(productData.getPropertyValue(KeyConstant.PRICE)));
        payload.setDescription(productData.getPropertyValue(KeyConstant.DESCRIPTION));
        payload.setImage(productData.getPropertyValue(KeyConstant.IMAGE));
        payload.setCategory(productData.getPropertyValue(KeyConstant.CATEGORY));
        payload.setRating(rating);
        return payload;
    }

    public static ProductsPojo updateData(){
        rating.setRate(Double.parseDouble(productData.getPropertyValue(String.valueOf(KeyConstant.UPDATE_RATE))));
        rating.setCount(Integer.parseInt(productData.getPropertyValue(String.valueOf(KeyConstant.UPDATE_COUNT))));
        payload.setTitle(productData.getPropertyValue(KeyConstant.UPDATE_TITLE));
        payload.setPrice(Float.parseFloat(productData.getPropertyValue(String.valueOf(KeyConstant.UPDATE_PRICE))));
        payload.setDescription(productData.getPropertyValue(KeyConstant.UPDATE_DESCRIPTION));
        payload.setImage(productData.getPropertyValue(KeyConstant.UPDATE_IMAGE));
        payload.setCategory(productData.getPropertyValue(KeyConstant.UPDATE_CATEGORY));
        payload.setRating(rating);
        return payload;
    }
}
