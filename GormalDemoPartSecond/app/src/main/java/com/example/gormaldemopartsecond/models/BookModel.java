package com.example.gormaldemopartsecond.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BookModel {
    @SerializedName("results")
    @Expose
    private ArrayList<AvailableBookResultModel> results = null;

    public ArrayList<AvailableBookResultModel> getResults() {
        return results;
    }

    public void setResults(ArrayList<AvailableBookResultModel> results) {
        this.results = results;
    }
}
