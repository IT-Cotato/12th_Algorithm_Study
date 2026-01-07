import java.io.*;

public class Main {
    static int N;
    static Character[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        graph = new Character[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                graph[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(graph[i][j] == 'N' && i!=j) {
                    possible(i,j);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if(graph[i][j] != 'N')
                    count++;
            }
            max = Math.max(max, count);
        }
        bw.write(max+"\n");
        bw.flush();
        bw.close();
    }


    public static void possible(int i, int j) {
        for (int k = 0; k < N; k++) {
            if(graph[i][k] == 'Y' && graph[k][j] == 'Y') {
                graph[i][j] = '2';
                graph[j][i] = '2';
                return;
            }
        }
    }
}