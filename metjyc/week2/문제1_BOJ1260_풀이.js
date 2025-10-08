const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");
// 백준에서 node.js에 자바스크립트 입출력을 하기 위한 코드

const [N, M, V] = input[0].split(" ").map(Number); // 점과 선의 개수를 담는 변수 띄워 쓰기에 따라 문자열로 들어온 숫자 값을 숫자 값으로 변환
const graph = Array.from({ length: N + 1 }, () => []); //Array.from문을 사용하여 첫번째가 빈값인 2차원 배열 생성 인덱스 1부터 사용해야해서 0번쨰는 빈값

for (let i = 1; i <= M; i++) {
  const [a, b] = input[i].split(" ").map(Number); // 인풋값에 들어온  1번째 값부터 노드 트리를 상징하므로 띄어쓰기로 서로 구분
  graph[a].push(b);
  graph[b].push(a);
  // 그래프는 양방향이기 때문에 나온 코드
}

// 정점 번호가 작은 순서대로 탐색하기 위해 정렬
for (let i = 1; i <= N; i++) {
  graph[i].sort((a, b) => a - b);
}

// DFS
const visitedDFS = Array(N + 1).fill(false); // N값 보다 하나 더 false값을 배열 전체에 할당
const dfsResult = []; // 결과값 선언문

function dfs(v) {
  visitedDFS[v] = true; //v 값을 이용해 첫번째 값을 순회했다고 바꾸는 코드
  dfsResult.push(v); // 순회 했으므로 결과값에 푸쉬

  for (const next of graph[v]) {
    // 그래프에 있는 V값만큼 순회돌기
    if (!visitedDFS[next]) {
      // 만약 방문한 값이 true이면 다음 값 할당
      dfs(next);
    }
  }
}

// BFS
const visitedBFS = Array(N + 1).fill(false); // 위 dfs 선언 문과 같은 코드
const bfsResult = [];

function bfs(start) {
  const queue = [start]; // 큐에 시작값 할당
  visitedBFS[start] = true; // 시작한 점은 방문한 곳이므로 true 값 할당

  while (queue.length) {
    // 큐 길이 값만큼 while문 반복
    const current = queue.shift(); // 현재값에 큐 맨 앞에있는 값 쉬프트로 할당
    bfsResult.push(current); // 현재 값 결과값에 할당

    for (const next of graph[current]) {
      if (!visitedBFS[next]) {
        visitedBFS[next] = true;
        queue.push(next);
      }
    }
  }
}

// 실행
dfs(V);
bfs(V);

console.log(dfsResult.join(" "));
console.log(bfsResult.join(" "));
