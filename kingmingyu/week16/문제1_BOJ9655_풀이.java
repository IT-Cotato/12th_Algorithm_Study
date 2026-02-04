package kingmingyu.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문제1_BOJ9655_풀이 {
    public static void main(String[] args) throws IOException {
        // 문제 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 상근 -> 창영 순으로 돌을 1개 또는 3개를 가져가므로

        // 돌이 짝수개라면 무조건 창영이가
        if(n % 2 == 0) System.out.println("CY");
        // 돌이 홀수개라면 무조건 상경이가 이긴다.
        else System.out.println("SK");
    }
}
