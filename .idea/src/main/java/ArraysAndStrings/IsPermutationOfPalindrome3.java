package main.java.ArraysAndStrings;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Bit Optimization of isPermutationOfPalindrome
 */
public class IsPermutationOfPalindrome3 {
    public class Solution {
        public boolean isPermutationOfPalindrome(String string) {
            int bitVector = createBitVector(string);
            return  bitVector == 0 || checkExactlyOneBitSet(bitVector);
        }

        private boolean checkExactlyOneBitSet(int bitVector) {
            return (bitVector & (bitVector - 1)) == 0;
        }

        private int createBitVector(String string) {
            int bitVector = 0;
            for (char c : string.toCharArray()) {
                int index = getCharNumber(c);
                bitVector = toggle(bitVector, index);
            }
            return bitVector;
        }

        private int toggle(int bitVector, int index) {
            if (index < 0) return bitVector;
            int mask = 1 << index;
            if ((bitVector & mask) == 0) {
                bitVector |= mask;
            } else {
                bitVector &= ~mask;
            }
            return bitVector;
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
            Solution solution = new IsPermutationOfPalindrome3().new Solution();
            String s = "tact coa";
            assertTrue(solution.isPermutationOfPalindrome(s));

        }
    }
}
