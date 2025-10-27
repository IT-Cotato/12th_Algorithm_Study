import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        long[][] dist = new long[n+1][n+1];
        // 2차원 배열 Long.MAX_VALUE로 초기화
        for (long[] ints : dist) {
            Arrays.fill(ints, Long.MAX_VALUE);
        }

        for (int i = 0; i <= n; i++) {
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            dist[a][b] = Math.min(dist[a][b], c);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if(dist[j][i] == Long.MAX_VALUE || dist[i][k] == Long.MAX_VALUE)
                        continue;
                    if(dist[j][k] > dist[j][i] + dist[i][k])
                        dist[j][k] = dist[j][i] + dist[i][k];
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(dist[i][j] == Long.MAX_VALUE)
                    bw.write(0 +" ");
                else
                    bw.write(dist[i][j] +" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}