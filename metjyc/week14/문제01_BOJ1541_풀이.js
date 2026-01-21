const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const arr = String(input[0]);

const chunks = arr.split("-");

function sumChunk(str) {
  const parts = str.split("+");
  const nums = parts.map(Number);
  const sum = nums.reduce((acc, cur) => acc + cur, 0);
  return sum;
}

let result = sumChunk(chunks[0]);
for (let i = 1; i < chunks.length; i++) {
  result -= sumChunk(chunks[i]);
}

console.log(result);
