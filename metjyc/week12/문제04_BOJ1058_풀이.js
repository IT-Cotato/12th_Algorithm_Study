const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const N = Number(input[0]);
const arr = input.slice(1);

const INF = 1e9;
const dist = Array.from({ length: N }, () => Array(N).fill(INF));

for (let i = 0; i < N; i++) {
  dist[i][i] = 0;
  for (let j = 0; j < N; j++) {
    if (arr[i][j] === "Y") dist[i][j] = 1;
  }
}

for (let k = 0; k < N; k++) {
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
    }
  }
}

let ans = 0;
for (let i = 0; i < N; i++) {
  let cnt = 0;
  for (let j = 0; j < N; j++) {
    if (dist[i][j] <= 2 && i !== j) cnt++;
  }
  ans = Math.max(ans, cnt);
}

console.log(ans);
