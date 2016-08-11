package com.nmp90.idrink.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by joro on 11.08.16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class BarsResult {
    String nextPageToken;
    List<Bar> results;

    public String getNextPageToken() {
        return nextPageToken;
    }

    public List<Bar> getResults() {
        return results;
    }
}
