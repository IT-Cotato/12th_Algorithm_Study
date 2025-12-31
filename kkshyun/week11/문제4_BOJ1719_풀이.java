import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static class Node {
        int end;
        int value;

        public Node(int end, int value) {
            this.end = end;
            this.value = value;
        }
    }
    static PriorityQueue<int[]> pq;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1[1], o2[1]));
        graph = new ArrayList[n + 1];
        dist = new int[n+1];
        result = new int[n+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int value = Integer.parseInt(s[2]);
            graph[a].add(new Node(b, value));
            graph[b].add(new Node(a, value));
        }

        for (int start = 1; start <= n; start++) {
            pq.clear();
            Arrays.fill(dist, Integer.MAX_VALUE);
            Arrays.fill(result, -1);
            dijkstra(start);
            for (int j = 1; j < n+1; j++) {
                int destination = result[j];
                if(j == start) {
                    bw.write("- ");
                    continue;
                }
                while(destination != result[destination]) {
                    destination = result[destination];
                }
                bw.write(destination+" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();

    }
    public static void dijkstra(int start) {
        pq.add(new int[]{start, 0, -1});
        while(!pq.isEmpty()) {
            int[] poll = pq.poll();
            if(dist[poll[0]] != Integer.MAX_VALUE )
                continue;
            dist[poll[0]] = poll[1];
            result[poll[0]] = poll[2];
            for(Node next : graph[poll[0]]) {
                if(dist[next.end] == Integer.MAX_VALUE && dist[next.end] > poll[1] + next.value) {
                    if(poll[0] == start)
                        pq.add(new int[]{next.end, poll[1] + next.value, next.end}); // 인덱스 2 : 현재 위치
                    else
                        pq.add(new int[]{next.end, poll[1] + next.value, poll[0]}); // 인덱스 2 : 이전 위치
                }
            }
        }

    }
}