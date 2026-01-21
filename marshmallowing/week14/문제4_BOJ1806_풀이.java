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
		int s = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		int sum = 0;
		int minLen = Integer.MAX_VALUE;
		int start = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			while (sum >= s) {
				if (i - start + 1 < minLen) {
					minLen = i - start + 1;
				}
				sum -= arr[start];
				start++;
			}
		}

		if (minLen == Integer.MAX_VALUE) {
			bw.write('0');
		} else {
			bw.write(String.valueOf(minLen));
		}
		bw.flush();
		bw.close();
	}
}