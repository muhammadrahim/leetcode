package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class SolutionTest {


    Solution s = new Solution();

    @Test
    void isPalindrome() {
        boolean actual = s.isPalindrome("A man, a plan, a canal: Panama");
        assertTrue(actual);
    }

    @Test
    void atoi() {
        assertEquals(s.myAtoi("42"), 42);
    }

    @Test
    void spiralOrder() {
        int[][] matrix = {{2}, {3}};
        s.spiralOrder(matrix);
    }

    @Test
    void linkedList() {
        ListNode<Integer> l = new ListNode<>(5);
        ListNode<Integer> node = new ListNode<>(10);
        ListNode<Integer> next = new ListNode<>(15);
        l.insertAfter(l, node);
        l.insertAfter(l, next);
        System.out.println();
    }
}