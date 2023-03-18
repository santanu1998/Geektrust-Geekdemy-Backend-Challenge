package com.geektrust.backend.constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.geektrust.backend.constants.String_Constants.set_strings;

public class Read_From_File {

    public static String[] readLines(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        String[] lines = new String[14];
        int i = 0;
        while ((line = reader.readLine()) != null) {
            lines[i] = line;
            i++;
        }
        reader.close();
        return lines;
    }

    public static void Init_Constants() throws IOException {
        String[] lines = readLines("magic_numbers.txt");
        int ten = 10;
        int sixty_four = 64;
        long a = Long.parseLong(lines[12], ten);
        Constants.Deal_min_threshold = (int) a;
        long b = Long.parseLong(lines[13], ten);
        Constants.B4G1_threshold = (int) b;
        set_floats(lines);
    }

    public static void set_floats(String[] lines) {
        int sixty_four = 64;
        Constants.Cert_cost = Double.parseDouble(lines[0]);
        Constants.Degree_cost = Double.parseDouble(lines[1]);
        Constants.Diploma_cost = Double.parseDouble(lines[2]);
        Constants.Degree_discount = Double.parseDouble(lines[3]);
        Constants.Cert_discount = Double.parseDouble(lines[4]);
        Constants.Diploma_discount = Double.parseDouble(lines[5]);
        Constants.Enrollment_fee = Double.parseDouble(lines[6]);
        Constants.Enrollment_threshold = Double.parseDouble(lines[7]);
        Constants.Deal_G5 = Double.parseDouble(lines[8]);
        Constants.Deal_G20 = Double.parseDouble(lines[9]);
        Constants.Membership_fee = Double.parseDouble(lines[10]);
        Constants.Deal_threshold = Double.parseDouble(lines[11]);
        set_strings(lines);
    }
}
