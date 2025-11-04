const fs = require("fs");

const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

// 회의의 개수
const N = Number(input[0]);

const meetingList = [];

// 2번째 줄부터 N+1번째 줄까지 회의 시간 저장
for (let i = 1; i <= N; i++) {
  const [startTime, endTime] = input[i].split(" ").map(Number);
  meetingList.push([startTime, endTime]);
}

// 종료 시간을 기준으로 정렬 (끝나는 시간이 같으면 시작 시간 기준)
meetingList.sort((a, b) => {
  if (a[1] === b[1]) return a[0] - b[0];
  return a[1] - b[1];
});

let count = 0;
let lastEnd = 0;

for (const [start, end] of meetingList) {
  if (start >= lastEnd) {
    count++;
    lastEnd = end;
  }
}

console.log(count);
