import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 삼각형 크기
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					if (i > 0) {
						dp[i][j] = Integer.parseInt(st.nextToken()) + dp[i - 1][0];
					} else {
						dp[i][j] = Integer.parseInt(st.nextToken());
					}

				} else if (j == i) {
					dp[i][j] = Integer.parseInt(st.nextToken()) + dp[i - 1][j - 1];
				} else {
					int max = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
					dp[i][j] = Integer.parseInt(st.nextToken()) + max;
				}
			}
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			if (dp[n - 1][i] > result)
				result = dp[n - 1][i];
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}