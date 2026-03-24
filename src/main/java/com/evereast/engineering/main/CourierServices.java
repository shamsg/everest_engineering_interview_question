package com.evereast.engineering.main;

import com.evereast.engineering.logic.DeliveryTimeCalculation;
import com.evereast.engineering.logic.DiscountOffer;
import com.evereast.engineering.model.PackageDetails;
import com.evereast.engineering.model.RequestParameters;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CourierServices {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DiscountOffer discountOffer = new DiscountOffer();
        List<PackageDetails> packageDetailsList = new ArrayList<>();

        try {
            // Input base cost and number of packages
            System.out.print("Base Delivery Cost: ");
            int baseCost = sc.nextInt();
            System.out.print("No of Packages: ");
            int numberOfPackages = sc.nextInt();

            for (int i = 0; i < numberOfPackages; i++) {
                // i avoid the input as the requirement specified to ease the process. otherwise i will use a list and split that using space
                System.out.print("Package ID " + (i + 1) + ": ");
                String pkgId = sc.next();
                System.out.print("Weight " + (i + 1) + ": ");
                int pkgWeight = sc.nextInt();
                System.out.print("Distance " + (i + 1) + ": ");
                int pkgDistance = sc.nextInt();
                System.out.print("Offer Code " + (i + 1) + ": ");
                String pkgOfferCode = sc.next();

                RequestParameters requestParameters = new RequestParameters(pkgId, pkgWeight, pkgDistance, pkgOfferCode);
                double deliveryCost = baseCost + (pkgWeight * 10) + (pkgDistance * 5);
                double discount = discountOffer.calculateDiscount(requestParameters, deliveryCost);
                double totalCost = deliveryCost - discount;
                double estimateDeliveryTime =0;
                // this output as specified in the requirement
                //System.out.println(pkgId + " " + discount + " " + totalCost + " "+ estimateDeliveryTime);
                // save the package details to be used after the calculation of the estimated time
                packageDetailsList.add(new PackageDetails(pkgId, pkgWeight, pkgDistance, discount, totalCost));
            }


            System.out.print("No of Vehicles: ");
            int noOfVehicles = sc.nextInt();
            System.out.print("Max Speed: ");
            int maxSpeed = sc.nextInt();
            System.out.print("Max Weight: ");
            int maxWeight = sc.nextInt();


            // Calculate delivery time
            DeliveryTimeCalculation deliveryTimeCalculation = new DeliveryTimeCalculation();
            deliveryTimeCalculation.calculateDeliveryTime(packageDetailsList, noOfVehicles, maxSpeed, maxWeight);
        }
        catch(InputMismatchException e){
                System.out.println("Invalid input!");
            } catch(Exception e){
                System.out.println("Something went wrong: " + e.getMessage());
            } finally{
                sc.close();
            }
        }
    }

