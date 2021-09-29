package com.m.edutabtest.models;

public class Airline
{
    private int id;

    private String name;

    private String country;

    private String logo;

    private String slogan;

    private String head_quaters;

    private String website;

    private String established;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    public void setLogo(String logo){
        this.logo = logo;
    }
    public String getLogo(){
        return this.logo;
    }
    public void setSlogan(String slogan){
        this.slogan = slogan;
    }
    public String getSlogan(){
        return this.slogan;
    }
    public void setHead_quaters(String head_quaters){
        this.head_quaters = head_quaters;
    }
    public String getHead_quaters(){
        return this.head_quaters;
    }
    public void setWebsite(String website){
        this.website = website;
    }
    public String getWebsite(){
        return this.website;
    }
    public void setEstablished(String established){
        this.established = established;
    }
    public String getEstablished(){
        return this.established;
    }
}
