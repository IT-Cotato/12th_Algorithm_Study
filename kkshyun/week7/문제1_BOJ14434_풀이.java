import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer>[] growDays;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int K = Integer.parseInt(s[2]);
        int Q = Integer.parseInt(s[3]);

        // 놀이기구 키 제한
        int[] rides = new int[M + 1];
        s = br.readLine().split(" ");
        for (int i = 1; i <= M; i++) {
            rides[i] = Integer.parseInt(s[i - 1]);
        }

        // 아이가 자란 날짜 리스트
        // 아이 키는 리스트에서 해당 날짜보다 작거나 같은 원소 개수로 알 수 있음
        growDays = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            growDays[i] = new ArrayList<>();
        }
        s = br.readLine().split(" ");
        for (int day = 1; day <= K; day++) {
            int kid = Integer.parseInt(s[day - 1]);
            growDays[kid].add(day);
        }

        long[] diff = new long[K + 2];

        for (int qi = 0; qi < Q; qi++) {
            s = br.readLine().split(" ");
            int kid1 = Integer.parseInt(s[0]);
            int kid2 = Integer.parseInt(s[1]);
            int rideIdx = Integer.parseInt(s[2]);
            int limit = rides[rideIdx];

            List<Integer> l1 = growDays[kid1];
            List<Integer> l2 = growDays[kid2];

            int actDay = K + 1;

            int totalGrow = l1.size() + l2.size();
            if (totalGrow >= limit) {
                int low = 1;
                int high = K;
                int ans = K + 1;

                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    int cnt = upperBound(l1, mid) + upperBound(l2, mid);
                    if (cnt >= limit) {
                        ans = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                actDay = ans;
            }

            if (actDay <= K) {
                diff[actDay] += 1;
            }
        }

        // 차분 → 누적합으로 각 날마다 총 탑승 횟수 계산
        StringBuilder sb = new StringBuilder();
        long cur = 0;
        for (int day = 1; day <= K; day++) {
            cur += diff[day];
            sb.append(cur).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // list에서 value 이하인 원소 개수 = upper_bound 역할
    private static int upperBound(List<Integer> list, int value) {
        int low = 0;
        int high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) <= value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}