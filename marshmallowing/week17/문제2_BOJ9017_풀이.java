import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 6명 이상
		// 점수 작은 상위 4명 합
		// 동점일시 5위까지 고려
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int team = Integer.parseInt(st.nextToken());
				arr[j] = team;
			}

			// 팀별 인원 수 세기
			Map<Integer, Integer> countMap = new HashMap<>();
			for (int team : arr) {
				countMap.put(team, countMap.getOrDefault(team, 0) + 1);
			}

			// 6명 이상 팀만 등수 저장용 맵 생성
			Map<Integer, List<Integer>> scoreMap = new HashMap<>();
			for (int team : countMap.keySet()) {
				if (countMap.get(team) >= 6) {
					scoreMap.put(team, new ArrayList<>());
				}
			}

			// 유효한 팀만 대상으로 등수 매기기
			int rank = 1;
			for (int j = 0; j < n; j++) {
				int team = arr[j];
				if (scoreMap.containsKey(team)) {
					scoreMap.get(team).add(rank);
					rank++;
				}
			}

			// 우승 팀 결정
			int winner = 0;
			int minScore = Integer.MAX_VALUE;
			int fifthRank = Integer.MAX_VALUE;

			for (int team : scoreMap.keySet()) {
				List<Integer> list = scoreMap.get(team);

				int sum = list.get(0) + list.get(1) + list.get(2) + list.get(3);

				if (sum < minScore ||
					(sum == minScore && list.get(4) < fifthRank)) {
					minScore = sum;
					fifthRank = list.get(4);
					winner = team;
				}
			}
			System.out.println(winner);
		}
	}
}