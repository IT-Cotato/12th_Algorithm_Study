const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const board = input.map((line) => line.split(" ").map(Number));

const blanks = [];

for (let i = 0; i < 9; i++) {
  for (let j = 0; j < 9; j++) {
    if (board[i][j] === 0) {
      blanks.push([i, j]);
    }
  }
}

function isValid(x, y, num) {
  for (let i = 0; i < 9; i++) {
    if (board[x][i] === num || board[i][y] === num) {
      return false;
    }
  }
  const startX = Math.floor(x / 3) * 3;
  const startY = Math.floor(y / 3) * 3;

  for (let i = 0; i < 3; i++) {
    for (let j = 0; j < 3; j++) {
      if (board[startX + i][startY + j] === num) return false;
    }
  }

  return true;
}

function dfs(index) {
  if (index === blanks.length) {
    board.forEach((row) => console.log(row.join(" ")));
    process.exit();
  }

  const [x, y] = blanks[index];

  for (let num = 1; num <= 9; num++) {
    if (isValid(x, y, num)) {
      board[x][y] = num;
      dfs(index + 1);
      board[x][y] = 0;
    }
  }
}

dfs(0);
