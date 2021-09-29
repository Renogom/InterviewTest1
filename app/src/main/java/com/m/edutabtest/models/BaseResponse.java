package com.m.edutabtest.models;

import java.util.List;

public class BaseResponse {

    private int totalPassengers;

    private int totalPages;

    private List<Data> data;

    public BaseResponse() {

    }


    public int getTotalPassengers() {
        return totalPassengers;
    }

    public void setTotalPassengers(int totalPassengers) {
        this.totalPassengers = totalPassengers;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
