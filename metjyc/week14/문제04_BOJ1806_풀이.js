const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, S] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);

let left = 0;
let sum = 0;
let ans = Infinity;

for (let right = 0; right < N; right++) {
  sum += arr[right];

  while (sum >= S) {
    ans = Math.min(ans, right - left + 1);
    sum -= arr[left];
    left++;
  }
}

console.log(ans === Infinity ? 0 : ans);
