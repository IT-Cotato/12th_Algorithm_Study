const fs = require("fs");

const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const n = Number(input[0]);
const m = Number(input[1]);

// INF 정의하기

const INF = 1e15;

// distance를 정의하기 dist[i][j] = INF
const dist = Array.from({ length: n + 1 }, () => Array(n + 1).fill(INF));
for (let i = 1; i <= n; i++) dist[i][i] = 0;

// input 값으로 받은 노선을 각 dist에 매핑
for (let i = 2; i < 2 + m; i++) {
  const [a, b, c] = input[i].split(" ").map(Number);
  if (c < dist[a][b]) dist[a][b] = c;
}

// 각 도시로 가는 최단경로를 탐색하는 로직 작성

for (let k = 1; k <= n; k++) {
  for (let i = 1; i <= n; i++) {
    if (dist[i][k] === INF) continue;
    for (let j = 1; j <= n; j++) {
      if (dist[k][j] === INF) continue;
      const via = dist[i][k] + dist[k][j];
      if (via < dist[i][j]) dist[i][j] = via;
    }
  }
}

let out = "";
for (let i = 1; i <= n; i++) {
  const row = [];
  for (let j = 1; j <= n; j++) {
    row.push(dist[i][j] === INF ? 0 : dist[i][j]);
  }
  out += row.join(" ") + "\n";
}
console.log(out.trim());
