import java.io.*;
import java.util.*;

public class Main {

	static int N, C;
	static int[] house;

	public static boolean canInstall(int distance) {
		int count = 1;          // 첫 번째 집에는 무조건 설치
		int last = house[0];

		for (int i = 1; i < N; i++) {
			if (house[i] - last >= distance) {
				count++;
				last = house[i];
			}
		}
		return count >= C;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		house = new int[N];
		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(house);

		int left = 1;
		int right = house[N - 1] - house[0];
		int answer = 0;

		// 이분 탐색
		while (left <= right) {
			int mid = (left + right) / 2;

			if (canInstall(mid)) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		bw.write(String.valueOf(answer));
		bw.newLine();
		bw.flush();
		bw.close();
	}
}
