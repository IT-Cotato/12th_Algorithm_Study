package kingmingyu.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제1_BOJ1205_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        if (n == 0) {
            System.out.println(1);
            return;
        }

        int newScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] scores = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 랭킹 리스트가 꽉 찼고, 가장 낮은 점수가 새 점수보다 크거나 같으면 진입 불가
        if (n == p && scores[n - 1] >= newScore) {
            System.out.println(-1);
        } else {
            // 2. 내 등수 계산 (나보다 큰 점수의 개수 + 1)
            int rank = 1;
            for (int i = 0; i < n; i++) {
                if (scores[i] > newScore) {
                    rank++;
                } else {
                    break;
                }
            }
            System.out.println(rank);
        }
    }
}
