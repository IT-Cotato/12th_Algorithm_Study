const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const P = Number(input[0]);

for (let tc = 1; tc <= P; tc++) {
  //테스트 케이스로 인덱스 선언 P만큼 반복
  const parts = input[tc].trim().split(" ").map(Number); // 1번부터 키이므로 1번부터 받기
  const T = parts[0]; // 테스트 케이스 번호만 받기
  const heights = parts.slice(1); // 순회 돌 배열
  let ans = 0; // 바뀐횟수 카운트
  for (let i = 1; i < 20; i++) {
    // 비교해야하니 2번째 첫번째중 두번쨰 먼저
    for (let j = 0; j < i; j++) {
      // 얘는 첫번째부터 받기
      if (heights[j] > heights[i]) {
        // 첫번째 두번째 비교
        ans++; // 더 큰애가 앞에 있는거면 카운트 증가
      }
    }
  }
  console.log(T, ans); //출력
}
