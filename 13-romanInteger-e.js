/* 
  罗马数字转换成十进制数字
*/


var romanToInt = function(s) {
  const map = {
      I: 1,
      V: 5,
      X: 10, 
      L: 50,
      C: 100,
      D: 500,
      M: 1000,
      IV: 4,
      IX: 9,
      XL: 40,
      XC: 90,
      CD: 400,
      CM: 900,
  };
  if (s.length === 1) return map[s];
  let res = 0;
  let i = 0;
  while(i < s.length) {
      const s1 = s[i];
      const s2 = s[i] + s[i + 1];
      if (map[s2]) {
          res += map[s2];
          i = i + 2;
      } else {
          res += map[s1];
          i = i + 1
      }
  }
  return res;
};