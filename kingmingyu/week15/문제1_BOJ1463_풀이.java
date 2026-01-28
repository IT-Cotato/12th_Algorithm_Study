package kingmingyu.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문제1_BOJ1463_풀이 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[1] = 0; // 1은 이미 1이므로 연산 0번

        for (int i = 2; i <= n; i++) {
            // 먼저 1을 빼는 경우로 초기화
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어지면, 1을 뺀 값과 비교해 더 작은 것 선택
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3으로 나누어 떨어지면, 현재 값과 비교해 더 작은 것 선택
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
