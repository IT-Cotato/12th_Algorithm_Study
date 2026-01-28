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

		int n = Integer.parseInt(st.nextToken()); //집의 수
		int[][] cost = new int[n][3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dp = new int[3];

		dp[0] = cost[0][0];
		dp[1] = cost[0][1];
		dp[2] = cost[0][2];

		for (int i = 1; i < n; i++) {
			int prevR = dp[0];
			int prevG = dp[1];
			int prevB = dp[2];

			dp[0] = cost[i][0] + Math.min(prevG, prevB);
			dp[1] = cost[i][1] + Math.min(prevR, prevB);
			dp[2] = cost[i][2] + Math.min(prevR, prevG);
		}

		int ans = Integer.MAX_VALUE;
		for (int i : dp) {
			ans = Math.min(ans, i);
		}

		bw.write(String.valueOf(ans));
		bw.flush();
	}
}