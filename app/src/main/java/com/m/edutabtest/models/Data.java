package com.m.edutabtest.models;

import java.util.List;

public class Data {
    private String _id;

    private String name;

    private int trips;

    private List<Airline> airline;

    private int __v;

    public void set_id(String _id){
        this._id = _id;
    }
    public String get_id(){
        return this._id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setTrips(int trips){
        this.trips = trips;
    }
    public int getTrips(){
        return this.trips;
    }
    public void setAirline(List<Airline> airline){
        this.airline = airline;
    }
    public List<Airline> getAirline(){
        return this.airline;
    }
    public void set__v(int __v){
        this.__v = __v;
    }
    public int get__v(){
        return this.__v;
    }
}
