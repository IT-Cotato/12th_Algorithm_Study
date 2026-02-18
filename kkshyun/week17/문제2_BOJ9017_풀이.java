import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            map.clear();
            queue.clear();
            ArrayList<Integer>[] teams = new ArrayList[N+1];
            for (int j = 0; j < teams.length; j++) {
                teams[j] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int e = Integer.parseInt(st.nextToken());
                queue.add(e);
                map.put(e, map.getOrDefault(e,0)+1);
            }
            int score = 0;
            while(!queue.isEmpty()) {
                int poll = queue.poll();
                if(map.get(poll) < 6)
                    continue;
                teams[poll].add(++score);
            }
            int min = Integer.MAX_VALUE;
            int fiveIndex = 0;
            int win = -1;
            for (int j = 1; j <= N; j++) {
                if (teams[j].size() < 6) continue;
                int sum = 0;
                for (int k = 0; k < 4; k++) {
                    sum += teams[j].get(k);
                }
                if(min == sum && fiveIndex > teams[j].get(4)) {
                    fiveIndex = teams[j].get(4);
                    win = j;
                } else if(min > sum) {
                    min = sum;
                    fiveIndex = teams[j].get(4);
                    win = j;
                }
            }
            sb.append(win).append("\n");
        }
        System.out.println(sb);
    }
}