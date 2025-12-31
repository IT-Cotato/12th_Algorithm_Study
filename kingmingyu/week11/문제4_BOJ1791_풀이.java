package kingmingyu.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 문제4_BOJ1791_풀이 {
    static class Visitor implements Comparable<Visitor> {
        int id, arrivalTime, step;
        int[] schedule;

        public Visitor(int id, int arrivalTime, int[] schedule) {
            this.id = id;
            this.arrivalTime = arrivalTime;
            this.schedule = schedule;
            this.step = 0;
        }

        @Override
        public int compareTo(Visitor o) {
            // 1. 시간순 정렬
            if (this.arrivalTime != o.arrivalTime)
                return Integer.compare(this.arrivalTime, o.arrivalTime);
            // 2. 시간 같으면 번호순 정렬
            return Integer.compare(this.id, o.id);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수
        int c = Integer.parseInt(br.readLine());

        for(int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 방문자 수
            int n = Integer.parseInt(st.nextToken());
            // 진료실 수
            int m = Integer.parseInt(st.nextToken());
            PriorityQueue<Visitor> pq = new PriorityQueue<>();
            // 각 진료실의 의사가 진료를 마치는 시간
            int[] doctor = new int[m + 1];

            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                // 도착 시간
                int t = Integer.parseInt(st.nextToken());
                // 방문할 진료실의 개수
                int k = Integer.parseInt(st.nextToken());

                int[] schedule = new int[k];
                for(int i2 = 0; i2 < k; i2++){
                    schedule[i2] = Integer.parseInt(st.nextToken());
                }
                pq.add(new Visitor(j, t, schedule));
            }

            int lastT = 0;

            while(!pq.isEmpty()){
                Visitor v = pq.poll();
                int cur = v.schedule[v.step];

                int startT = Math.max(v.arrivalTime, doctor[cur]);
                int finishT = startT + 1;

                doctor[cur] = finishT;

                if(v.step + 1 < v.schedule.length){
                    v.step++;
                    v.arrivalTime = finishT;
                    pq.add(v);
                }
                else {
                    lastT = Math.max(lastT, finishT);
                }
            }
            System.out.println(lastT);
        }
    }
}
