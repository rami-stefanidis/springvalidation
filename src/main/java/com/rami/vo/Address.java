package com.rami.vo;

public class Address {
    private String name;

    private String street;

    private int zipCode;

    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", zipCode=" + zipCode +
                ", country='" + country + '\'' +
                '}';
    }
}
