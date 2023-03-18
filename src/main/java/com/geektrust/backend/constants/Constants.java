package com.geektrust.backend.constants;

public class Constants {
    public static double Cert_cost;
    public static double Degree_cost;
    public static double Diploma_cost;
    public static double Degree_discount;
    public static double Cert_discount;
    public static double Diploma_discount;
    public static double Enrollment_fee;
    public static double Enrollment_threshold;
    public static double Deal_G5;
    public static double Deal_G20;
    public static double Membership_fee;
    public static double Deal_threshold;
    public static int Deal_min_threshold;
    public static int B4G1_threshold;
    public static void initConstants() {
        Cert_cost = 100.0;
        Degree_cost = 500.0;
        Diploma_cost = 200.0;
        Degree_discount = 0.1;
        Cert_discount = 0.05;
        Diploma_discount = 0.05;
        Enrollment_fee = 50.0;
        Enrollment_threshold = 1000.0;
        Deal_G5 = 0.05;
        Deal_G20 = 0.2;
        Membership_fee = 100.0;
        Deal_threshold = 5000.0;
        Deal_min_threshold = 3;
        B4G1_threshold = 4;
    }
}
