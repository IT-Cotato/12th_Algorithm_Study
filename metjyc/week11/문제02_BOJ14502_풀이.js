const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const lab = input.slice(1).map((line) => line.split(" ").map(Number));

const empties = [];
const viruses = [];

for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    if (lab[i][j] === 0) empties.push([i, j]);
    else if (lab[i][j] === 2) viruses.push([i, j]);
  }
}

const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];

let answer = 0;

function spreadAndCountSafe() {
  const tmp = lab.map((row) => row.slice());

  const q = [];
  let head = 0;
  for (const [x, y] of viruses) q.push([x, y]);

  while (head < q.length) {
    const [x, y] = q[head++];

    for (let dir = 0; dir < 4; dir++) {
      const nx = x + dx[dir];
      const ny = y + dy[dir];

      if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

      if (tmp[nx][ny] === 0) {
        tmp[nx][ny] = 2;
        q.push([nx, ny]);
      }
    }
  }

  let safe = 0;
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (tmp[i][j] === 0) safe++;
    }
  }
  return safe;
}

function buildWalls(start, count) {
  if (count === 3) {
    const safe = spreadAndCountSafe();
    if (safe > answer) answer = safe;
    return;
  }

  for (let i = start; i < empties.length; i++) {
    const [x, y] = empties[i];

    lab[x][y] = 1;

    buildWalls(i + 1, count + 1);
    lab[x][y] = 0;
  }
}

buildWalls(0, 0);
console.log(answer);
