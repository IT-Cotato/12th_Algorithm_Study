package kingmingyu.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제4_BOJ1806_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        long sum = 0;
        int minLen = 999999;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];

            while(sum >= s){
                minLen = Math.min(minLen, right - left + 1);

                sum -= nums[left];
                left++;
            }
        }
        if(minLen == 999999) System.out.println(0);
        else System.out.println(minLen);
    }
}
