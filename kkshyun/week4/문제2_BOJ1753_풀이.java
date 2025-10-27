import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static class Node {
        int index, cost;
        public Node(int end, int cost) {
            this.index = end;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int V = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);
        int K = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[V+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int weight = Integer.parseInt(s[2]);
            graph[start].add(new Node(end, weight));
        }

        int[] dist = new int[V+1];
        boolean[] visited = new boolean[V+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(K, 0));
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(visited[now.index]) continue;
            visited[now.index] = true;

            for(Node next : graph[now.index]) {
                if(dist[next.index] > dist[now.index] + next.cost) {
                    dist[next.index] = dist[now.index] + next.cost;
                    pq.add(new Node(next.index, dist[next.index]));
                }
            }
        }

        for (int i = 1; i < V+1; i++) {
            if(dist[i] == Integer.MAX_VALUE)
                bw.write("INF\n");
            else
                bw.write(dist[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
}