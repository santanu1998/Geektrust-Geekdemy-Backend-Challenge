package com.geektrust.backend.utils;

import java.util.List;

public class Utils {
    public static boolean checkIfContains(List<String> list, String s) {
        for (String val : list) {
            if (val.equals(s)) {
                return true;
            }
        }
        return false;
    }

    // Function to print the solution out.
    // Written as a separate function to better format the code (%.2f)
    public static void printSoln(double sub_total, String coupon_name, double coupon_amount, double total_pro_discount,
                                 double pro_membership_fee, double enrollment_fee, double total, boolean flag) {
        if (flag) {
            System.out.printf("SUB_TOTAL %.2f\n", sub_total);
            System.out.printf("COUPON_DISCOUNT %s %.2f\n", coupon_name, coupon_amount);
            System.out.printf("TOTAL_PRO_DISCOUNT %.2f\n", total_pro_discount);
            System.out.printf("PRO_MEMBERSHIP_FEE %.2f\n", pro_membership_fee);
            System.out.printf("ENROLLMENT_FEE %.2f\n", enrollment_fee);
            System.out.printf("TOTAL %.2f\n", total);
        }
    }
}
