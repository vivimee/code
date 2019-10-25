import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (37.44%)
 * Likes:    3498
 * Dislikes: 171
 * Total Accepted:    732.6K
 * Total Submissions: 2M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * 
 */

// @lc code=start
class Solution {
    public int mapCharToInt(char c) {
        int x = 0;
        switch (c) {
            case '[':
                x = 1;
                break;
            case '(':
                x = 2;
                break;
            case '{':
                x = 3;
                break;
            case ']':
                x = -1;
                break;
            case ')':
                x = -2;
                break;
            case '}':
                x = -3;
                break;
        }
        return x;
    }

    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); ++i) {
            int x = this.mapCharToInt(s.charAt(i));
            if (x > 0) {
                stack.add(x);
            } else if (x < 0) {
                if (stack.isEmpty()) return false;
                int top = stack.pop();
                if (top + x == 0) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end
