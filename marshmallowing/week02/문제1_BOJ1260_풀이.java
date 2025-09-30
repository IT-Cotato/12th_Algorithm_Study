import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 정점 개수
		int m = Integer.parseInt(st.nextToken()); // 간선 개수
		int v = Integer.parseInt(st.nextToken()); // 시작 정점

		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		// 인접 리스트 정렬
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}

		// DFS
		visited = new boolean[n + 1];
		dfs(v);
		bw.newLine();

		// BFS
		visited = new boolean[n + 1];
		bfs(v);

		bw.flush();
	}

	static void dfs(int node) throws IOException {
		visited[node] = true;
		bw.write(node + " ");
		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	static void bfs(int start) throws IOException {
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.add(start);

		while (!q.isEmpty()) {
			int node = q.poll();
			bw.write(node + " ");
			for (int next : graph[node]) {
				if (!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
	}
}
