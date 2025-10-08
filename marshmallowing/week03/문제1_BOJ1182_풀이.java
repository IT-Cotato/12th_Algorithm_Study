import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; // 정수 개수
	static int S; // 목표 합
	static int[] numbers; // 입력된 정수 배열
	static int count = 0; // 조건을 만족하는 부분수열의 개수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		backtrack(0, 0);

		if (S == 0) {
			System.out.println(count - 1);
		} else {
			System.out.println(count);
		}
	}

	// 백트래킹 함수
	private static void backtrack(int index, int currentSum) {
		// 종료 조건: 모든 원소의 포함 여부를 결정했을 때
		if (index == N) {
			if (currentSum == S) {
				count++;
			}
			return;
		}

		// 원소를 부분수열에 포함하는 경우
		backtrack(index + 1, currentSum + numbers[index]);

		// numbers[index] 원소를 부분수열에 포함하지 않는 경우
		backtrack(index + 1, currentSum);
	}
}