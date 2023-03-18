package com.geektrust.backend.constants;

public class String_Constants {
    public static String Add_programme;
    public static String Apply_coupon;
    public static String Add_pro_membership;
    public static String Print_bill;
    public static String None_string;
    public static String Cert_string;
    public static String Degree_string;
    public static String Diploma_string;
    public static String B4g1_string;
    public static String Deal_G20_string;
    public static String Deal_G5_string;

    public static void set_strings(String[] lines) {
        // Start from index 14
        Add_programme = lines[14];
        Apply_coupon = lines[15];
        Add_pro_membership = lines[16];
        Print_bill = lines[17];
        None_string = lines[18];
        set_strings2(lines);
    }

    public static void set_strings2(String[] lines) {
        // Start from 19
        Cert_string = lines[19];
        Degree_string = lines[20];
        Diploma_string = lines[21];
        B4g1_string = lines[22];
        Deal_G20_string = lines[23];
        Deal_G5_string = lines[24];
    }
}
