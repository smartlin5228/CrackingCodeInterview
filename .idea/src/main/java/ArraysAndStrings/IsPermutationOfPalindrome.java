package main.java.ArraysAndStrings;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Ethan on 12/10/16.
 */
public class IsPermutationOfPalindrome {
    public class Solution {
        public boolean isPermutationofPalindrome(String phrase) {
            int[] table = buildCharFrequencyTable(phrase);
            return checkMaxOneOdd(table);
        }

        private boolean checkMaxOneOdd(int[] table) {
            boolean foundOdd = false;
            for (int count : table) {
                if (count % 2 == 1) {
                    if (foundOdd) return false;
                    foundOdd = true;
                }
            }
            return true;
        }

        private int[] buildCharFrequencyTable(String phrase) {
            int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
            for (char c : phrase.toCharArray()) {
                int x = getCharNUmber(c);
                if (x != -1) {
                    table[x]++;
                }
            }
            return table;
        }

        private int getCharNUmber(Character c) {
            int a = Character.getNumericValue('a');
            int z = Character.getNumericValue('z');
            int A = Character.getNumericValue('A');
            int Z = Character.getNumericValue('Z');
            int val = Character.getNumericValue(c);
            if (a <= val && val <= z) {
                return val - a;
            } else if (A <= val && val <= Z) {
                return val - A;
            }
            return -1;
        }
    }
    public static class UnitTest {
        @Test
        public void TestPermutationOfPalindrome() {
            Solution solution = new IsPermutationOfPalindrome().new Solution();
            String s = "tact coa";
            assertTrue(solution.isPermutationofPalindrome(s));
        }
    }
}
