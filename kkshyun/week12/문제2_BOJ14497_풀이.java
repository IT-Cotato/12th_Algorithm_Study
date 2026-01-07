import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N, M, x2, y2;
    static boolean[][] visited;
    static String[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        int x1 =  Integer.parseInt(s[0]) -1;
        int y1 = Integer.parseInt(s[1]) -1;
        x2 =  Integer.parseInt(s[2]) -1;
        y2 = Integer.parseInt(s[3]) -1;

        graph = new String[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                graph[i][j] = s[j];
            }
        }
        int result = bfs(x1, y1);
        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2],o2[2]));
        visited[x][y] = true;
        graph[x][y] = "0";
        queue.add(new int[]{x, y, 1});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == x2 && cur[1] == y2)
                return cur[2];
            for (int i = 0; i < dx.length; i++) {
                int moveX = cur[0] + dx[i];
                int moveY = cur[1] + dy[i];
                if(moveX >= 0 && moveY >= 0 && moveX < N && moveY < M && !visited[moveX][moveY]) {
                    if(graph[moveX][moveY].equals("1")) // 1 한번 만나면 끝
                        queue.add(new int[]{moveX, moveY, cur[2]+1});
                    else // 아니면 1 만날때까지 퍼짐
                        queue.add(new int[]{moveX, moveY, cur[2]});
                    visited[moveX][moveY] = true;
                    graph[moveX][moveY] = "0";
                }
            }
        }
        return -1;
    }
}