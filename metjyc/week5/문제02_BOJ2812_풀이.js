const fs = require("fs");

const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

//

const [N, K] = input[0].split(" ").map(Number);
const number = input[1].trim();

// console.log(N, K);
// console.log(number);

// 왼쪽에서부터
const stack = [];
let removeCount = K;

for (const digit of number) {
  while (
    removeCount > 0 &&
    stack.length > 0 &&
    stack[stack.length - 1] < digit
  ) {
    stack.pop();
    removeCount -= 1;
  }

  stack.push(digit);
}

if (removeCount > 0) {
  stack.splice(stack.length - removeCount, removeCount);
}

console.log(stack.join(""));
