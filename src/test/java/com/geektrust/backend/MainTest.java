package com.geektrust.backend;

import com.geektrust.backend.constants.String_Constants;
import com.geektrust.backend.models.Calc_Bill;
import com.geektrust.backend.models.Calc_Bill_Supporter;
import com.geektrust.backend.models.Functions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    Calc_Bill_Supporter calc_bill_supporter = new Calc_Bill_Supporter();
    private final String SUCCESS = "Success";
    private final String FAILURE = "Failure, not the expected output";
    Calc_Bill calc_bill = new Calc_Bill();
    @Test
    public void testMain1() {
        Functions app = new Functions();
        app.Initialize_values();
        calc_bill_supporter.purchaseList.add(String_Constants.Cert_string);
        calc_bill_supporter.purchaseList.add(String_Constants.Degree_string);
        calc_bill_supporter.purchaseList.add(String_Constants.Diploma_string);
        calc_bill_supporter.purchaseList.add(String_Constants.Diploma_string);
        calc_bill_supporter.purchaseList.add(String_Constants.Deal_G20_string);
        calc_bill.calcBill();

        List<String> expected_ans = new ArrayList<String>() {{
            add("SUB_TOTAL 13000.00");
            add("COUPON_DISCOUNT B4G1 2500.00");
            add("TOTAL_PRO_DISCOUNT 0.00");
            add("PRO_MEMBERSHIP_FEE 0.00");
            add("ENROLLMENT_FEE 0.00");
            add("TOTAL 10500.00");
        }};

        int l = expected_ans.size();
        for (int i = 0; i < l; i++) {
            assertEquals(expected_ans.get(i), calc_bill_supporter.testArray.get(i), FAILURE);
        }
        System.out.println(SUCCESS);
    }

    @Test
    public void testMain2() {
        Functions app = new Functions();
        app.Initialize_values();
        calc_bill_supporter.purchaseList.add(String_Constants.Degree_string);
        calc_bill_supporter.purchaseList.add(String_Constants.Diploma_string);
        calc_bill_supporter.purchaseList.add(String_Constants.Diploma_string);
        calc_bill_supporter.couponList.add(String_Constants.Deal_G20_string);
        calc_bill_supporter.couponList.add(String_Constants.Deal_G5_string);
        calc_bill.calcBill();

        List<String> expected_ans = new ArrayList<String>() {{
            add("SUB_TOTAL 10000.00");
            add("COUPON_DISCOUNT DEAL_G20 2000.00");
            add("TOTAL_PRO_DISCOUNT 0.00");
            add("PRO_MEMBERSHIP_FEE 0.00");
            add("ENROLLMENT_FEE 0.00");
            add("TOTAL 8000.00");
        }};

        int l = expected_ans.size();
        for (int i = 0; i < l; i++) {
            assertEquals(expected_ans.get(i), calc_bill_supporter.testArray.get(i), FAILURE);
        }
        System.out.println(SUCCESS);
    }
}
