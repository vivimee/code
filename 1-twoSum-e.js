/* 
  输入一个数组和目标值，输出两个数组的下标（不同的下标），他们的和等于目标值
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