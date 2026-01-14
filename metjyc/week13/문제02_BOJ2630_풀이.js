const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const N = Number(input[0]);
const map = input.slice(1).map((line) => line.split(" ").map(Number));

function check(x, y, size) {
  const base = map[x][y];
  let same = true;
  for (let i = x; i < x + size; i++) {
    for (let j = y; j < y + size; j++) {
      if (map[i][j] !== base) {
        same = false;
        break;
      }
    }
    if (!same) break;
  }

  return same;
}

let white = 0;
let blue = 0;

function mapping(x, y, size) {
  if (check(x, y, size)) {
    if (map[x][y] === 0) {
      white++;
    } else if (map[x][y] === 1) {
      blue++;
    }
    return;
  }
  const half = size / 2;
  mapping(x, y, half);
  mapping(x, y + half, half);
  mapping(x + half, y, half);
  mapping(x + half, y + half, half);
}
mapping(0, 0, N);
console.log(white);
console.log(blue);
