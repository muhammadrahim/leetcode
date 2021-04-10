package leetcode;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammicNumber2 {

    char[] nums;
    char[][] pairs;
    List<String> answer;

    private void generateStrobogrammaticNumber(int left, int right) {
        if (left > right) {
            answer.add(new String(nums));
            return;
        }

        for (char[] pair : pairs) {
            if (left == 0 && left != right && pair[0] == '0') {
                continue;
            } else if (left == right && pair[0] != pair[1]) {
                continue;
            }

            nums[left] = pair[0];
            nums[right] = pair[1];

            generateStrobogrammaticNumber(left + 1, right - 1);
        }
    }

    public List<String> findStrobogrammatic(int n) {

        nums = new char[n];
        pairs = new char[][]{{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
        answer = new ArrayList<>();

        generateStrobogrammaticNumber(0, n - 1);
        return answer;
    }

    public static void main(String[] args) {
        StrobogrammicNumber2 s = new StrobogrammicNumber2();
        s.findStrobogrammatic(2);
    }
}
