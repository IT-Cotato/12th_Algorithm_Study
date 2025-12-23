import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        HashMap map = new HashMap<String,Integer>();
        String str;
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            map.put(str,0);
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            str = br.readLine();
            if(map.containsKey(str)) {
                count++;
                map.replace(str,0, 1);
            }
        }
        bw.write(count+"\n");
        List<String> list = new LinkedList<>();
        for (Object key : map.keySet()) {
            if(map.get(key).equals(1)) {
                list.add((String) key);
            }
        }
        Collections.sort(list);
        for (String name : list) {
            bw.write(name+"\n");
        }
        bw.flush();
        bw.close();
    }
}