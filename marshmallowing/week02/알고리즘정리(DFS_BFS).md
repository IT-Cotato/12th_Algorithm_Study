- 알고리즘 정리

  ## 깊이 우선 탐색 (DFS, Depth-First Search)

  > 최대한 깊이 내려간 뒤, 더이상 깊이 갈 곳이 없을 경우 옆으로 이동
  >
    - 루트 노드(혹은 다른 임의의 노드)에서 시작해서 다음 분기(branch)로 넘어가기 전에 해당 분기를 완벽하게 탐색하는 방식
    - 모든 노드를 방문하고자 하는 경우
    - 스택 자료구조 또는 재귀함수를 사용
        - 보편적으로는 재귀 함수 사용
      
    1. 탐색 시작 노드를 스택에 삽입하고 방문 처리를 한다.
    2. 스택의 최상단 노드에 방문하지 않은 인접한 노드가 하나라도 있다면 그 노드를 스택에 넣고 방문 처리한다. 방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다. 즉, 매번 최상단 원소를 기준으로 방문하지 않은 인접 노드가 있으면 그 노드로 방문을 수행하는 것이다.
    3. 더 이상 2번 과정을 할 수 없을 때까지 반복한다.

    ```java
    void search(Node root) {
      if (root == null) return;
      // 1. root 노드 방문
      visit(root);
      root.visited = true; // 1-1. 방문한 노드를 표시
      // 2. root 노드와 인접한 정점을 모두 방문
      for each (Node n in root.adjacent) {
        if (n.visited == false) { // 4. 방문하지 않은 정점을 찾는다.
          search(n); // 3. root 노드와 인접한 정점 정점을 시작 정점으로 DFS를 시작
        }
      }
    }
    ```

  ## 너비 우선 탐색(BFS, Breadth-First Search)

  > 최대한 넓게 이동한 다음, 더 이상 내려갈 수 없을 때 아래로 이동
  >
    - 루트 노드(혹은 다른 임의의 노드)에서 시작해서 인접한 노드를 먼저 탐색하는 방법
    - 시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하는 순회 방법
    - 두 노드의 최단 경로 혹은 임의의 경로를 구할 경우
    - 큐를 이용해서 구현
        - 선입선출(FIFO) 원칙으로 탐색

    1. 탐색 시작 노드를 큐에 삽입하고, 방문 처리를 한다.
    2. 큐에서 노드를 꺼낸 뒤에 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리한다. DFS를 수행할 때에는 인접하지 않은 노드에 대해 다시 한번 스택에 넣으면서 수행하였지만, BFS는 해당 시점에서 인접한 노드를 한 번에 전부 큐에 넣는다.
    3. 더 이상 2번의 과정을 수행할 수 없을 때까지 반복한다

    ```java
    void search(Node root) {
      Queue queue = new Queue();
      root.marked = true; // (방문한 노드 체크)
      queue.enqueue(root); // 1-1. 큐의 끝에 추가
    
      // 3. 큐가 소진될 때까지 계속한다.
      while (!queue.isEmpty()) {
        Node r = queue.dequeue(); // 큐의 앞에서 노드 추출
        visit(r); // 2-1. 큐에서 추출한 노드 방문
        // 2-2. 큐에서 꺼낸 노드와 인접한 노드들을 모두 차례로 방문한다.
        foreach (Node n in r.adjacent) {
          if (n.marked == false) {
            n.marked = true; // (방문한 노드 체크)
            queue.enqueue(n); // 2-3. 큐의 끝에 추가
          }
        }
      }
    }
    ```

  https://gmlwjd9405.github.io/2018/08/14/algorithm-dfs.html

  https://gmlwjd9405.github.io/2018/08/15/algorithm-bfs.html

  https://devuna.tistory.com/32