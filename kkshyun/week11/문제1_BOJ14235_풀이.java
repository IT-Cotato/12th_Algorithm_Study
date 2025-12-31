import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int count = Integer.parseInt(s[0]);
            if(count == 0) {
                if(pq.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(pq.poll()+"\n");
                continue;
            }
            for (int j = 1; j <= count; j++) {
                pq.add(Integer.parseInt(s[j]));
            }
        }
        bw.flush();
        bw.close();
    }
}