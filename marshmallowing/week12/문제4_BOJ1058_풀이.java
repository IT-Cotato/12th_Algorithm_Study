import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		char[][] g = new char[N][N];
		for (int i = 0; i < N; i++) {
			g[i] = br.readLine().toCharArray(); // 'Y' or 'N'
		}

		int ans = 0;

		// 각 사람 i에 대해 2-친구 수 계산
		for (int i = 0; i < N; i++) {
			boolean[] two = new boolean[N];

			// 직접 친구
			for (int j = 0; j < N; j++) {
				if (g[i][j] == 'Y') two[j] = true;
			}

			// 친구의 친구
			for (int k = 0; k < N; k++) {
				if (g[i][k] == 'Y') { // i의 친구 k
					for (int j = 0; j < N; j++) {
						if (g[k][j] == 'Y') two[j] = true;
					}
				}
			}

			two[i] = false; // 자기 자신 제외

			int cnt = 0;
			for (boolean b : two) if (b) cnt++;
			ans = Math.max(ans, cnt);
		}

		System.out.println(ans);
	}
}
