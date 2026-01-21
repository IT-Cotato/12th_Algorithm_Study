package kingmingyu.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문제2_BOJ1992_풀이 {
    static int n;
    static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++){
            String mapInf = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = mapInf.charAt(j) - '0';
            }
        }

        dnc(0, n, 0, n);
        System.out.println(sb);
    }

    public static void dnc(int sx, int ex, int sy, int ey){
//        if(sx >= ex || sy >= ey){
//            sb.append(map[sx]).append(")");
//        }
        int start = map[sx][sy];
        for(int i = sx; i < ex; i++){
            for(int j = sy; j < ey; j++){
                if(start != map[i][j]){
                    int mx = (sx + ex) / 2;
                    int my = (sy + ey) / 2;
                    sb.append("(");
                    dnc(sx, mx, sy, my); // 왼쪽 위
                    dnc(sx, mx, my, ey); // 오른쪽 위
                    dnc(mx, ex, sy, my); // 왼쪽 아래
                    dnc(mx, ex, my, ey); // 오른쪽 아래
                    sb.append(")");
                    return;
                }
            }
        }
        sb.append(start);
        return;
    }
}
