const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const [R, C] = input[0].split(" ").map(Number); // 보드 크기
const board = input.slice(1).map((line) => line.split("")); // 2차원 배열로 변환

// 상하좌우 이동을 위한 방향 벡터
const dx = [1, -1, 0, 0];
const dy = [0, 0, 1, -1];

// 방문한 알파벳을 기록하기 위한 Set
const visited = new Set();
visited.add(board[0][0]); // 시작 위치 알파벳 추가

let maxCount = 0; // 최대 이동 칸 수 기록

function dfs(x, y, visited) {
  // 현재까지의 방문 길이로 최대값 갱신
  maxCount = Math.max(maxCount, visited.size);

  // 4방향으로 이동 시도
  for (let i = 0; i < 4; i++) {
    const nx = x + dx[i];
    const ny = y + dy[i];

    // 보드 범위 확인
    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
      const nextAlpha = board[nx][ny];

      // 아직 방문하지 않은 알파벳일 때만 이동
      if (!visited.has(nextAlpha)) {
        visited.add(nextAlpha); // 방문 표시
        dfs(nx, ny, visited); // 재귀 탐색
        visited.delete(nextAlpha); // 백트래킹 (원상복구)
      }
    }
  }
}

// 시작 위치 (0,0)에서 DFS 시작
dfs(0, 0, visited);

// 결과 출력
console.log(maxCount);
