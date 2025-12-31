const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const INF = 1e15;

const dist = Array.from({ length: N + 1 }, () => Array(N + 1).fill(INF));
const next = Array.from({ length: N + 1 }, () => Array(N + 1).fill(0));

for (let i = 1; i <= N; i++) dist[i][i] = 0;

for (let i = 1; i <= M; i++) {
  const [a, b, w] = input[i].split(" ").map(Number);
  if (w < dist[a][b]) {
    dist[a][b] = w;
    dist[b][a] = w;

    next[a][b] = b;
    next[b][a] = a;
  }
}

for (let k = 1; k <= N; k++) {
  for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= N; j++) {
      if (dist[i][k] + dist[k][j] < dist[i][j]) {
        dist[i][j] = dist[i][k] + dist[k][j];
        next[i][j] = next[i][k];
      }
    }
  }
}

const out = [];
for (let i = 1; i <= N; i++) {
  const row = [];
  for (let j = 1; j <= N; j++) {
    if (i === j) row.push("-");
    else row.push(String(next[i][j]));
  }
  out.push(row.join(" "));
}
console.log(out.join("\n"));
