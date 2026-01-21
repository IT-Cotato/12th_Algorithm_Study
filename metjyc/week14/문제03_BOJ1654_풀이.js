const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [K, N] = input[0].split(" ").map(Number);

const lan = input.slice(1).flatMap((line) => line.split(" ").map(Number));

let left = 1;
let right = Math.max(...lan);

let answer = 0;

while (left <= right) {
  const mid = Math.floor((left + right) / 2);
  let count = 0;

  for (let i = 0; i < K; i++) {
    count += Math.floor(lan[i] / mid);
  }

  console.log(count);

  if (count >= N) {
    answer = mid;
    left = mid + 1;
  } else {
    right = mid - 1;
  }
}

console.log(answer);
