import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        final int INF = 1000000000;
        int[][] arr = new int[N+1][M+1];
        int[][][] dp = new int[N+1][M+1][3];
        for (int i = 1; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        for (int j = 1; j <= M; j++) {
            dp[1][j][0] = dp[1][j][1] = dp[1][j][2] = arr[1][j];
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (j - 1 >= 1) {
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + arr[i][j];
                }
                dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
                if (j + 1 <= M) {
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + arr[i][j];
                }
            }
        }
        int min = INF;
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(min, dp[N][i][j]);
            }
        }
        System.out.println(min);
    }
}