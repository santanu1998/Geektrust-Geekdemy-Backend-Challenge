package com.geektrust.backend.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
    Calc_Bill_Supporter calc_bill_supporter = new Calc_Bill_Supporter();
    /*private Map<String, Double> Pricing;
    private List<String> PurchaseList;
    private List<String> CouponList;
    private Map<String, Double> ProDiscounts;
    private Map<String, Double> CouponDiscounts;
    private boolean IsProMember;
    private boolean ToPrint;
    private List<String> Test_array;*/

    /*public Model() {
        Pricing = new HashMap<String, Double>();
        PurchaseList = new ArrayList<String>();
        CouponList = new ArrayList<String>();
        ProDiscounts = new HashMap<String, Double>();
        CouponDiscounts = new HashMap<String, Double>();
        IsProMember = false;
        ToPrint = false;
        Test_array = new ArrayList<String>();
    }*/

    public Map<String, Double> getPricing() {
        return calc_bill_supporter.pricing;
    }

    public void setPricing(Map<String, Double> pricing) {
        calc_bill_supporter.pricing = pricing;
    }

    public List<String> getPurchaseList() {
        return calc_bill_supporter.purchaseList;
    }

    public void setPurchaseList(List<String> purchaseList) {
        calc_bill_supporter.purchaseList = purchaseList;
    }

    public List<String> getCouponList() {
        return calc_bill_supporter.couponList;
    }

    public void setCouponList(List<String> couponList) {
        calc_bill_supporter.couponList = couponList;
    }

    public Map<String, Double> getProDiscounts() {
        return calc_bill_supporter.proDiscounts;
    }

    public void setProDiscounts(Map<String, Double> proDiscounts) {
        calc_bill_supporter.proDiscounts = proDiscounts;
    }

    public Map<String, Double> getCouponDiscounts() {
        return calc_bill_supporter.couponDiscounts;
    }

    public void setCouponDiscounts(Map<String, Double> couponDiscounts) {
        calc_bill_supporter.couponDiscounts = couponDiscounts;
    }

    public boolean isProMember() {
        return calc_bill_supporter.isProMember;
    }

    public void setProMember(boolean proMember) {
        calc_bill_supporter.isProMember = proMember;
    }

    public boolean isToPrint() {
        return calc_bill_supporter.toPrint;
    }

    public void setToPrint(boolean toPrint) {
        calc_bill_supporter.toPrint = toPrint;
    }

    public List<String> getTest_array() {
        return calc_bill_supporter.testArray;
    }

    public void setTest_array(List<String> test_array) {
        calc_bill_supporter.testArray = test_array;
    }
}
