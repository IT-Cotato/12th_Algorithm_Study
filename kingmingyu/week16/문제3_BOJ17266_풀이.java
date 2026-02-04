package kingmingyu.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제3_BOJ17266_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 굴다리 길이
        int n = Integer.parseInt(br.readLine());

        // 가로등 개수
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] lights = new int[m];
        // 최소 가로등 길이
        int max = 0;
        for(int i = 0; i < m; i++){
            lights[i] = Integer.parseInt(st.nextToken());
            // 처음에는 시작점과 가로등의 길이만 비교
            if(i == 0){
                max = Math.max(max, lights[i]);
            }
            // 그 이후부터는 가로등이 양쪽에 존재하므로 /2, 홀수인 경우를 고려하여 +1
            else {
                max = Math.max(max, (lights[i] - lights[i-1] + 1) / 2);
            }
        }
        // 마지막에도 가로등이 없으므로 도착지점과 가로등의 길이만 비교
        max = Math.max(max, n - lights[m - 1]);
        System.out.println(max);
    }
}
