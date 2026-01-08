import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static List<int[]> houses = new ArrayList<>();
	static List<int[]> chickens = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int v = Integer.parseInt(st.nextToken());
				if (v == 1) houses.add(new int[]{i, j});
				else if (v == 2) chickens.add(new int[]{i, j});
			}
		}

		// 조합: 치킨집 K개 중 M개 선택
		int K = chickens.size();
		int[] pick = new int[M];
		comb(0, 0, K, pick);

		System.out.println(answer);
	}

	static void comb(int idx, int start, int K, int[] pick) {
		if (idx == M) {
			answer = Math.min(answer, cityChickenDistance(pick));
			return;
		}
		for (int i = start; i < K; i++) {
			pick[idx] = i;
			comb(idx + 1, i + 1, K, pick);
		}
	}

	static int cityChickenDistance(int[] pick) {
		int sum = 0;
		for (int[] h : houses) {
			int best = Integer.MAX_VALUE;
			for (int ci : pick) {
				int[] c = chickens.get(ci);
				int d = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
				best = Math.min(best, d);
			}
			sum += best;
			if (sum >= answer) return sum;
		}
		return sum;
	}
}
