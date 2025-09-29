const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const n = Number(input[0]);
const commands = input.slice(1);

const stack = [];
const output = [];

for (let cmd of commands) {
  if (cmd.startsWith("push")) {
    const [, num] = cmd.split(" ");
    stack.push(Number(num));
  } else if (cmd === "pop") {
    output.push(stack.length ? stack.pop() : -1);
  } else if (cmd === "size") {
    output.push(stack.length);
  } else if (cmd === "empty") {
    output.push(stack.length === 0 ? 1 : 0);
  } else if (cmd === "top") {
    output.push(stack.length ? stack[stack.length - 1] : -1);
  }
}

console.log(output.join("\n"));
