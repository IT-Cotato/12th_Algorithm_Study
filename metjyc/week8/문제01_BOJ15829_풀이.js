const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const L = Number(input[0]);
const str = input[1].trim();
// console.log(L);
// console.log(str);

const r = 31;
const M = 1234567891;

let hash = 0;
let power = 1;

for (let i = 0; i < L; i++) {
  const ch = str[i];
  const a = ch.charCodeAt(0) - 96;

  hash = (hash + a * power) % M;
  power = (power * r) % M;
}

console.log(hash);
