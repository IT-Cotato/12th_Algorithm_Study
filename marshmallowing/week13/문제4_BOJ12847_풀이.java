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

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n]; // 일급

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long sum = 0;
		long max = 0;

		// 초기 윈도우(0~m-1)
		for (int i = 0; i < m; i++) {
			sum += arr[i];
			max = sum;
		}

		// 윈도우 이동
		for (int i = m; i < n; i++) {
			sum += arr[i];
			sum -= arr[i - m];
			if (sum > max) {
				max = sum;
			}
		}

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}

}