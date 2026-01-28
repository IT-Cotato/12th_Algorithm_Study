const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const n = Number(input[0]);
const dp = Array.from({ length: n }, () => Array(n).fill(0));

for (let i = 0; i < n; i++) {
  const arr = input[i + 1].split(" ").map(Number);

  for (let j = 0; j <= i; j++) {
    if (i === 0 && j === 0) {
      dp[0][0] = arr[0];
    } else if (j === 0) {
      dp[i][j] = dp[i - 1][j] + arr[j];
    } else if (j === i) {
      dp[i][j] = dp[i - 1][j - 1] + arr[j];
    } else {
      dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[j];
    }
  }
}

console.log(Math.max(...dp[n - 1]));
