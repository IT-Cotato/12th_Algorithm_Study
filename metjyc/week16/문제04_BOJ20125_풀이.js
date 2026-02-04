const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const N = Number(input[0]);

const grid = input.slice(1).map((line) => line.trim().split(""));
let head = null;

for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (grid[i][j] === "*") {
      head = [i, j];
      break;
    }
  }
  if (head) break;
}

const heart = [head[0] + 1, head[1]];

const heartX = heart[0];
const heartY = heart[1];
let x = heartX;
let y = heartY - 1;

let leftArm = 0;
let rightArm = 0;
let waist = 0;
let leftleg = 0;
let rightleg = 0;
while (y >= 0 && grid[x][y] === "*") {
  leftArm++;
  y--;
}

y = heartY + 1;

while (y < N && grid[heartX][y] === "*") {
  rightArm++;
  y++;
}

x = heartX + 1;
while (x < N && grid[x][heartY] === "*") {
  waist++;
  x++;
}

const waistEndX = x - 1;

let lx = waistEndX + 1;
while (lx < N && grid[lx][heartY - 1] === "*") {
  leftleg++;
  lx++;
}

let rx = waistEndX + 1;
while (rx < N && grid[rx][heartY + 1] === "*") {
  rightleg++;
  rx++;
}
console.log(heartX + 1, heartY + 1);
console.log(leftArm, rightArm, waist, leftleg, rightleg);
