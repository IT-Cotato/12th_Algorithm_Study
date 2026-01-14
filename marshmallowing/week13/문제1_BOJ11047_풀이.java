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

		int n = Integer.parseInt(st.nextToken()); // 동전 종류
		int k = Integer.parseInt(st.nextToken()); // 총 합
		int count = 0;

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = n - 1; i >= 0; i--) {
			if (k >= arr[i]) {
				int c = k / arr[i];
				count += c;
				k -= c * arr[i];
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();

	}
}