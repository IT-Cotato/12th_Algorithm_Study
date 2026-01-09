import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        long sum = 0;

        int[] pay = new int[n];
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            pay[i] = Integer.parseInt(s[i]);
        }

        for (int i = 0; i < m; i++) {
            sum += pay[i];
        }

        long max = sum;
        // 슬라이딩윈도우
        for (int i = m; i < n; i++) {
            sum += pay[i] - pay[i-m];
            max = Math.max(sum, max);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}