const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const [N, S] = input[0].split(" ").map(Number);
const numbers = input[1].split(" ").map(Number);

let count = 0;

function dfs(index, currentSum, pickedCount) {
  if (index === N) {
    if (currentSum === S && pickedCount > 0) {
      count += 1;
    }
    return;
  }

  // 현재 원소를 선택하는 경우
  dfs(index + 1, currentSum + numbers[index], pickedCount + 1);

  // 현재 원소를 선택하지 않는 경우
  dfs(index + 1, currentSum, pickedCount);
}

dfs(0, 0, 0);

console.log(count);
