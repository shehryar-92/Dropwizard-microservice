package com.skyscanner.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResult {

    private String city;
    private String title;

    public SearchResult() {}

    public SearchResult(String city, String title) {
        this.city = city;
        this.title = title;
    }

    @JsonProperty
    public String getCity() { return city; }

    @JsonProperty
    public String getTitle() { return title; }
}
