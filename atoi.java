class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0) return 0;
        int index = 0;
        int sign = 1;
        int result = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index < s.length()) {
            if (s.charAt(index) == '-') {
                sign *= -1;
                index++;
            }
            else if (s.charAt(index) == '+') {
                index++;
            }
        }

        while (index < s.length()) {
            char curr = s.charAt(index);
            if (curr == '.')  {
                if (index+1 < s.length()) {
                    int decimal = Character.getNumericValue(curr);
                    if (decimal >= 5) {
                        result += 1;
                    }
                }
                return result*sign;
            }

            if (curr >= '0' && curr <= '9') {
                int val = Character.getNumericValue(curr);
                if (result >= Integer.MAX_VALUE/10) {
                    if (sign < 0) {
                        if (Integer.MAX_VALUE/10 == result && val == 9) {
                            return Integer.MIN_VALUE;
                        } else if (Integer.MAX_VALUE/10 > result) {
                            return Integer.MIN_VALUE;
                        }
                    } else {
                        if (Integer.MAX_VALUE/10 == result && val > 7) {
                            return Integer.MAX_VALUE;
                        } else if (Integer.MAX_VALUE/10 > result) {
                            return Integer.MAX_VALUE;
                        }
                    }
                }

                result *= 10;
                result += val;
            } else {
                break;
            }
            index++;
        }
        return result*sign;
    }
}
