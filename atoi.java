/*
   Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

    Read in and ignore any leading whitespace.

    Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.

    Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.

    Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).

    If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.

    Return the integer as the final result.

Note:

    Only the space character ' ' is considered a whitespace character.
    Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.

Constraints:

    0 <= s.length <= 200
    s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.

Examples: "42" -> output: 42
	  "    -42" -> output: -42
	  "4193 with words" -> output: 4193
	  "words and 987" -> output: 0
	  "-91283472332" -> output: -2147483648
*/

class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0) return 0;
        int index = 0;
        boolean positive = true;
        long result = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index < s.length()) {
            if (s.charAt(index) == '-') {
                positive = false;
                index++;
            }
            else if (s.charAt(index) == '+') {
                index++;
            }
        }

        while (index < s.length()) {
            char curr = s.charAt(index);
            if (curr == '.')  {
                if (index+1 < s.length() && s.charAt(index+1) <= 9 && s.charAt(index+1) >= 0) {
                    int decimal = Character.getNumericValue(s.charAt(index+1));
                    if (decimal >= 5) {
                        result += 1;
                    }
                }
                return positive ? ((int)result) : (-1)*((int)result);
            }

            if (curr >= '0' && curr <= '9') {
                int val = Character.getNumericValue(curr);
                result *= 10;
                result += val;
                if (result >= Integer.MAX_VALUE && positive) {
                    return Integer.MAX_VALUE;
                }
                if (result > Integer.MAX_VALUE && !positive) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
            index++;
        }
        result = positive ? result : (-1)*result;
        if (result >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)result;
    }
}
