const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const N = Number(input[0]);
const arr = input.slice(1);

function same(x, y, size) {
  const first = arr[x][y];
  for (let i = x; i < x + size; i++) {
    for (let j = y; j < y + size; j++) {
      if (arr[i][j] !== first) return false;
    }
  }
  return true;
}

function compress(x, y, size) {
  if (same(x, y, size)) return arr[x][y];

  const half = size / 2;
  const lu = compress(x, y, half);
  const ru = compress(x, y + half, half);
  const ld = compress(x + half, y, half);
  const rd = compress(x + half, y + half, half);

  return "(" + lu + ru + ld + rd + ")";
}

console.log(compress(0, 0, N));
