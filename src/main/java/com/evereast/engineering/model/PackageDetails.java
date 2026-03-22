package com.evereast.engineering.model;

public class PackageDetails {

    String id;
    int weight;
    int distance;
    double discount;
    double totalCost;
    double deliveryTime;

    public PackageDetails(String id, int weight, int distance, double discount, double totalCost) {
        this.id = id;
        this.weight = weight;
        this.distance = distance;
        this.discount = discount;
        this.totalCost = totalCost;
    }

    public int getWeight() {
        return weight;
    }

    public String getId() {
        return id;
    }

    public int getDistance() {
        return distance;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getDeliveryTime() {
        return deliveryTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setDeliveryTime(double deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
