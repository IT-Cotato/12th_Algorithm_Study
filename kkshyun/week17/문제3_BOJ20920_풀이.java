import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();


        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.length()>=M) {
                map.put(str,map.getOrDefault(str,0)+1);
            }
        }

        List<String> words = new ArrayList<>(map.keySet());

        words.sort((a, b) -> {
            int fa = map.get(a), fb = map.get(b);
            if (fa != fb) return fb - fa; // 빈도 내림차순
            if (a.length() != b.length()) return b.length() - a.length(); // 길이 내림차순
            return a.compareTo(b); // 사전 오름차순
        });

        for (String w : words)
            sb.append(w).append('\n');
        System.out.println(sb);
    }
}