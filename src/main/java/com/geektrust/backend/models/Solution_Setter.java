package com.geektrust.backend.models;

import java.util.ArrayList;

public class Solution_Setter {
//    private ArrayList<String> Test_array = new ArrayList<String>();
    // The things we do to prevent "magic numbers"
    Calc_Bill_Supporter calc_bill_supporter = new Calc_Bill_Supporter();
    public String sub_total_string = "SUB_TOTAL ";
    public String coupon_discount_string = "COUPON_DISCOUNT ";
    public String total_pro_discount_string = "TOTAL_PRO_DISCOUNT ";
    public String pro_membership_fee_string = "PRO_MEMBERSHIP_FEE ";
    public String enrollment_fee_string = "ENROLLMENT_FEE ";
    public String total_string = "TOTAL ";

    public void Set_Solution(double sub_total, String coupon_name, double coupon_amount, double total_pro_discount, double pro_membership_fee, double enrollment_fee, double total) {
        // Remove magic numbers
        int num_bits = 64;
        int accuracy_needed = 2;
        char f = 'f';
        String space = " ";
        calc_bill_supporter.testArray.add(sub_total_string + String.format("%."+accuracy_needed+f, sub_total));
        calc_bill_supporter.testArray.add(coupon_discount_string + coupon_name + space + String.format("%."+accuracy_needed+f, coupon_amount));
        calc_bill_supporter.testArray.add(total_pro_discount_string + String.format("%."+accuracy_needed+f, total_pro_discount));
        calc_bill_supporter.testArray.add(pro_membership_fee_string + String.format("%."+accuracy_needed+f, pro_membership_fee));
        calc_bill_supporter.testArray.add(enrollment_fee_string + String.format("%."+accuracy_needed+f, enrollment_fee));
        calc_bill_supporter.testArray.add(total_string + String.format("%."+accuracy_needed+f, total));
    }
}
