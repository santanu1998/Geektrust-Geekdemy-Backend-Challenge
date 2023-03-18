package com.geektrust.backend.models;

import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.constants.String_Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Take_Arguments {
    /*private List<String> PurchaseList;
    private List<String> CouponList;
    private boolean IsProMember;
    private boolean ToPrint;*/

    /*public Take_Arguments() {
        PurchaseList = new ArrayList<>();
        CouponList = new ArrayList<>();
        IsProMember = false;
        ToPrint = false;
    }*/
    Calc_Bill_Supporter calc_bill_supporter = new Calc_Bill_Supporter();
    public void Take_args() throws IOException {
        int zero = 0, one = 1, two = 2;
        String[] cliArgs = new String[0];
        cliArgs = new String[1];
        cliArgs = System.getProperty("user.dir").split("/");
        String filePath = cliArgs[cliArgs.length - one] + "/src/geektrust/input/" + System.getProperty("input.file");
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = "";
        while ((line = br.readLine()) != null) {
            Scanner scanner = new Scanner(line);
            do_things_with_args(scanner);
        }
        br.close();
    }

    public void do_things_with_args(Scanner scanner) {
        int zero = 0, one = 1, two = 2;
        while (scanner.hasNext()) {
            String[] words = scanner.nextLine().split(" ");
            if (words[zero].equals(String_Constants.Add_programme)) {
                int programme_count = Integer.parseInt(words[two]);
                for (int i = zero; i < programme_count; i++) {
                    calc_bill_supporter.purchaseList.add(words[one]);
                }
            }
            else if (words[zero].equals(String_Constants.Apply_coupon)) {
                calc_bill_supporter.couponList.add(words[one]);
            }
            else if (words[zero].equals(String_Constants.Add_pro_membership)) {
                calc_bill_supporter.isProMember = true;
            }
            else if (words[zero].equals(String_Constants.Print_bill)) {
                calc_bill_supporter.toPrint = true;
            }
        }
    }
}
