package leetcode;/* Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Example 1: Input: nums = [1,2,3] - Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Constraints: 1 <= nums.length <= 6
 * 	-10 <= nums[i] <= 10
 * 	All the integers of nums are unique.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        Queue<List<Integer>> oldPermutations = new LinkedList<>();
        oldPermutations.add(new ArrayList<Integer>());
        for (int num : nums) {
            int size = oldPermutations.size();
            for (int j = 0; j < size; j++) {
                List<Integer> currPerm = oldPermutations.poll();
                int currSize = currPerm.size();
                for (int k = 0; k <= currSize; k++) {
                    List<Integer> tmp = new ArrayList<>(currPerm);
                    tmp.add(k, num);

                    if (tmp.size() == nums.length) {
                        permutations.add(tmp);
                    } else {
                        oldPermutations.add(tmp);
                    }
                }

            }
        }
        return permutations;
    }
}
