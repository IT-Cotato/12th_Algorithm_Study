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

		int n = Integer.parseInt(st.nextToken()); // 나무 수
		int m = Integer.parseInt(st.nextToken()); // 나무 길이

		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int low = 0;
		int high = max;
		int ans = 0;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			long sum = 0;

			for (int h : arr) {
				if (h > mid)
					sum += (h - mid);
			}

			if (sum >= m) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
}