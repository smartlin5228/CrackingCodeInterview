package main.java.ArraysAndStrings;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Implement a method to perform basi string compression using the counts of repeated characters. For example, the string
 * aabccccaaa would become a2b1c5a3. If the comressed string would not become smaller than the original string, your method
 * should return the original string. You can asssume the string has only uppercase and lowercase letters
 */
public class StringCompression {
        public static String compressBrutal(String string) {
            StringBuilder stringBuilder = new StringBuilder();
            int countConsecutive = 0;
            for (int i = 0; i < string.length(); i++) {
                countConsecutive++;
                if (i + 1 >= string.length() || string.charAt(i) != string.charAt(i + 1)) {
                    stringBuilder.append(string.charAt(i));
                    stringBuilder.append(countConsecutive);
                    countConsecutive = 0;
                }
            }
            return stringBuilder.length() < string.length() ? stringBuilder.toString() : string;
        }
        public static String compress(String str) {
            int finalLength = countCompression(str);
            if (finalLength >= str.length()) return str;

            StringBuffer compressed = new StringBuffer(finalLength); // initialize capacity
            int countConsecutive = 0;
            for (int i = 0; i < str.length(); i++) {
                countConsecutive++;

			/* If next character is different than current, append this char to result.*/
                if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                    compressed.append(str.charAt(i));
                    compressed.append(countConsecutive);
                    countConsecutive = 0;
                }
            }
            return compressed.toString();
        }

        public static int countCompression(String str) {
            int compressedLength = 0;
            int countConsecutive = 0;
            for (int i = 0; i < str.length(); i++) {
                countConsecutive++;

			/* If next character is different than current, append this char to result.*/
                if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                    compressedLength += 1 + String.valueOf(countConsecutive).length();
                    countConsecutive = 0;
                }
            }
            return compressedLength;
        }

        public static void main(String[] args) {
            String str = "aaabbbcc";
            System.out.println(str);
            System.out.println(compressBrutal(str));
            System.out.println(compress(str));
        }
}
