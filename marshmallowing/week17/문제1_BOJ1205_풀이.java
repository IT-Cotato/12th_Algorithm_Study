import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();

		if (n > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
		}

		// 내 점수보다 큰 점수 개수 세기
		int rank = 1;
		for (int s : list) {
			if (s > score) {
				rank++;
			}
		}

		// 꽉 차있을 때 새 점수가 이전 점수보다 더 좋을 때만 점수 바뀜
		if (rank > p || (n == p && list.get(n - 1) >= score)) {
			System.out.println(-1);
			return;
		}

		System.out.println(rank);
	}
}