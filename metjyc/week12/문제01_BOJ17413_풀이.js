const fs = require("fs");
// const input = fs
//   .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
//   .toString()
//   .trim()
//   .split("\n");
const S = fs.readFileSync(0, "utf8").trimEnd();

let inTag = false;
let stack = [];
let out = [];

for (let i = 0; i < S.length; i++) {
  const ch = S[i];

  if (ch === "<") {
    while (stack.length) out.push(stack.pop());
    inTag = true;
    out.push(ch);
    continue;
  }

  if (inTag) {
    out.push(ch);
    if (ch === ">") inTag = false;
    continue;
  }

  if (ch === " ") {
    while (stack.length) out.push(stack.pop());
    out.push(" ");
  } else {
    stack.push(ch);
  }
}

while (stack.length) out.push(stack.pop());

console.log(out.join(""));
