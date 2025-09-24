package cotato;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BJ_1966_0918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int Test = Integer.parseInt(br.readLine());

        // 최대 우선순위를 빠르게 알기 위한 최대 힙
        Queue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

        Queue<int[]> queue = new LinkedList<>();

        for (int t = 0; t < Test; t++) {
            // 테스트케이스마다 초기화 작업
            priorityQueue.clear();
            queue.clear();

            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);

            s = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(s[i]);
                queue.add(new int[]{i, p});
                priorityQueue.add(p);
            }

            int count = 0;
            while (!queue.isEmpty() && !priorityQueue.isEmpty()) {
                int frontPriority = queue.peek()[1];
                int maxPriority = priorityQueue.peek();

                // 더 큰 우선순위가 뒤에 있으면 맨 뒤로 이동
                if (maxPriority > frontPriority) {
                    queue.add(queue.poll());
                    continue;
                }

                // 그렇지 않으면 인쇄
                int index = queue.poll()[0];
                priorityQueue.poll();
                count++;

                if (index == M) break;
            }

            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
    }
}