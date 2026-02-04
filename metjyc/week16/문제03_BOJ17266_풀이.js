const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const N = Number(input[0]);
const M = Number(input[1]);
const location = input[2].split(" ").map(Number);

let ans = 0;

// 1) 시작(0) 커버
ans = Math.max(ans, location[0]);

// 2) 끝(N) 커버
ans = Math.max(ans, N - location[M - 1]);

for (let i = 0; i < M - 1; i++) {
  const gap = location[i + 1] - location[i];
  const need = Math.ceil(gap / 2);
  ans = Math.max(ans, need);
}
console.log(ans);
