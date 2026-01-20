const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [n, m] = input[0].split(" ").map(Number);
const T = input[1].split(" ").map(Number);

let windowSum = 0;

for (let i = 0; i < m; i++) {
  windowSum += T[i];
}

let best = windowSum;

for (let i = m; i < n; i++) {
  windowSum += T[i];
  windowSum -= T[i - m];
  if (best < windowSum) {
    best = windowSum;
  }
}
console.log(best);
