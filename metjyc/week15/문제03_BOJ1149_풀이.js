const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const N = Number(input[0]);

const firstCost = input[1].split(" ").map(Number);
let [dpR, dpG, dpB] = firstCost;

for (let i = 2; i <= N; i++) {
  const [r, g, b] = input[i].split(" ").map(Number);

  const nextR = Math.min(dpG, dpB) + r;
  const nextG = Math.min(dpR, dpB) + g;
  const nextB = Math.min(dpG, dpR) + b;

  dpR = nextR;
  dpG = nextG;
  dpB = nextB;
}

console.log(Math.min(dpR, dpG, dpB));
