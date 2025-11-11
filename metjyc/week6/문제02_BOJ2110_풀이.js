const fs = require("fs");

const input = fs.readFileSync(0, "utf8").trim().split("\n");
const [N, C] = input[0].split(" ").map(Number);

const distance = new Array(N);
for (let i = 0; i < N; i++) {
  distance[i] = Number(input[1 + i]);
}

distance.sort((a, b) => a - b);

let lowDistance = 1;
let highDistance = distance[N - 1] - distance[0];
let answer = 0;

function canPlace(d) {
  let count = 1;
  let last = distance[0];
  for (let i = 1; i < N; i++) {
    if (distance[i] - last >= d) {
      count++;
      last = distance[i];
      if (count >= C) return true;
    }
  }
  return false;
}

while (lowDistance <= highDistance) {
  const mid = (lowDistance + highDistance) >> 1;
  if (canPlace(mid)) {
    answer = mid;
    lowDistance = mid + 1;
  } else {
    highDistance = mid - 1;
  }
}

console.log(answer);
