import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[] coins = new int[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = coins.length-1; i >=0 ; i--) {
            if(K == 0)
                break;
            while(K >= coins[i]) {
                count++;
                K -= coins[i];
            }
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}