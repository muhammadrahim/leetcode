package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) <= 'z' && s.charAt(i) >= 'a')
                    || (s.charAt(i) <= '9' && s.charAt(i) >= '0') ){
                sb.append(s.charAt(i));
            }
        }
        String tmp = sb.toString();
        int len = tmp.length();
        int left;
        int right;
        if (len%2 == 0) {
            left = len/2-1;
            right = len/2;
        } else {
            left = len/2-1;
            right = len/2+1;
        }

        while (left >= 0 && right < len) {
            if (tmp.charAt(left) != tmp.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }

    public int myAtoi(String s) {
        StringBuilder result = new StringBuilder();
        boolean isPositive = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (result.toString().length() == 0 && s.charAt(i) == '-') {
                    isPositive = false;
                }
                else if (result.toString().length() == 0 && (s.charAt(i) > '9' || s.charAt(i) < '0') && (s.charAt(i) != '+')) {
                    return 0;
                }
                if (result.toString().length() == 0 && s.charAt(i) == '.') {
                    result.append("0.");
                } else if (s.charAt(i) == '.' && !result.toString().contains(".")) {
                    result.append(".");
                }
                if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                    result.append(s.charAt(i));
                }
            }
        }

        String answer = result.toString();
        if (answer.length() == 0) return 0;

        long num = 0;
        for (int i = 0 ; i < answer.length(); i++) {
            if (answer.length() > 10) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num *= 10;
            num += (int) Character.digit(i, 10);
        }
        num = isPositive ? num : num*(-1);
        if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) num;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int row = 0;
        int col = 0;
        int rowend = matrix[0].length-1;
        int colend = matrix.length-1;
        while (list.size() != matrix.length*matrix[0].length) {
            for (int tmp = row; tmp < rowend+1; tmp++) {
                list.add(matrix[col][tmp]);
            }
            for (int tmp = col+1; tmp < colend+1; tmp++) {
                list.add(matrix[tmp][rowend]);
            }
            for (int tmp = rowend-1; tmp > row; tmp--) {
                list.add(matrix[colend][tmp]);
            }
            for (int tmp = colend; tmp > col; tmp--) {
                list.add(matrix[tmp][row]);
            }
            row++;
            col++;
            rowend--;
            colend--;
        }
        return list;
    }

}
