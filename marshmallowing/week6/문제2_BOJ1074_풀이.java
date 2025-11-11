import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int count = 0; // 현재까지의 방문 순서 카운트

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		find(1 << N, r, c);

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}

	private static void find(int n, int r, int c) {
		if (n == 1) return;

		int half = n / 2;

		if (r < half && c < half) {              // 0번째 사분면
			find(half, r, c);
		} else if (r < half && c >= half) {      // 1번째 사분면
			count += half * half;
			find(half, r, c - half);
		} else if (r >= half && c < half) {      // 2번째 사분면
			count += 2 * half * half;
			find(half, r - half, c);
		} else {                                 // 3번째 사분면
			count += 3 * half * half;
			find(half, r - half, c - half);
		}
	}
}