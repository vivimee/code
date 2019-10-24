/* 
  是否是回文数
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