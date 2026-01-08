const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const [x1, y1, x2, y2] = input[1].split(" ").map(Number);

const area = input.slice(2).map((line) => line.trim().split(""));

const sx = x1 - 1,
  sy = y1 - 1;
const tx = x2 - 1,
  ty = y2 - 1;

const INF = 1e15;
const dist = Array.from({ length: N }, () => Array(M).fill(INF));
dist[sx][sy] = 0;

const maxSize = N * M * 2;
const qx = new Array(maxSize);
const qy = new Array(maxSize);
let front = Math.floor(maxSize / 2);
let back = Math.floor(maxSize / 2);

function pushFront(x, y) {
  front--;
  qx[front] = x;
  qy[front] = y;
}
function pushBack(x, y) {
  qx[back] = x;
  qy[back] = y;
  back++;
}
function popFront() {
  const x = qx[front];
  const y = qy[front];
  front++;
  return [x, y];
}
function isEmpty() {
  return front === back;
}

pushFront(sx, sy);

const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];

while (!isEmpty()) {
  const [x, y] = popFront();

  for (let k = 0; k < 4; k++) {
    const nx = x + dx[k];
    const ny = y + dy[k];

    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

    const cost = area[nx][ny] === "1" ? 1 : 0;
    const nd = dist[x][y] + cost;

    if (nd < dist[nx][ny]) {
      dist[nx][ny] = nd;
      if (cost === 0) pushFront(nx, ny);
      else pushBack(nx, ny);
    }
  }
}

console.log(dist[tx][ty] + 1);
