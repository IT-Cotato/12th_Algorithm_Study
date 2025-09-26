## DFS

### 01. “DFS” 란?

- 깊이 우선 탐색
- 그래프의 시작 노드에서 출발하여 한 쪽 분기를 최대 깊이까지 탐색한 뒤, 다른 분기로 이동하여 탐색
- 스택 자료구조 이용하거나 재귀 함수로 구현
- 한 번 방문한 노드는 다시 방문하지 않도록 방문 배열(visited) 필요(예를 들어 모든 경우의 수를 알아야할 때 visited 체크 안 하는 경우도 있음)
- 끊어진 그래프인 경우 : 노드 전체를 순회하면서 방문 안 된 노드에서 다시 DFS를 시작

### 02. 구현 방법

1. 노드 개수, 에지 개수 입력받기
2. 인접리스트 초기화

    ```java
    static ArrayList<Integer>[] A;
    
    A = new ArrayList[n+1];
    for (int i = 1; i < n+1; i++) {
        A[i] = new ArrayList<Integer>();
    }
    ```

3. 방문 배열 만들기
4. 에지 개수만큼 양방향 에지 추가하기(단방향인 경우도 있음)

    ```java
    A[s].add(e);
    A[e].add(s);
    ```

5. 끊어진 그래프 처리(연결 요소 세기 포함)

    ```java
    int count = 0;
    for (int i = 1; i < n+1; i++) {
      // 방문하지 않은 노드가 없을 때까지 반복
      if(!visited[i]) {
          count++;
          DFS(i);
      }
    }
    ```

6. DFS 함수
    - 재귀함수로 구현
    - 방문했던 적이 있으면 다시 방문하면 안되므로 return
    - 들어오면 방문 배열을 true 로 바꾸고 연결 노드 중 방문하지 않은 노드만 DFS 함수 호출

    ```java
    static void DFS(int v) {
    	if(visited[v])
    	    return;
    	visited[v] = true;
    	for(int i : A[v]) {
    	    // 연결 노드 중 방문하지 않았던 노드만 탐색하기
    	    if(visited[i] == false)
    	        DFS(i);
    	}
    }
    ```


** 그리드 DFS

```java
// N: 행(세로), M: 열(가로)

static int[] dr = {-1, 1, 0, 0};
static int[] dc = {0, 0, -1, 1};

static void dfs(int r, int c) {
    visited[r][c] = true;
    for (int d = 0; d < 4; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];
        if (0 <= nr && nr < N && 0 <= nc && nc < M) {
            if (!visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }
}
```

---

## BFS

### 01. “BFS” 란?

- 너비 우선 탐색
- 그래프를 완전 탐색하는 방법 중 하나로, 시작 노드에서 출발해 시작 노드를 기준으로 가까운 노드를 먼저 방문하면서 탐색하는 알고리즘
- FIFO 탐색(Queue 자료구조 이용)
- 가중치 없는 그래프(혹은 모든 간선 가중치 동일)에서 최단 경로를 보장함
    - 가중치가 있으면 다익스트라 등 사용
- 메모리/중복 방문 방지를 위해 큐에 넣기 전에 visited=true로 처리

### 02. 구현 방법

- Queue 사용해서 구현

    ```java
    static void BFS(int start) throws IOException {
    	// Queue<Integer> queue = new ArrayDeque<>();
      Queue<Integer> queue = new LinkedList<>();
      queue.add(start);
      visited[start] = true;
      while(!queue.isEmpty()) {
          int poll = queue.poll();
          bw.write(poll+" ");
          
          for(int i : A[poll]) {
              if(!visited[i]) {
                  visited[i] = true; // 큐에 넣기 전에 방문 처리
                  queue.add(i);
              }
          }
      }
    }
    ```