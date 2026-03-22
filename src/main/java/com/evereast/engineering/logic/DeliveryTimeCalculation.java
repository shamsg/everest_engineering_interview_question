package com.evereast.engineering.logic;

import com.evereast.engineering.model.PackageDetails;

import java.util.Comparator;
import java.util.List;

public class DeliveryTimeCalculation {
    public void calculateDeliveryTime(List<PackageDetails> packageDetailsList,
                                      int noOfVehicles,
                                      int maxSpeed,
                                      int maxWeight) {

        // To Sort packages by weight descending
        packageDetailsList.sort(
                Comparator.comparing(PackageDetails:: getWeight ).reversed()
        );

        double[] vehicleAvailableTime = new double[noOfVehicles];

        for (PackageDetails packageDetails : packageDetailsList) {

            // Find earliest available vehicle
            int selectedVehicle = 0;
            for (int i = 1; i < noOfVehicles; i++) {
                if (vehicleAvailableTime[i] < vehicleAvailableTime[selectedVehicle]) {
                    selectedVehicle = i;
                }
            }

            // Calculate delivery time
            double tripTime = (double) packageDetails.getDistance() / maxSpeed;

            packageDetails.setDeliveryTime(vehicleAvailableTime[selectedVehicle] + tripTime);

            vehicleAvailableTime[selectedVehicle] += tripTime * 2;
            System.out.println("estimated time to be taken: "+ tripTime * 2);
        }

        for (PackageDetails pkgDtls : packageDetailsList) {
            System.out.println(
                    pkgDtls.getId() + " " +
                            (int) pkgDtls.getDiscount() + " " +
                            (int) pkgDtls.getTotalCost() + " " +
                            String.format("%.2f", pkgDtls.getDeliveryTime())
            );
        }
    }
}

