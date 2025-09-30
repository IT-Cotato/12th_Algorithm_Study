const fs = require("fs");

const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const testCaseCount = Number(input[0]);
let j = 1;

for (let i = 0; i < testCaseCount; i++) {
  const [n, m] = input[j].split(" ").map(Number);
  const priorities = input[j + 1].split(" ").map(Number);

  const queue = priorities.map((priority, index) => [priority, index]);
  let count = 0;

  while (queue.length) {
    const cur = queue.shift();
    const hasHigherPriority = queue.some(([priority]) => priority > cur[0]);

    if (hasHigherPriority) {
      queue.push(cur);
    } else {
      count++;
      if (cur[1] === m) {
        console.log(count);
        break;
      }
    }
  }

  j += 2;
}
