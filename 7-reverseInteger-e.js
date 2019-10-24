/* 
  反转整数，取值范围[-2^31, 2^32 - 1]，反转，溢出返回0
*/

// 转成字符串，然后反转，转回数字，判断是否溢出
// 这种方法不完全符合题目要求：不用字符串、机器最多支持 2^31 - 1
var reverse = function(num) {
  let isNegative = num < 0;
  const str = String(num).split('').reverse().join('');
  let resNum = parseInt(str);
  if (resNum >= -1 * (2 ** 31) && resNum <= (2 ** 31) - 1) {
    // no op
  } else {
    resNum = 0;
  }
  return isNegative ? -1 * resNum : resNum;
}


// 每次取最后一位数，拼接到新的数字后面
// 拼接之前判断是否已经大于了 INT_MAX / 10 ，如果大于的话肯定会溢出。
// 如果等于，再判断要拼接的那个数字是否大于7（对应正数） 或者 小于-8（对应负数），超过的话则会溢出
var reverse = function(num) {
  var INT_MAX = (2 ** 31) - 1;
  var INT_MIN = -1 * (2 ** 31);

  let res = 0;
  for (; num != 0; num = parseInt(num / 10)) {
      const x = num % 10;
      if (res > parseInt(INT_MAX / 10) || (res == parseInt(INT_MAX / 10) && x > 7)) return 0;
      if (res < parseInt(INT_MIN / 10) || (res == parseInt(INT_MIN / 10) && x < -8)) return 0;
      res = res * 10 + x;
  }
  return res;
}