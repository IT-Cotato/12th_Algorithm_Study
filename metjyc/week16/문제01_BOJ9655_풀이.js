const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const N = Number(input[0]);

if (N % 2 === 1) {
  console.log("SK");
} else {
  console.log("CY");
}

// 나머지가 짝수라면 CY 출력
// 나머지가 홀수라면 SK 출력
