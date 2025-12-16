const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const n = Number(input[0]);
const Mod = 10007;
const dp = Array(n + 1).fill(0);

dp[1] = 1;
if (n >= 2) dp[2] = 2;

for (let i = 3; i <= n; i++) {
  dp[i] = (dp[i - 1] + dp[i - 2]) % Mod;
}
console.log(dp[n]);
