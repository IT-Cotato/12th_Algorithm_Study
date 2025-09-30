import java.io.*;
import java.util.*;

public class Main {
    static TreeSet<Integer>[] graph;
    static boolean[] visited;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int N =  Integer.parseInt(s[0]);
        int M =  Integer.parseInt(s[1]);
        int V =  Integer.parseInt(s[2]);

        graph = new TreeSet[N+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new TreeSet<Integer>();
        }
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(V);
        bw.write("\n");
        Arrays.fill(visited, false);
        bfs(V);
        bw.flush();
        bw.close();


    }
    public static void dfs(int start) throws IOException {
        if(visited[start])
            return;
        visited[start] = true;
        bw.write(start+" ");
        for(int next : graph[start]) {
            if(!visited[next])
                dfs(next);
        }
    }

    public static void bfs(int start) throws IOException {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            bw.write(poll+" ");
            for(int next : graph[poll]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}