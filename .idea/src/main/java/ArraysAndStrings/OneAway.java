package main.java.ArraysAndStrings;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 *There are three types of edits that can be performed on strings: insert a character, remove a character,
 * or replace a character. Given two strings, write a function to check if they are one edit a away.
 */
public class OneAway {
    public class Solution {
        public boolean oneEditAway(String s1, String s2) {
            if (Math.abs(s1.length() - s2.length()) > 1) {
                return false;
            }
            String first = s1.length() < s2.length() ? s1 : s2;
            String second = s1.length() < s2.length() ? s2 : s1;
            int index1 = 0;
            int index2 = 0;
            boolean foundDifference = false;
            while (index2 < s2.length() && index1 < s1.length()) {
                if (s1.charAt(index1) != s2.charAt(index2)) {
                    if (foundDifference) return false;
                    foundDifference = true;
                    if (s1.length() == s2.length()) {
                        index1++;
                    }
                } else {
                    index1++;
                }
                index2++;
            }
            return true;
        }

    }
    public static class UnitTest {
        @Test
        public void test() {
            Solution solution = new OneAway().new Solution();
            String s1 = "asdcdf";
            String s2 = "asdcf";
            assertTrue(solution.oneEditAway(s1, s2));
        }
    }
}
