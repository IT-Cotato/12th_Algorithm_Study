import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int vertex, weight;
		Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static List<Node>[] graph;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();
		dist = new int[V + 1];
		Arrays.fill(dist, INF);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, w));
		}

		dijkstra(start);

		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (now.weight > dist[now.vertex]) continue;

			for (Node next : graph[now.vertex]) {
				if (dist[next.vertex] > dist[now.vertex] + next.weight) {
					dist[next.vertex] = dist[now.vertex] + next.weight;
					pq.offer(new Node(next.vertex, dist[next.vertex]));
				}
			}
		}
	}
}
