package com.coding.exam.directory.data.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

/**
 * Class to parse address from the response
 *
 * @author by katherine.sobejano on 10/21/2021.
 */
public class Address {

    @PrimaryKey
    @SerializedName("city")
    @Expose
    @NonNull
    private String city;
    @SerializedName("street_name")
    @Expose
    private String streetName;
    @SerializedName("street_address")
    @Expose
    private String streetAddress;
    @SerializedName("zip_code")
    @Expose
    private String zipCode;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("country")
    @Expose
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProfileAddress() {
        return streetAddress + " " + streetName + " " + city + " " + state + ",\n" + country + ", " + zipCode;
    }
}
