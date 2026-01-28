import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N+1]; // 해당 인덱스를 포함하는 가장 긴 부분 수열
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                // 무조건 포함해야 업데이트
                if(arr[j] < arr[i])
                    dp[i] = Math.max(dp[j]+1, dp[i]);
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}