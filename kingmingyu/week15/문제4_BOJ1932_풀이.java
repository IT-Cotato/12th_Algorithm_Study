package kingmingyu.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제4_BOJ1932_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] tri = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                if(st.hasMoreTokens()){
                    tri[i][j] = Integer.parseInt(st.nextToken());
                }
                else{
                    tri[i][j] = 0;
                }
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = tri[0][0];
        // 두 번째 줄(i=1)부터 탐색
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    // 맨 왼쪽 칸: 바로 위(오른쪽 대각선 위)에서만 내려옴
                    dp[i][j] = dp[i - 1][j] + tri[i][j];
                } else if (j == i) {
                    // 맨 오른쪽 칸: 왼쪽 위에서만 내려옴
                    dp[i][j] = dp[i - 1][j - 1] + tri[i][j];
                } else {
                    // 가운데 칸: 위쪽 두 칸 중 큰 값을 선택
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + tri[i][j];
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(dp[n-1][i], max);
        }

        System.out.println(max);

    }
}
