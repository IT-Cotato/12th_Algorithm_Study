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

		int n = Integer.parseInt(st.nextToken()); // 수열의 크기

		int[] arr = new int[n]; // 값
		int[] dp = new int[n]; // 길이

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			dp[i] = 1; // 자기 자신만 뽑아도 길이 1
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int max = 0;
		for (int i : dp) {
			if (i > max) {
				max = i;
			}
		}

		bw.write(String.valueOf(max));
		bw.flush();
	}
}