import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	// 하양:0, 파랑:1
	static int white = 0;
	static int blue = 0;
	static int[][] matrix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0, 0, n);

		bw.write(white + "\n" + blue);
		bw.flush();
		bw.close();
	}

	static void solve(int x, int y, int size) {
		// 영역이 모두 한 색일 때
		if (isSameColor(x, y, size)) {
			if (matrix[x][y] == 0)
				white++;
			else
				blue++;
			return;
		}

		// 사분할
		solve(x, y, size / 2);
		solve(x, y + size / 2, size / 2);
		solve(x + size / 2, y + size / 2, size / 2);
		solve(x + size / 2, y, size / 2);

	}

	static boolean isSameColor(int x, int y, int size) {
		int color = matrix[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (matrix[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
}