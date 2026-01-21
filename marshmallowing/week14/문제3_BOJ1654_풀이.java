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

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken()); //필요한 랜선 수
		int[] arr = new int[k];

		int max = 0;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		long first = 1;
		long last = max;
		int cnt = 0;
		long result = 0;

		while (first <= last) {
			long mid = (first + last) / 2; // 오버플로우 주의
			for (int i : arr) {
				cnt += (i / mid);
			}
			if (cnt >= n) {
				result = mid;
				first = mid + 1;
			} else {
				last = mid - 1;
			}
			cnt = 0;
		}

		bw.write(String.valueOf(result));

		bw.flush();
		bw.close();
	}
}