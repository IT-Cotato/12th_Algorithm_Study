import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int n, m, k, q;
	static int[] rateM;
	static int[] grow;

	public static int lowerBound(int[] arr, int target) {
		int l = 1, r = arr.length - 1;
		int ans = arr.length;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] >= target) {
				ans = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		rateM = new int[m + 1];
		grow = new int[k + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			rateM[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= k; i++) {
			grow[i] = Integer.parseInt(st.nextToken());
		}

		for (int a = 0; a < q; a++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());

			int cnt = 0;

			for (int i = 1; i <= m; i++) {
				int need = rateM[i] - H;
				if (need <= 0) {
					cnt++; // 키가 이미 충분
					continue;
				}

				int first = lowerBound(grow, need);
				if (first >= L && first <= R)
					cnt++;
			}

			bw.write(cnt + "\n");
		}

		bw.flush();
	}
}
