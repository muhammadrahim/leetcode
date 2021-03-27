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
