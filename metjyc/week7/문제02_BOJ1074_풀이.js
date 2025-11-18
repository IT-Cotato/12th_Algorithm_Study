const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

const [N, r, c] = input;

function z(n, row, col) {
  if (n === 0) return 0;

  const half = 1 << (n - 1);
  const area = half * half;

  if (row < half && col < half) {
    return z(n - 1, row, col);
  } else if (row < half && col >= half) {
    return area + z(n - 1, row, col - half);
  } else if (row >= half && col < half) {
    return area * 2 + z(n - 1, row - half, col);
  } else {
    return area * 3 + z(n - 1, row - half, col - half);
  }
}

console.log(z(N, r, c));
