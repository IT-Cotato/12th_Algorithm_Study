const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, K] = input[0].split(" ").map(Number);

const items = [];
for (let i = 1; i <= N; i++) {
  const [W, V] = input[i].split(" ").map(Number);
  items.push([W, V]);
}

const dp = Array(K + 1).fill(0);

for (let i = 0; i < N; i++) {
  const [W, V] = items[i];

  for (let w = K; w >= W; w--) {
    dp[w] = Math.max(dp[w], dp[w - W] + V);
  }
}

console.log(dp[K]);
