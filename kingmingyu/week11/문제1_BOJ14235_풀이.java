package kingmingyu.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 문제1_BOJ14235_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> gifts = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if(k == 0){
                if(gifts.isEmpty()) System.out.println("-1");
                else System.out.println(gifts.poll());
            }
            else{
                for(int j = 0; j < k; j++){
                    gifts.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
    }
}
