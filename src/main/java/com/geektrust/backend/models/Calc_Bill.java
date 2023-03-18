package com.geektrust.backend.models;

import com.geektrust.backend.constants.Constants;

import java.util.HashMap;
import java.util.Map;

public class Calc_Bill {
    Helper2 helper2 = new Helper2();
    /*private Map<String, Double> pricing;
    private String[] purchaseList;
    private String[] couponList;
    private Map<String, Double> proDiscounts;
    private Map<String, Double> couponDiscounts;
    private boolean isProMember;
    private boolean toPrint;
    private String[] testArray;*/

    Calc_Bill_Supporter calc_bill_supporter = new Calc_Bill_Supporter();
    /*public Calc_Bill() {
        pricing = new HashMap<String, Double>();
        purchaseList = new String[0];
        couponList = new String[0];
        proDiscounts = new HashMap<String, Double>();
        couponDiscounts = new HashMap<String, Double>();
        isProMember = false;
        toPrint = true;
        testArray = new String[0];
    }*/
    public void calcBill() {
        double zero = 0.0;
        String couponName;
        double subTotal = 0.0, couponAmount = 0.0, totalProDiscount = 0.0, proMembershipFee = 0.0;
        totalProDiscount = calc_bill_supporter.calcProDiscount();
        if (totalProDiscount > 0) {
            proMembershipFee = Constants.Membership_fee;
        }
        for (String val : calc_bill_supporter.purchaseList) {
            subTotal += calc_bill_supporter.pricing.get(val);
        }
        subTotal += proMembershipFee;
        String[] couponResult = calc_bill_supporter.determineCoupon(subTotal);
        couponName = couponResult[0];
        couponAmount = Double.parseDouble(couponResult[1]);
        helper2.do_whats_necessary(subTotal, couponName, couponAmount, totalProDiscount, proMembershipFee);
    }
    /*public double calcProDiscount() {
        double zero = 0.0;
        double total = zero;

        if (calc_bill_supporter.isProMember) {
            for (String val : calc_bill_supporter.purchaseList) {
                if (calc_bill_supporter.proDiscounts.containsKey(val)) {
                    total += calc_bill_supporter.pricing.get(val) * (calc_bill_supporter.proDiscounts.get(val) / 100);
                }
            }
        }
        return total;
    }*/
}
