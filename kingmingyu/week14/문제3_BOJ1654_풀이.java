package kingmingyu.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제3_BOJ1654_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lines = new int[k];
        long max = 0;
        for(int i = 0; i < k; i++){
            lines[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lines[i]);
        }

        long start = 0;
        long end = max + 1;
        while(start < end){
            long len = 0;
            long cut = (start + end) / 2;
            if(cut == 0){
                start = 1;
                break;
            }
            for(int i = 0; i < k; i++){
                len += lines[i] / cut;
            }
            if(len < n){ // 랜선의 개수가 적으면 더 짧게 짜름
                end = cut;
            }
            else{ // 랜선의 충분하면 더 길게 짜를 수 있는지 확인
                start = cut + 1;
            }
        }
        System.out.println(start - 1);
    }
}
