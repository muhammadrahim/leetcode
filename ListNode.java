package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ListNode<T> {
    private T data;
    private ListNode<T> next;

    public ListNode(T data) {
        this.data = data;
    }

    public ListNode<T> search(ListNode<T> l, int key) {
        ListNode<T> tmp = l;
        while (tmp != null && !tmp.data.equals(key)) {
            tmp = tmp.next;
        }
        return tmp;
    }

    public void insertAfter(ListNode<T> node, ListNode<T> newNode) {
        ListNode<T> next = node.next;
        node.next = newNode;
        newNode.next = next;
    }

    public void delete(ListNode<T> node) {
        this.next = node.next;
    }

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        Map<Character, Integer> foundChars = new HashMap<>();
        int start = 0;
        int[] res = {-1, 0, 0};
        int found = 0;

        int[] vals = new int[3];
        for (int i : vals) {

        }
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            foundChars.put(c, foundChars.containsKey(c) ? foundChars.get(c) + 1 : 1);
            if (map.containsKey(c) && foundChars.get(c).equals(map.get(c))) {
                found++;
            }
            while (start <= end && found == map.size()) {
                if (res[0] == -1 || end - start + 1 < res[0]) {
                    res[0] = end - start + 1;
                    res[1] = start;
                    res[2] = end;
                }
                c = s.charAt(start);
                foundChars.put(c, foundChars.get(c) - 1);
                if (map.containsKey(c) && foundChars.get(c) < map.get(c)) {
                    found--;
                }
                start++;
            }
        }
        return res[0] == -1 ? "" : s.substring(res[1], res[2] + 1);
    }
}


//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(nums);
//        for (int i = 0; i + 2 < nums.length; i++) {
//            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
//                continue;
//            }
//            int left = i + 1;
//            int right = nums.length - 1;
//            int target = -nums[i];
//            while (left < right) {
//                if (nums[left] + nums[right] == target) {
//                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                    left++;
//                    right--;
//                    while (left < right && nums[left] == nums[left - 1]) left++;  // skip same result
//                    while (left < right && nums[right] == nums[right + 1]) right--;  // skip same result
//                } else if (nums[left] + nums[right] > target) {
//                    right--;
//                } else {
//                    left++;
//                }
//            }
//        }
//        return res;
//    }