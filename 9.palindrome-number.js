/*
 * @lc app=leetcode id=9 lang=javascript
 *
 * [9] Palindrome Number
 *
 * https://leetcode.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (45.34%)
 * Likes:    1680
 * Dislikes: 1402
 * Total Accepted:    708.6K
 * Total Submissions: 1.6M
 * Testcase Example:  '121'
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome
 * when it reads the same backward as forward.
 * 
 * Example 1:
 * 
 * 
 * Input: 121
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a
 * palindrome.
 * 
 * 
 * Follow up:
 * 
 * Coud you solve it without converting the integer to a string?
 * 
 */

// @lc code=start
/**
 * @param {number} x
 * @return {boolean}
 */
// 字符串-反转-比较
var isPalindrome = function(x) {
  let str = x.toFixed();
  let rev = '';
  for (let i = str.length - 1; i >= 0; --i) {
      rev += str[i];
  }
  return str == rev;
};

// 只判断输入数字的后一半反转之后，和输入数字的前一半是否相等。 当后一半反转之后大于等于前一半，说明已经取了一半了。
var isPalindrome = function(x) {
if (x < 0) return false;
if (x == 0) return true;
if (x % 10 == 0) return false;
let rev = 0;
for (;x > rev;) {
    rev = rev * 10 + x % 10;
    // 对应奇数位的数字：新数字加了一位，旧数字还没减一位，如果相等则是回文数
    if (x == rev) return true;
    x = parseInt(x / 10);
    // 对应偶数位数字：新数字加了一位，旧数字减去了一位，如果相等，则是回文数
    if (x == rev) return true;
    if (x < rev) return false;
}
};
// @lc code=end

