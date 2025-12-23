package kingmingyu.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문제1_BOJ15829_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long sum = 0;
        long pow = 1;
        double bundle = Math.pow(31, 5);
        for(int i = 0; i < n; i++){
            sum += (str.charAt(i) - 'a' + 1) * pow % 1234567891;
            pow = pow * 31 % 1234567891;
        }
        System.out.println(sum % 1234567891);
    }
}
