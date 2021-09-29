package com.m.edutabtest.models;

public class DataOffliner {
    private String _id;
    private String trips;
    private String id_airline;
    private String name_airline;
    private String country;
    private String logo;
    private String slogan;
    private String head_quaters;
    private String website;
    private String established;
    private String name;

    public DataOffliner(String _id, String trips, String id_airline,
                        String name_airline, String country, String logo,
                        String slogan, String head_quaters, String website,
                        String established, String name) {
        this._id = _id;
        this.trips = trips;
        this.id_airline = id_airline;
        this.name_airline = name_airline;
        this.country = country;
        this.logo = logo;
        this.slogan = slogan;
        this.head_quaters = head_quaters;
        this.website = website;
        this.established = established;
        this.name = name;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrips() {
        return trips;
    }

    public void setTrips(String trips) {
        this.trips = trips;
    }

    public String getId_airline() {
        return id_airline;
    }

    public void setId_airline(String id_airline) {
        this.id_airline = id_airline;
    }

    public String getName_airline() {
        return name_airline;
    }

    public void setName_airline(String name_airline) {
        this.name_airline = name_airline;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getHead_quaters() {
        return head_quaters;
    }

    public void setHead_quaters(String head_quaters) {
        this.head_quaters = head_quaters;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEstablished() {
        return established;
    }

    public void setEstablished(String established) {
        this.established = established;
    }
}
