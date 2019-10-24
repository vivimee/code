/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (34.27%)
 * Likes:    1680
 * Dislikes: 1518
 * Total Accepted:    567.2K
 * Total Submissions: 1.7M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String minStr = strs[0];
        if (minStr.equals("")) return "";
        for (int i = 1; i < strs.length; ++i) {
            if (strs[i].equals("")) return "";
            if (strs[i].charAt(0) != minStr.charAt(0)) {
                return "";
            }
            if (strs[i].length() < minStr.length()){
                minStr = strs[i];
            }
        }
        for (int i = minStr.length(); i > 0; --i) {
            String subStr = minStr.substring(0, i);
            Boolean someOneNotMatch = false;
            for (int j = 0; j < strs.length; ++j) {
                if (strs[j].indexOf(subStr) != 0) {
                    someOneNotMatch = true;
                    break;
                }
            }
            if (someOneNotMatch) {
                continue;
            } else {
                return subStr;
            }
        }
        return minStr.substring(0, 1);
    }
}
// @lc code=end

