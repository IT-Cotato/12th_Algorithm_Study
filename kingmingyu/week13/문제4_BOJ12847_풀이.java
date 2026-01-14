package kingmingyu.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class 문제4_BOJ12847_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] pay = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            pay[i] = Integer.parseInt(st.nextToken());
        }

        long start = 0;
        for(int i = 0; i < m; i++){
            start+=pay[i];
        }

        long max = start;
        for(int i = m; i < n; i++){
            start = start + pay[i] - pay[i - m];
            max = Math.max(max, start);
        }
        System.out.println(max);
    }
}
