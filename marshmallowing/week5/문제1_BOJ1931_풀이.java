import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[][] meetings = new int[n][2];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작
			meetings[i][1] = Integer.parseInt(st.nextToken()); // 끝
		}

		// 끝나는 시간 → 시작 시간 순으로 정렬
		Arrays.sort(meetings, (a, b) -> {
			if (a[1] == b[1])
				return a[0] - b[0]; // 끝나는 시간이 같으면 시작 시간 기준
			return a[1] - b[1];
		});

		int count = 0;
		int endTime = 0;

		for (int i = 0; i < n; i++) {
			if (meetings[i][0] >= endTime) { // 겹치지 않으면 선택
				count++;
				endTime = meetings[i][1];
			}
		}

		bw.write(String.valueOf(count));
		bw.newLine();
		bw.flush();
		bw.close();

	}
}
