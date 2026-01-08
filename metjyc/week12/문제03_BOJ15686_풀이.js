const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const area = input.slice(1).map((line) => line.trim().split(" ").map(Number));

const houses = [];
const chickens = [];

for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (area[i][j] === 1) houses.push([i, j]);
    else if (area[i][j] === 2) chickens.push([i, j]);
  }
}

const H = houses.length;
const C = chickens.length;

const dist = Array.from({ length: H }, () => Array(C).fill(0));

for (let h = 0; h < H; h++) {
  const [hr, hc] = houses[h];

  for (let c = 0; c < C; c++) {
    const [cr, cc] = chickens[c];
    dist[h][c] = Math.abs(hr - cr) + Math.abs(hc - cc);
  }
}

const INF = 1e9;

function calc(pick) {
  let sum = 0;

  for (let h = 0; h < H; h++) {
    let best = INF;
    for (let k = 0; k < pick.length; k++) {
      const c = pick[k];
      best = Math.min(best, dist[h][c]);
    }
    sum += best;
  }
  return sum;
}

let answer = INF;
const pick = [];

function dfs(start, picked) {
  if (picked === M) {
    answer = Math.min(answer, calc(pick));
    return;
  }

  for (let i = start; i < C; i++) {
    pick.push(i);
    dfs(i + 1, picked + 1);
    pick.pop();
  }
}

dfs(0, 0);
console.log(answer);
