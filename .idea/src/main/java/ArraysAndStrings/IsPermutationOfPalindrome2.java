package main.java.ArraysAndStrings;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Since we neede to look throught the entire string, we can only optimized
 * the method by make some smaller incremental improvements.
 */
public class IsPermutationOfPalindrome2 {
    public class Solution {
        public boolean isPermutationofPalindrome(String string) {
            int countOdd = 0;
            int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
            for (char c : string.toCharArray()) {
                int x = getCharNumber(c);
                if (x != -1) {
                    table[x]++;
                    if (table[x] % 2 == 1) {
                        countOdd ++;
                    } else {
                        countOdd--;
                    }
                }
            }
            return countOdd <= 1;
        }
        private int getCharNumber(Character c) {
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
            Solution solution = new IsPermutationOfPalindrome2().new Solution();
            String s = "tact coa";
            assertTrue(solution.isPermutationofPalindrome(s));

        }
    }
}