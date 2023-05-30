package com.products.payload;

import com.github.javafaker.Faker;
import com.products.pojo.*;

public class UserPayload {
    public static UserPojo userPojo = new UserPojo();
    public static Name name = new Name();
    public static Address address = new Address();
    public static Geolocation geolocation = new Geolocation();
    public static Faker faker = new Faker();
    public static UserPojo setUserData(){


        geolocation.setLat(faker.random().hex());
        geolocation.setMylong(faker.random().hex());

        address.setCity(faker.nation().capitalCity());
        address.setStreet(faker.address().streetName());
        address.setNumber(faker.number().randomDigit());
        address.setZipcode(faker.code().ean13());
        address.setGeolocation(geolocation);

        name.setFirstname(faker.name().firstName());
        name.setLastname(faker.name().lastName());

        userPojo.setAddress(address);
        userPojo.setEmail(faker.internet().emailAddress());
        userPojo.setUsername(faker.internet().domainName());
        userPojo.setPassword(faker.internet().password());
        userPojo.setName(name);
        userPojo.setPhone(faker.phoneNumber().phoneNumber());

    return userPojo;


    }
}
