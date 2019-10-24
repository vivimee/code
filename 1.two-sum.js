/*
 * @lc app=leetcode id=1 lang=javascript
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (44.67%)
 * Likes:    12241
 * Dislikes: 429
 * Total Accepted:    2.2M
 * Total Submissions: 5M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
/* 遍历，求所有项的和 */
var twoSum = function(nums, target) {
  for (let i = 0; i < nums.length - 1; ++i) {
    for (let j = i + 1; j <= nums.length; ++j) {
      if (nums[i] + nums[j] === target) {
        return [i, j];
      }
    }
  }
}



/* 只遍历一遍，通过map，去判断 target - nums[i] 是否在数组中存在。 */
var twoSum = function(nums, target) {
  let mapper = {};
  for (let i = 0; i < nums.length; ++i) {
    mapper[nums[i]] = i;
  }
  for (let i = 0; i < nums.length; ++i) {
    const res = target - nums[i];
    if (mapper[res] >= 0 && mapper[res] !== i) {
      return [i, mapper[res]];
    }
  }
}
// @lc code=end

