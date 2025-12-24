import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static int max = 0;
    static int[] drow = {-1,1,0,0};
    static int[] dcol = {0,0,-1,1};
    static int[][] graph;
    static int N;
    static int M;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        graph = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }

        // 1을 백트래킹으로 3개 세우고, bfs로 넓이 찾기
        dfs(0,0);
        bw.write(max+"\n");
        bw.flush();
        bw.close();

    }
    public static void dfs(int depth, int start) {
        if(depth == 3) {
            cal();
            return;
        }
        for (int i = start; i < N * M; i++) {
            int r = i / M; // 행 계산
            int c = i % M; // 열 계산

            if (graph[r][c] == 0) {
                graph[r][c] = 1;       // 선택
                dfs(depth + 1, i + 1); // 다음 depth에서는 현재 인덱스 + 1부터 탐색
                graph[r][c] = 0;       // 백트래킹 (원상복구)
            }
        }
    }

    public static void cal() {
        int temp = 0;
        int[][] clone = new int[graph.length][];
        for (int i = 0; i < graph.length; i++) {
            clone[i] = graph[i].clone();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(graph[i][j] == 2) {
                    bfs(i,j,clone);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(clone[i][j] == 0) {
                    temp += 1;
                }
            }
        }
        max = Math.max(temp, max);
    }

    public static void bfs(int row, int col, int[][] clone) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i],false);
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = curr[0] + drow[i];
                int y = curr[1] + dcol[i];
                if(x >= 0 && y >= 0 && x < graph.length && y < graph[0].length && clone[x][y]!=1) {
                    clone[x][y] = 2;
                    if(visited[x][y])
                        continue;
                    visited[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
        }
    }
}