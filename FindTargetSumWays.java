package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return recurse(nums, 0, target, 0, 0, memo);
    }

    int recurse(int[] nums, int index, int target, int total, int count, Map<String, Integer> memo) {
        if (memo.containsKey(index+ "_" + total)) return memo.get(index+"_"+total);
        if (index == nums.length && total == target) {
            return count+1;
        }
        if (index >= nums.length) return count;
        int a = recurse(nums, index+1, target, total + nums[index], count, memo);
        int b = recurse(nums, index+1, target, total - nums[index], count, memo);
        memo.put(index+"_"+total, count);
        return a+b;
    }
}
