import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[][] dp = new int[N+1][K+1];
        int[][] items = new int[N+1][2];
        for (int i = 1; i < items.length; i++) {
            s = br.readLine().split(" ");
            items[i][0] = Integer.parseInt(s[0]);
            items[i][1] = Integer.parseInt(s[1]);
        }
        for (int i = 1; i < items.length; i++) {
            for (int j = 1; j <= K; j++) {
                if(j < items[i][0])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i][0]] + items[i][1]);
            }
        }
        bw.write(dp[N][K]+"\n");
        bw.flush();
        bw.close();
    }
}