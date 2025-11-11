import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] paper;
	static int[] count = new int[3];

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0, 0, N);

		bw.write(count[0] + "\n");
		bw.write(count[1] + "\n");
		bw.write(String.valueOf(count[2]));
		bw.flush();
		bw.close();
	}

	// (x, y)를 시작으로 하는 size×size 영역 검사
	private static void divide(int x, int y, int size) {
		if (isSame(x, y, size)) {
			int value = paper[x][y];
			count[value + 1]++;
			return;
		}

		int newSize = size / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				divide(x + i * newSize, y + j * newSize, newSize);
			}
		}
	}

	// 현재 영역이 전부 같은 숫자인지 확인
	private static boolean isSame(int x, int y, int size) {
		int first = paper[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (paper[i][j] != first) {
					return false;
				}
			}
		}
		return true;
	}
}
