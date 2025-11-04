import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 가장 먼저 끝나는 것들 중 시작 시간이 가장 빠른 것부터 선택
        // 그 중에 그 전 회의 끝나는 시간 <= 현재 선택할 회의 시작할 시간
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int startTime = Integer.parseInt(s[0]);
            int endTime = Integer.parseInt(s[1]);
            queue.add(new int[]{startTime, endTime});
        }
        int count = 0;
        int time = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int meetingStartTime = poll[0];
            int meetingEndTime = poll[1];
            if(time > meetingStartTime)
                continue;
            count++;
            time = meetingEndTime;
        }
        System.out.println(count);
    }
}