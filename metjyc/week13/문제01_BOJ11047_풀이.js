const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, K] = input[0].split(" ").map(Number);
let cur = K;
let ans = 0;

const coin = input.slice(1).map(Number);

for (let i = N - 1; i >= 0; i--) {
  const c = coin[i];
  const cnt = Math.floor(cur / c);
  ans += cnt;
  cur %= c;
  if (cur === 0) {
    break;
  }
}

console.log(ans);
