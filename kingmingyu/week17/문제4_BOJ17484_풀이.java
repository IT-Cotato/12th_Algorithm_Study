package kingmingyu.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 문제4_BOJ17484_풀이 {
    static int n, m;
    static int[][] space;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        space = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int [n][m][3];

        // 1. DP 테이블 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], 1000000);
            }
        }

        // 초기값 저장
        for(int i = 0; i < m; i++){
            dp[0][i][0] = space[0][i];
            dp[0][i][1] = space[0][i];
            dp[0][i][2] = space[0][i];
        }

        // 최소값 계산
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                // 왼쪽 위에서 온 경우
                if(j > 0) dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + space[i][j];
                // 중앙에서 오는 경우
                dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + space[i][j];
                // 오른쪽 위에서 오는 경우
                if(j < m - 1) dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + space[i][j];
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < 3; j++){
                result = Math.min(result, dp[n-1][i][j]);
            }
        }

        System.out.println(result);
    }
}
