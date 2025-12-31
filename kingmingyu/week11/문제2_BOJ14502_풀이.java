package kingmingyu.week11;

import java.io.*;
import java.util.*;

public class 문제2_BOJ14502_풀이 {
    public static int n, m;
    public static int[][] lab;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lab = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(answer);
    }
    public static void dfs(int wall){
        if(wall == 3){
            bfs();
            return;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(lab[i][j] == 0){
                    lab[i][j] = 1;
                    dfs(wall + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }
    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(lab[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] copyLab = new int[n][m];
        for(int i = 0; i < n; i++){
            copyLab[i] = lab[i].clone();
        }

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(copyLab[nx][ny] == 0){
                        queue.offer(new int[]{nx, ny});
                        copyLab[nx][ny] = 2;
                    }
                }
            }
        }

        checkSaveZone(copyLab);
    }

    public static void checkSaveZone(int[][] copyLab){
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(copyLab[i][j] == 0){
                    count++;
                }
            }
        }

        answer = Math.max(count, answer);
    }
}
