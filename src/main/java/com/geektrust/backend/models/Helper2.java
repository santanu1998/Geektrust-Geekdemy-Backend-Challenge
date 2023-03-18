package com.geektrust.backend.models;

import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.constants.String_Constants;
import com.geektrust.backend.utils.Utils;

import java.util.List;
import java.util.Map;

public class Helper2 {
    Solution_Setter solution_setter = new Solution_Setter();
    Calc_Bill_Supporter calc_bill_supporter = new Calc_Bill_Supporter();
    double zero = 0.00;
    /*
    private String[] PurchaseList;
    private double[] Pricing;
    private String[] CouponList;
    private boolean ToPrint;
    */
    public Helper2(){}
    /*public Helper2(String[] PurchaseList, double[] Pricing, String[] CouponList, boolean ToPrint) {
        this.PurchaseList = PurchaseList;
        this.Pricing = Pricing;
        this.CouponList = CouponList;
        this.ToPrint = ToPrint;
    }*/

    /*public List<String> getPurchaseList() {
        return calc_bill_supporter.purchaseList;
    }

    public void setPurchaseList(List<String> purchaseList) {
        calc_bill_supporter.purchaseList = purchaseList;
    }

    public Map<String, Double> getPricing() {
        return calc_bill_supporter.pricing;
    }

    public void setPricing(Map<String, Double> pricing) {
        calc_bill_supporter.pricing = pricing;
    }

    public List<String> getCouponList() {
        return calc_bill_supporter.couponList;
    }

    public void setCouponList(List<String> couponList) {
        calc_bill_supporter.couponList = couponList;
    }

    public boolean isToPrint() {
        return calc_bill_supporter.toPrint;
    }

    public void setToPrint(boolean toPrint) {
        calc_bill_supporter.toPrint = toPrint;
    }*/

    public String[] coup_1() {
        String coupon_name = String_Constants.B4g1_string;
        double coupon_amount = zero;
        if (Utils.checkIfContains(calc_bill_supporter.purchaseList, String_Constants.Diploma_string)) {
            coupon_amount = Double.parseDouble(String.valueOf(calc_bill_supporter.purchaseList.add(String.valueOf(Integer.parseInt(String_Constants.Diploma_string)))));
        }
        else if (Utils.checkIfContains(calc_bill_supporter.purchaseList, String_Constants.Cert_string)) {
            coupon_amount = Double.parseDouble(String.valueOf(calc_bill_supporter.purchaseList.add(String.valueOf(Integer.parseInt(String_Constants.Cert_string)))));
        }
        else {
            coupon_amount = Double.parseDouble(String.valueOf(calc_bill_supporter.purchaseList.add(String.valueOf(Integer.parseInt(String_Constants.Degree_string)))));
        }
        return new String[]{ coupon_name, Double.toString(coupon_amount) };
    }

    public String[] coup_2(double sub_total) {
        String coupon_name = String_Constants.None_string;
        double coupon_amount = zero;
        if (sub_total >= Constants.Deal_threshold) {
            if (Utils.checkIfContains(calc_bill_supporter.couponList, String_Constants.Deal_G20_string)) {
                coupon_name = String_Constants.Deal_G20_string;
                coupon_amount = sub_total * Constants.Deal_G20;
            } else if (Utils.checkIfContains(calc_bill_supporter.couponList, String_Constants.Deal_G5_string)) {
                coupon_name = String_Constants.Deal_G5_string;
                coupon_amount = sub_total * Constants.Deal_G5;
            }
        } else if (calc_bill_supporter.purchaseList.size() >= Constants.Deal_min_threshold) {
            if (Utils.checkIfContains(calc_bill_supporter.couponList, String_Constants.Deal_G5_string)) {
                coupon_name = String_Constants.Deal_G5_string;
                coupon_amount = sub_total * Constants.Deal_G5;
            }
        }
        return new String[]{ coupon_name, Double.toString(coupon_amount) };
    }

    public void do_whats_necessary(double sub_total, String coupon_name, double coupon_amount, double total_pro_discount, double pro_membership_fee) {
        double total = sub_total - coupon_amount;
        double enrollment_fee = zero;
        if (total < Constants.Enrollment_threshold) {
            enrollment_fee = Constants.Enrollment_fee;
            total += Constants.Enrollment_fee;
        }
        solution_setter.Set_Solution(sub_total, coupon_name, coupon_amount, total_pro_discount, pro_membership_fee, enrollment_fee, total);
        Utils.printSoln(sub_total, coupon_name, coupon_amount, total_pro_discount, pro_membership_fee, enrollment_fee, total, calc_bill_supporter.toPrint);
    }
}
