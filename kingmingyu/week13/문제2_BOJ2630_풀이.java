package kingmingyu.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제2_BOJ2630_풀이 {
    static int[][] paper;
    static int paper0, paper1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        paper = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dnc(0, n, 0, n);
        System.out.println(paper0);
        System.out.println(paper1);
    }
    public static void dnc(int sx, int ex, int sy, int ey){
        if(sx >= ex){
            if(paper[sx][sy] == 0) paper0++;
            else paper1++;
            return;
        }

        int init = paper[sx][sy];
        for(int i = sx; i < ex; i++){
            for(int j = sy; j < ey; j++){
                if(paper[i][j] != init){
                    int mx = (sx + ex) / 2;
                    int my = (sy + ey) / 2;
                    dnc(sx, mx, sy, my);
                    dnc(mx, ex, sy, my);
                    dnc(sx, mx, my, ey);
                    dnc(mx, ex, my, ey);
                    return;
                }
            }
        }
        if(init == 0) paper0++;
        else paper1++;
        return;
    }
}
