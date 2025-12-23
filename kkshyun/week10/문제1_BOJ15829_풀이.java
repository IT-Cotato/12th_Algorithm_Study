import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int L = Integer.parseInt(br.readLine());
        String charArray = br.readLine();
        long sum = 0L;
        long MOD = 1234567891L;
        long r = 1L;
        for (int i = 0; i < L; i++) {
            int val = charArray.charAt(i) - 'a' + 1;
            sum = (sum + val * r) % MOD;
            r = (r * 31) % MOD;
        }
        bw.write(sum+"\n");
        bw.flush();
        bw.close();
    }
}