import java.io.*;

public class Main {
    static int M;
    static int N;
    static BufferedWriter bw;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[M+1];
        for (int i = 1; i <= N; i++) {
            dfs(i,1);
        }
        bw.flush();
        bw.close();
    }

    static public void dfs(int node, int depth) throws IOException{
        arr[depth] = node;
        if(depth == M) {
            for (int i = 1; i <= M; i++) {
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            dfs(i, depth+1);
        }
    }
}