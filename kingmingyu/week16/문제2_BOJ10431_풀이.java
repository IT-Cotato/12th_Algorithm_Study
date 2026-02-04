package kingmingyu.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제2_BOJ10431_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int[] students = new int[20];
            StringTokenizer st = new StringTokenizer(br.readLine());
            // test case 수 입력받기
            int tc = Integer.parseInt(st.nextToken());
            // 걸음 수
            int count = 0;
            for(int j = 0; j < 20; j++){
                students[j] = Integer.parseInt(st.nextToken());
                // 만약 뽑은 학생보다 앞에 선 학생이 더 큰 경우가 있다면 걸음수 +1
                for(int k = 0; k < j; k++) {
                    if(students[k] > students[j]){
                        count++;
                    }
                }
            }

            // 출력 형식에 맞춰 출력하기
            System.out.println(tc + " " + count);
        }
    }
}
