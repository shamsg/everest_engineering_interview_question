package com.evereast.engineering.logic;

import com.evereast.engineering.model.RequestParameters;

public class DiscountOffer {
    public double calculateDiscount(RequestParameters req, double deliveryCost) {

        switch (req.offerCode) {

            case "OFR001":
                if (req.distance < 200 && req.weight >= 70 && req.weight <= 200) {
                    return deliveryCost * 0.10;
                }
                break;

            case "OFR002":
                if (req.distance >= 50 && req.distance <= 150 &&
                        req.weight >= 100 && req.weight <= 250) {
                    return deliveryCost * 0.07;
                }
                break;

            case "OFR003":
                if (req.distance >= 50 && req.distance <= 250 &&
                        req.weight >= 10 && req.weight <= 150) {
                    return deliveryCost * 0.05;
                }
                break;
        }

        return 0;
    }
}

