import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, answer = 0;
	static char[][] board;
	static boolean[] visited = new boolean[26]; // 알파벳 방문 체크

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];

		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}

		visited[board[0][0] - 'A'] = true; // 시작점 방문
		dfs(0, 0, 1);

		System.out.println(answer);
	}

	static void dfs(int x, int y, int depth) {
		answer = Math.max(answer, depth);

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
				int idx = board[nx][ny] - 'A';
				if (!visited[idx]) {
					visited[idx] = true;
					dfs(nx, ny, depth + 1);
					visited[idx] = false;
				}
			}
		}
	}
}
