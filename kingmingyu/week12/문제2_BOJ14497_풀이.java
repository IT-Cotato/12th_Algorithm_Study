package kingmingyu.week12;

import java.io.*;
import java.util.*;

public class 문제2_BOJ14497_풀이 {
    public static int n, m;
    // junan's location
    public static int juX, juY;
    // chocolate's location
    public static int chX, chY;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static Character[][] classroom;
    public static int[][] visited;

    public static int answer;
    public static Queue<int[]> jump = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        classroom = new Character[n][m];
        visited = new int[n][m];

        st = new StringTokenizer(br.readLine());

        juX = Integer.parseInt(st.nextToken()) - 1;
        juY = Integer.parseInt(st.nextToken()) - 1;
        chX = Integer.parseInt(st.nextToken()) - 1;
        chY = Integer.parseInt(st.nextToken()) - 1;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for(int j = 0; j < m; j++){
                classroom[i][j] = temp.charAt(j);
            }
        }

        bfs(juX, juY);
    }
    public static void bfs(int x, int y){
        jump.add(new int[] {x, y});
        visited[x][y] = 1;

        while(true){
            Queue<int[]> next = new LinkedList<>();
            while(!jump.isEmpty()){
                int[] now = jump.poll();

                if(now[0] == chX && now[1] == chY){
                    System.out.println(answer);
                    return;
                }

                for(int i = 0; i < 4; i++){
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (visited[nx][ny] == 1) continue;

                    visited[nx][ny] = 1;

                    if(classroom[nx][ny] == '0') jump.add(new int[] {nx, ny});
                    else{
                        next.add(new int[] {nx, ny});
                    }
                }
            }
            answer += 1;
            jump = next;
        }

    }
}
