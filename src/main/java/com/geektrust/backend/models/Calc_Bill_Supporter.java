package com.geektrust.backend.models;

import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.constants.String_Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calc_Bill_Supporter {
    Helper2 helper2 = new Helper2();
    public Map<String, Double> pricing;
    public List<String> purchaseList;
    public List<String> couponList;
    public Map<String, Double> proDiscounts;
    public Map<String, Double> couponDiscounts;
    public boolean isProMember;
    public boolean toPrint;
    public List<String> testArray;

    public Calc_Bill_Supporter() {
        pricing = new HashMap<>();
        purchaseList = new ArrayList<>();
        couponList = new ArrayList<>();
        proDiscounts = new HashMap<>();
        couponDiscounts = new HashMap<>();
        isProMember = false;
        toPrint = true;
        testArray = new ArrayList<>();
    }

    /*private float Calc_pro_discount() {
        float total_pro_discount = 0.0f;
        if (IsProMember) {
            Map<String, Float> newPricing = new HashMap<String, Float>();
            for (Map.Entry<String, Float> entry : Pricing.entrySet()) {
                newPricing.put(entry.getKey(), entry.getValue() * (1 - ProDiscounts.get(entry.getKey())));
            }
            for (String val : PurchaseList) {
                total_pro_discount += (Pricing.get(val) - newPricing.get(val));
            }
            Pricing = newPricing;
        }
        return total_pro_discount;
    }*/

    public double calcProDiscount() {
        double totalProDiscount = 0.0;
        if (isProMember) {
            Map<String, Double> newPricing = new HashMap<>();
            for (String key : pricing.keySet()) {
                newPricing.put(key, pricing.get(key) * (1 - proDiscounts.get(key)));
            }
            for (String val : purchaseList) {
                totalProDiscount += pricing.get(val) - newPricing.get(val);
            }
            pricing = newPricing;
        }
        return totalProDiscount;
    }

    public String[] determineCoupon(double subTotal) {
        String couponName = String_Constants.None_string;
        double couponAmount = 0.0;
        if (purchaseList.size() >= Constants.B4G1_threshold) {
            String[] result = helper2.coup_1();
            couponName = result[0];
            couponAmount = Double.parseDouble(result[1]);
        } else {
            String[] result = helper2.coup_2(subTotal);
            couponName = result[0];
            couponAmount = Double.parseDouble(result[1]);
        }
        return new String[]{couponName, String.valueOf(couponAmount), String.valueOf(subTotal)};
    }

    /*private String Determine_coupon(float sub_total) {
        String coupon_name = String_Constants.None_string;
        float coupon_amount = 0.0f;
        if (PurchaseList.size() >= Constants.B4G1_threshold) {
            Helper2 helper2 = new Helper2();
            String coup_1_output = helper2.coup_1();
            coupon_name = coup_1_output[0];
            coupon_amount = Float.parseFloat(coup_1_output[1]);
        } else {
            String[] coup_2_output = coup_2(sub_total);
            coupon_name = coup_2_output[0];
            coupon_amount = Float.parseFloat(coup_2_output[1]);
        }
        return coupon_name + "," + coupon_amount + "," + sub_total;
    }*/
}
