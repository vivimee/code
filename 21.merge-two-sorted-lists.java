/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (49.53%)
 * Likes:    2789
 * Dislikes: 409
 * Total Accepted:    721.8K
 * Total Submissions: 1.5M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
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

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode mergListNode(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = l2.val < l1.val ? l2 : l1;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p2 != null) {
            if (p2.val < p1.val) {
                ListNode tmp = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = tmp;
            } else {
                while (p1.next != null && p2.val >= p1.next.val) {
                    p1 = p1.next;
                }
                ListNode tmp1 = p1.next;
                ListNode tmp2 = p2.next;
                p1.next = p2;
                p2.next = tmp1;
                p1 = p2;
                p2 = tmp2;
            }
        }

        return head;
    }
}

/* class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode pointer = l1;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = l2;
        pointer = l1;
        boolean sorted = true;
        while (pointer.next != null) {
            if (pointer.val > pointer.next.val) {
                int temp = pointer.val;
                pointer.val = pointer.next.val;
                pointer.next.val = temp;
                sorted = false;
            }
            pointer = pointer.next;
            if (pointer.next == null && !sorted) {
                pointer = l1;
                sorted = true;
            }
        }

        return l1;
    }
} */
// @lc code=end

