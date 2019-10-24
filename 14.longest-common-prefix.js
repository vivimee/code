/*
 * @lc app=leetcode id=14 lang=javascript
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
/**
 * @param {string[]} strs
 * @return {string}
 */

 /* 先找到最短的字符串，再用它当最长的公共前缀串去遍历，有不匹配的则去掉最后一位 */
var longestCommonPrefix = function(strs) {
  let minStr = strs[0];
  if (!minStr) return '';
  for (let i = 1; i < strs.length; ++i) {
    if (minStr[0] !== strs[i][0]) return '';
    if (minStr.length > strs[i].length) {
      minStr = strs[i];
    }
  }
  for (let i = minStr.length; i > 0; --i) {
    let subStr = minStr.substring(0, i);
    let someOneNotMatch = false;
    for (let j = 0; j < strs.length; ++j) {
      if (strs[j].indexOf(subStr) !== 0) {
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
  return minStr[0];
};
// @lc code=end

console.log(longestCommonPrefix(['abcde', 'abefs', 'abef']));