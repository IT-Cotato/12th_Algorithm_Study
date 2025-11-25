const fs = require("fs");

const input = fs.readFileSync(0, "utf8").trim().split("\n");

const [N, M] = input[0].split(" ").map(Number);

// 듣도 못한 사람 목록을 Set에 저장
const heardSet = new Set();

for (let i = 1; i <= N; i++) {
  heardSet.add(input[i].trim());
}

// 듣보잡 후보 찾기
const result = [];

for (let i = N + 1; i <= N + M; i++) {
  const name = input[i].trim();
  if (heardSet.has(name)) {
    result.push(name);
  }
}

// 사전순 정렬
result.sort();

// 출력
let output = "";
output += result.length + "\n";
output += result.join("\n");
console.log(output);
