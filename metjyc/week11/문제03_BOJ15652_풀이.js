const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const arr = Array(M);

const out = [];

function dfs(depth) {
  if (depth === M) {
    out.push(arr.join(" "));
    return;
  }

  for (let i = 1; i <= N; i++) {
    arr[depth] = i;
    dfs(depth + 1);
  }
}

dfs(0);
console.log(out.join("\n"));
