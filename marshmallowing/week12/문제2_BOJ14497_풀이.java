import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] a;
	static int[][] dist;
	static int sx, sy, ex, ey;

	static final int INF = 1_000_000_000;
	static final int[] dx = {1, -1, 0, 0};
	static final int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;
		ex = Integer.parseInt(st.nextToken()) - 1;
		ey = Integer.parseInt(st.nextToken()) - 1;

		a = new char[N][M];
		for (int i = 0; i < N; i++) {
			a[i] = br.readLine().toCharArray();
		}

		dist = new int[N][M];
		for (int i = 0; i < N; i++) Arrays.fill(dist[i], INF);

		System.out.println(zeroOneBfs());
	}

	static int zeroOneBfs() {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.addFirst(new int[]{sx, sy});
		dist[sx][sy] = 0;

		while (!dq.isEmpty()) {
			int[] cur = dq.pollFirst();
			int x = cur[0], y = cur[1];

			if (x == ex && y == ey) return dist[x][y];

			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

				int w = cost(a[nx][ny]);
				int nd = dist[x][y] + w;
				if (nd < dist[nx][ny]) {
					dist[nx][ny] = nd;
					if (w == 0) dq.addFirst(new int[]{nx, ny});
					else dq.addLast(new int[]{nx, ny});
				}
			}
		}
		return dist[ex][ey];
	}

	static int cost(char c) {
		if (c == '1') return 1;
		return 0;
	}
}
