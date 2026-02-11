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
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 방향 상태 포함한 3차원 배열
		int[][][] sum = new int[n][m][3];

		// 0행 초기화
		for (int j = 0; j < m; j++) {
			for (int d = 0; d < 3; d++) {
				sum[0][j][d] = arr[0][j];
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {

				// 0 : 이전 위치-j+1 / 가능한 방향-1,2
				if (j + 1 < m)
					sum[i][j][0] = arr[i][j] + Math.min(
						sum[i - 1][j + 1][1],
						sum[i - 1][j + 1][2]
					);
				else
					sum[i][j][0] = Integer.MAX_VALUE;

				// 1 : 이전 위치-j / 가능한 방향-0,2
				sum[i][j][1] = arr[i][j] + Math.min(
					sum[i - 1][j][0],
					sum[i - 1][j][2]
				);

				// 2 : 이전 위치-j-1 / 가능한 방향-0,1
				if (j - 1 >= 0)
					sum[i][j][2] = arr[i][j] + Math.min(
						sum[i - 1][j - 1][0],
						sum[i - 1][j - 1][1]
					);
				else
					sum[i][j][2] = Integer.MAX_VALUE;
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			for (int d = 0; d < 3; d++) {
				min = Math.min(min, sum[n - 1][i][d]);
			}
		}

		bw.write(String.valueOf(min));
		bw.flush();
	}
}