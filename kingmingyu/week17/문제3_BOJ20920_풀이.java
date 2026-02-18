package kingmingyu.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문제3_BOJ20920_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> vocas = new HashMap<>();
        for(int i = 0; i < n; i++){
            String voca = br.readLine();
            if(voca.length() < m){
                continue;
            }
            vocas.put(voca, vocas.getOrDefault(voca, 0) + 1);
        }

        List<String> list = new ArrayList<>(vocas.keySet());

        list.sort((a, b) -> {
            // 1. 빈도 비교
            if(!vocas.get(a).equals(vocas.get(b))){
                return vocas.get(b) - vocas.get(a);
            }
            // 2. 길이 비교
            if(a.length() != b.length()){
                return b.length() - a.length();
            }
            // 3. 사전순 비교
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for(String voca : list){
            sb.append(voca).append('\n');
        }
        System.out.println(sb);
    }
}
