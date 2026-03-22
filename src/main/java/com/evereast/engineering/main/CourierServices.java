package com.evereast.engineering.main;

import com.evereast.engineering.logic.DiscountOffer;
import com.evereast.engineering.model.RequestParameters;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CourierServices {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DiscountOffer discountOffer = new DiscountOffer();

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
                // this output as specified in the requirement
                System.out.println(pkgId + " " + discount + " " + totalCost);
            }
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

