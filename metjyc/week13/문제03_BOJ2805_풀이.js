const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const trees = input[1].split(" ").map(Number);

let maxH = 0;
for (let i = 0; i < trees.length; i++) {
  if (trees[i] > maxH) maxH = trees[i];
}

function canGet(h) {
  let sum = 0;
  for (let i = 0; i < trees.length; i++) {
    if (trees[i] > h) {
      sum += trees[i] - h;
    }
  }
  if (sum >= M) {
    return true;
  } else {
    return false;
  }
}

let left = 0;
let right = maxH;
let ans = 0;

while (left <= right) {
  const mid = Math.floor((left + right) / 2);

  if (canGet(mid)) {
    ans = mid;
    left = mid + 1;
  } else {
    right = mid - 1;
  }
}
console.log(ans);
