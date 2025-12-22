package kingmingyu.week10;

import java.io.*;
import java.util.*;

public class 문제2_BOJ1764_풀이 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> see = new HashSet<>();
        List<String> answer = new ArrayList<>();

        for(int i = 0; i < n; i++){
            see.add(br.readLine());
        }
        for(int i = 0; i < m; i++){
            String name = br.readLine();
            if(see.contains(name)){
                answer.add(name);
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(String name : answer){
            System.out.println(name);
        }
    }
}
