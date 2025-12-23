const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, X] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);

// 1) 첫 윈도우 합
let sum = 0;
for (let i = 0; i < X; i++) sum += arr[i];

let maxSum = sum;
let count = 1;

// 2) 슬라이딩
for (let r = X; r < N; r++) {
  sum += arr[r];
  sum -= arr[r - X];

  if (sum > maxSum) {
    maxSum = sum;
    count = 1;
  } else if (sum === maxSum) {
    count++;
  }
}

// 3) 출력
if (maxSum === 0) {
  console.log("SAD");
} else {
  console.log(maxSum);
  console.log(count);
}
