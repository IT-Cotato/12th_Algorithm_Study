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
        int[][] dp = new int[N+1][3];
        int[][] arr = new int[N+1][3];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N+1; i++) {
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + arr[i][2];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[N][i]);
        }
        System.out.println(min);
    }
}