import java.io.*;

public class BJ_1182_0930 {
    public static int S;
    public static int N;
    public static int count = 0;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);
        arr = new int[N];
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        dfs(0,0);
        if(S == 0) count--;
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
    public static void dfs(int depth, int sum) {
        if(depth == N) {
            if(sum == S)
                count++;
            return;
        }
        dfs(depth+1, sum + arr[depth]);
        dfs(depth+1, sum);
    }
}