const fs = require("fs");
const input = fs.readFileSync(0, "utf8").trim().split(/\s+/).map(Number);

let idx = 0;
const N = input[idx++];
const K = input[idx++];

const arr = input.slice(idx, idx + N);

// ai <= 100000
const cnt = new Array(100001).fill(0);

let left = 0;
let ans = 0;

for (let right = 0; right < N; right++) {
  const x = arr[right];
  cnt[x]++;

  while (cnt[x] > K) {
    cnt[arr[left]]--;
    left++;
  }

  const len = right - left + 1;
  if (len > ans) ans = len;
}

console.log(ans.toString());
