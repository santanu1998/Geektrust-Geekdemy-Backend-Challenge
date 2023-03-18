package com.geektrust.backend.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class UtilsTest {
    @Test
    public void testCheckIfContains() {
        List<String> l1 = Arrays.asList("apple", "orange", "grapes", "guava", "mango", "pear");
        String t1 = "apple";
        boolean r1 = Utils.checkIfContains(l1, t1);
        List<String> l2 = Arrays.asList("cats", "dogs", "parrots", "horses");
        String t2 = "giraffes";
        boolean r2 = Utils.checkIfContains(l2, t2);
        String error_msg = "The function \"checkIfContains\" fails\n";
        String success_msg = "Test Successful";
        Assertions.assertTrue(r1, success_msg);
        Assertions.assertFalse(r2, error_msg);
    }
}
