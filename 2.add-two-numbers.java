/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (32.05%)
 * Likes:    6226
 * Dislikes: 1620
 * Total Accepted:    1.1M
 * Total Submissions: 3.3M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Length = 1;
        int l2Length = 1;
        ListNode p = l1;
        while(p.next != null) {
            ++l1Length;
            p = p.next;
        }
        p = l2;
        while(p.next != null) {
            ++l2Length;
            p = p.next;
        }
        ListNode longer;
        ListNode shoter;
        if (l1Length > l2Length) {
            longer = l1;
            shoter = l2;
        } else {
            longer = l2;
            shoter = l1;
        }
        ListNode pl = longer;
        ListNode ps = shoter;
        while (ps != null) {
            int sum = pl.val + ps.val;
            if (sum < 10) {
                pl.val = sum;
            } else {
                pl.val = sum % 10;
                if (pl.next == null) pl.next = new ListNode(0);
                pl.next.val += 1;
            }
            pl = pl.next;
            ps = ps.next;
            p = pl;
            // while (p != null && p.val > 9) {
            //     p.val %= 10;
            //     if (p.next == null) p.next = new ListNode(0);
            //     p.next.val += 1;
            //     p = p.next;
            // }
        }
        p = longer;
        while (p != null) {
            if (p.val > 9) {
                p.val %= 10;
                if (p.next == null) p.next = new ListNode(0);
                p.next.val += 1;
            }
            p = p.next;
        }
        return longer;
    }
}
// @lc code=end

