package main.java.ArraysAndStrings;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

/**
 * Check permutation: Given two strings, write a method to decide if one is a permuation of the other
 */
public class CheckPermutation {
//    public class Solution {
//        public String sort(String s) {
//            char[] content = s.toCharArray();
//            Arrays.sort(content);
//            return content.toString();
//        }
//        public boolean isPermutaion(String s1, String s2) {
//            if (s1.length() != s2.length()) return false;
//            return sort(s1).equals(sort(s2));
//        }
//    }
//    public static class UnitTest {
//        @Test
//        public static void test() {
//            Solution solution = new CheckPermutation().new Solution();
//            String s1 = "abcde";
//            String s2 = "bcdae";
//            String s3 = "abcdf";
//            assertTrue(solution.isPermutaion(s1, s2));
//            assertTrue(!solution.isPermutaion(s1, s3));
//        }
//    }
    public CheckPermutation() {

    }
    public class Solution {
        public boolean permutation(String s1, String s2) {
            if (s1.length() != s2.length()) return false;
            int[] letters = new int[128];
            char[] chars = s1.toCharArray();
            for (char c : chars) {
                letters[c]++;
            }
            for (int i = 0; i < s2.length(); i++) {
                int c = s2.charAt(i);
                letters[c]--;
                if (letters[c] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
    public static class UnitTest {
        @Test
        public void testPermutation() {
            Solution solution = new CheckPermutation().new Solution();
            String s1 = "asdf";
            String s2 = "adsf";
            assertTrue(solution.permutation(s1, s2));
            assert(solution.permutation(s1, s2));
        }
    }
}
