package main.java.ArraysAndStrings;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Implement an algorithm to determinae if a string has all unique characters. What if you cannot use additional data structures?
 * Hint: Ask interviewer if the string is an ASCII string or a Unicode string, normally assume it is ASCII string
 */
public class IsUnique {
    public class Solution {
        public boolean isUniqueChars(String string) {
            if (string.length() > 128) return false;
            boolean[] charsets = new boolean[128];
            for (int i = 0; i < string.length(); i++) {
                int val = string.charAt(i);
                if (charsets[val]) return false;
                charsets[val] = true;
            }
            return true;
        }
//TODO: Bit Manipulation << , & , |
        public boolean isUniqueCharsBit(String string) {
            int checker = 0;
            for (int i = 0; i < string.length(); i++) {
                int val = string.charAt(i) - 'a';
                if ((checker & (1 << val)) > 0) {
                    return false;
                }
            }
            return true;
        }
    }
    public static class UnitTest{
        @Test
        public void test() {
            Solution sol = new IsUnique().new Solution();
            assertTrue(sol.isUniqueChars("abcd"));
            assertTrue(sol.isUniqueCharsBit("abcd"));
        }
    }
}
