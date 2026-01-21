import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] matrix;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				matrix[i][j] = line.charAt(j) - '0';
			}
		}

		solve(0, 0, n);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void solve(int x, int y, int size) {
		if (isSameNumber(x, y, size)) {
			sb.append(matrix[x][y]);
			return;
		}

		sb.append('(');
		solve(x, y, size / 2);
		solve(x, y + size / 2, size / 2);
		solve(x + size / 2, y, size / 2);
		solve(x + size / 2, y + size / 2, size / 2);
		sb.append(')');
	}

	private static boolean isSameNumber(int x, int y, int size) {
		int number = matrix[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (matrix[i][j] != number) {
					return false;
				}
			}
		}
		return true;
	}

}