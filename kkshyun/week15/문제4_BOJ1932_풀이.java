import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n+1][n+1];
        dp[1][1] = arr[1][1];
        int result = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < i+1; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
            }
        }
        for (int i = 1; i < n+1; i++) {
            result = Math.max(result, dp[n][i]);
        }
        System.out.println(result);
    }
}