package com.geektrust.backend.models;

import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.constants.String_Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Functions {
    Take_Arguments take_arguments = new Take_Arguments();
    Calc_Bill_Supporter calc_bill_supporter = new Calc_Bill_Supporter();
    Calc_Bill calc_bill = new Calc_Bill();
    /*private Map<String, Double> Pricing;    // Stores the prices of various things a student can buy
    public List<String> PurchaseList;      // List of purchases by the student in a single transaction
    public List<String> CouponList;        // Coupons applied, will be processed before applying
    private Map<String, Double> ProDiscounts;    // Percentage of discounts for pro membership
    private Map<String, Double> CouponDiscounts;    // Percentage of discounts for each coupon code
    private boolean IsProMember = false;    // Defaults to false, can be set true from input
    private boolean ToPrint = false;    // If this flag is false, the solution is not printed
    public List<String> Test_array = new ArrayList<>();    // This array is for testing.*/
    public Functions() {}
    /*public Functions(Map<String, Double> pricing, List<String> purchaseList, List<String> couponList, Map<String, Double> proDiscounts, Map<String, Double> couponDiscounts) {
        Pricing = pricing;
        PurchaseList = purchaseList;
        CouponList = couponList;
        ProDiscounts = proDiscounts;
        CouponDiscounts = couponDiscounts;
    }*/

    public void run() throws IOException {
        Initialize_values();
        take_arguments.Take_args();
        calc_bill.calcBill();
    }

    public void Initialize_values() {
        // Removing "magic numbers"
        int zero = 0;
        Constants.initConstants();
        // Make new pricing hashmap
        calc_bill_supporter.pricing = new HashMap<>();
        calc_bill_supporter.pricing.put(String_Constants.Cert_string, Constants.Cert_cost);
        calc_bill_supporter.pricing.put(String_Constants.Degree_string, Constants.Degree_cost);
        calc_bill_supporter.pricing.put(String_Constants.Diploma_string, Constants.Diploma_cost);
        // Make new purchase list
        calc_bill_supporter.purchaseList = new ArrayList<>(zero);
        // Make a new coupon list (choose the best one later)
        calc_bill_supporter.couponList = new ArrayList<>(zero);
        // Make Discount hash map
        calc_bill_supporter.proDiscounts = new HashMap<>();
        calc_bill_supporter.proDiscounts.put(String_Constants.Degree_string, Constants.Degree_discount);
        calc_bill_supporter.proDiscounts.put(String_Constants.Cert_string, Constants.Cert_discount);
        calc_bill_supporter.proDiscounts.put(String_Constants.Diploma_string, Constants.Diploma_discount);
    }
}
