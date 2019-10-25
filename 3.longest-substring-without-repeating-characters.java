import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (29.02%)
 * Likes:    6717
 * Dislikes: 395
 * Total Accepted:    1.2M
 * Total Submissions: 4M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        String max = s.substring(0, 1);
        String tmp = max;
        int x = 1;
        int ctrl = 0;
        while (x < s.length()) {
            char c = s.charAt(x);
            if (tmp.indexOf(c) == -1) {
                tmp += c;
                ++x;
            } else {
                ++ctrl;
                if (tmp.length() > max.length()) {
                    max = tmp;
                }
                int begin = ctrl;
                tmp = s.substring(begin, begin + 1);
                x = begin + 1;
            }
        }
        if (tmp.length() > max.length()) {
            max = tmp;
        }
        return max.length();
    }
}
// @lc code=end

