# DFS & BFS 알고리즘 정리

## 📌 DFS (Depth-First Search, 깊이 우선 탐색)

### 개념

- 시작 노드에서 한 갈래를 **끝까지 탐색**한 뒤, 막히면 **되돌아와(backtracking)** 다른 갈래를 탐색.
- **스택(Stack)** 자료구조를 기반으로 하며, 보통 **재귀 호출**을 사용해 구현.

### 특징

- 한 경로를 깊게 파고드는 방식.
- 백트래킹이 핵심 → 내려갈 때 상태를 기록하고, 돌아올 때 반드시 복구해야 함.
- 재귀 깊이에 주의해야 함(자바스크립트는 스택 한계가 있으므로 입력 크기에 따라 반복문+스택으로 대체 가능).

### 구현 예시 (JS)

```js
function dfs(v) {
  visited[v] = true;
  result.push(v);

  for (const next of graph[v]) {
    if (!visited[next]) {
      dfs(next);
    }
  }
}


⸻

📌 BFS (Breadth-First Search, 너비 우선 탐색)

개념
	•	시작 노드에서 가까운 정점부터 탐색 → 점차 멀리 있는 정점으로 확장.
	•	큐(Queue) 자료구조를 기반으로 하며, 레벨(거리) 단위 탐색에 적합.

특징
	•	시작점에서 각 정점까지의 최단 거리(간선 가중치 동일한 경우) 를 보장.
	•	전염, 퍼짐, 레벨 탐색 문제에 자주 활용됨.

시간/공간 복잡도
	•	시간 복잡도: O(V + E)
	•	공간 복잡도: O(V) (큐 크기, visited 배열)

구현 예시 (JS)

function bfs(start) {
  const queue = [start];
  visited[start] = true;

  while (queue.length) {
    const v = queue.shift();
    result.push(v);

    for (const next of graph[v]) {
      if (!visited[next]) {
        visited[next] = true;
        queue.push(next);
      }
    }
  }
}


⸻

📌 DFS vs BFS 비교

구분	DFS	BFS
탐색 방식	깊이 우선	너비 우선
자료구조	스택(재귀)	큐
대표 활용	백트래킹, 경로 탐색, 사이클 탐지	최단 거리, 레벨 탐색
시간 복잡도	O(V + E)	O(V + E)
공간 복잡도	O(V)	O(V)
탐색 순서	한 갈래 깊게 탐색 후 되돌아옴	가까운 정점부터 점차 확장


⸻

📌 적용된 문제

🔹 BOJ 1987 - 알파벳
	•	DFS + 백트래킹을 활용.
	•	방문 기준은 “좌표”가 아니라 알파벳의 사용 여부.
	•	Set 또는 비트마스크로 방문 상태 관리.
	•	방문 후 반드시 delete로 상태 복구 필요.

코드

const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [R, C] = input[0].split(" ").map(Number);
const board = input.slice(1).map((line) => line.split(""));

const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];

let maxCount = 0;
const visited = new Set();

function dfs(x, y, visited) {
  maxCount = Math.max(maxCount, visited.size);

  for (let i = 0; i < 4; i++) {
    const nx = x + dx[i];
    const ny = y + dy[i];

    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
      const nextAlpha = board[nx][ny];
      if (!visited.has(nextAlpha)) {
        visited.add(nextAlpha);
        dfs(nx, ny, visited);
        visited.delete(nextAlpha); // 백트래킹
      }
    }
  }
}

visited.add(board[0][0]);
dfs(0, 0, visited);

console.log(maxCount);


⸻

🔹 BOJ 1260 - DFS와 BFS
	•	인접 리스트 그래프 + 정렬(번호가 작은 노드 우선).
	•	DFS: 재귀 호출로 구현.
	•	BFS: 큐 기반으로 구현.
	•	두 탐색은 독립적인 visited 배열을 사용해야 함.

코드

const fs = require("fs");
const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, M, V] = input[0].split(" ").map(Number);
const graph = Array.from({ length: N + 1 }, () => []);

for (let i = 1; i <= M; i++) {
  const [a, b] = input[i].split(" ").map(Number);
  graph[a].push(b);
  graph[b].push(a);
}

// 정점 번호가 작은 순서대로 탐색하기 위해 정렬
for (let i = 1; i <= N; i++) {
  graph[i].sort((a, b) => a - b);
}

// DFS
const visitedDFS = Array(N + 1).fill(false);
const dfsResult = [];

function dfs(v) {
  visitedDFS[v] = true;
  dfsResult.push(v);

  for (const next of graph[v]) {
    if (!visitedDFS[next]) {
      dfs(next);
    }
  }
}

// BFS
const visitedBFS = Array(N + 1).fill(false);
const bfsResult = [];

function bfs(start) {
  const queue = [start];
  visitedBFS[start] = true;

  while (queue.length) {
    const current = queue.shift();
    bfsResult.push(current);

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


⸻

📌 실전 팁 (Node.js 기준)
	•	입출력 최적화

const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");


	•	BFS 큐 최적화
shift() 대신 인덱스 포인터로 관리하면 더 빠름.
	•	DFS 재귀 깊이
입력 크기가 크면 stack을 직접 관리하는 반복문 DFS 고려.
	•	문제 조건 주의
예: “정점 번호가 작은 순” → 인접 리스트 정렬 필요.

⸻

✍️ 이 README는 DFS/BFS 개념과,
실제 문제(BOJ 1987 알파벳, BOJ 1260 DFS와 BFS)에 적용된 방식을 정리한 자료입니다.

---
```
