package kingmingyu.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문제4_BOJ20125_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] cookie = new char[n][n];

        for(int i = 0; i < n; i++){
            String lines = br.readLine();
            for(int j = 0; j < n; j++){
                cookie[i][j] = lines.charAt(j);
            }
        }

        // 심장 찾기, 머리, 팔, 다리 길이가 1이상이므로 1부터 시작
        int hx = 0;
        int hy = 0;
        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < n - 1; j++){
                if(cookie[i+1][j] == '*' && cookie[i][j+1] == '*'
                        && cookie[i-1][j] == '*' && cookie[i][j-1] == '*'){
                    hx = j;
                    hy = i;
                    break;
                }
            }
        }

        // 왼쪽 팔 길이
        int la = 0;
        while(hx - la > 0 && cookie[hy][hx - la - 1] == '*'){
            la++;
        }
        // 오른쪽 팔 길이
        int ra = 0;
        while(hx + ra + 1 < n && cookie[hy][hx + ra + 1] == '*'){
            ra++;
        }
        // 허리 길이
        int w = 0;
        while(hy + w + 1 < n && cookie[hy + w + 1][hx] == '*'){
            w++;
        }
        // 왼쪽 다리 길이
        int ll = 0;
        while(hy + w + 1 + ll < n && cookie[hy + w + 1 + ll][hx - 1] == '*'){
            ll++;
        }
        // 오른쪽 다리 길이
        int rl = 0;
        while(hy + w + 1 + rl < n && cookie[hy + w + 1 + rl][hx + 1] == '*'){
            rl++;
        }

        System.out.println((hy + 1) + " " + (hx + 1));
        System.out.println(la + " " + ra + " " + w + " " + ll + " " + rl);
    }
}
