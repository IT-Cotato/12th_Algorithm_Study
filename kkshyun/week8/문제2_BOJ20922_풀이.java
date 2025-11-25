import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[] sequence = new int[N];
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(s[i]);
        }
        int max = 0;
        int temp = 0;
        int start = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < sequence.length; i++) {
            if(map.containsKey(sequence[i])&& map.get(sequence[i]) == K) {
                while(start < i) {
                    if(sequence[start] == sequence[i]) {
                        start++;
                        temp--;
                        break;
                    }else {
                        map.put(sequence[start], map.get(sequence[start]) - 1);
                        start++;
                        temp--;
                    }
                }
            } else {
                map.put(sequence[i], map.getOrDefault(sequence[i], 0) + 1);
            }
            temp++;
            max = Math.max(max, temp);
        }
        bw.write(max+"\n");
        bw.flush();
        bw.close();
    }
}