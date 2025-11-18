const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const N = Number(input[0]);
const paper = input.slice(1).map((line) => line.split(" ").map(Number));

let minusCount = 0;
let zeroCount = 0;
let plusCount = 0;

function cut(x, y, size) {
  const first = paper[x][y];
  let same = true;

  for (let i = x; i < x + size; i++) {
    for (let j = y; j < y + size; j++) {
      if (paper[i][j] !== first) {
        same = false;
        break;
      }
    }
    if (!same) break;
  }

  if (same) {
    if (first === -1) minusCount++;
    else if (first === 0) zeroCount++;
    else plusCount++;
    return;
  }

  const newSize = size / 3;

  for (let dx = 0; dx < 3; dx++) {
    for (let dy = 0; dy < 3; dy++) {
      cut(x + dx * newSize, y + dy * newSize, newSize);
    }
  }
}

cut(0, 0, N);

console.log(minusCount);
console.log(zeroCount);
console.log(plusCount);
