package com.evereast.engineering.model;

public class RequestParameters {
    public String id;
    public int weight;
    public int distance;
    public String offerCode;

    public RequestParameters(String id, int weight, int distance, String offerCode) {
        this.id = id;
        this.weight = weight;
        this.distance = distance;
        this.offerCode = offerCode;
    }
}
