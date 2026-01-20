package kingmingyu.week13;

import java.util.*;
import java.io.*;

public class 문제3_BOJ2805_풀이 {
    public static int[] trees;
    public static int n, m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trees = new int[n];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0 ; i < n; i ++){
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i], max);
        }

        long start = 0;
        long end = max;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int tree : trees) {
                if (tree > mid) {
                    sum += (tree - mid);
                }
            }

            if (sum >= m) { // 나무가 충분 -> 높이 증가
                result = mid;
                start = mid + 1;
            } else { // 나무가 부족 -> 높이 줄이기
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}
