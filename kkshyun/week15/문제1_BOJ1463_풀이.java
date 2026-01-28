import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] result = new int[N+1];
        for (int i = 2; i < result.length; i++) {
            if(i % 6 == 0) {
                result[i] = Math.min(result[i/3], result[i/2]) + 1;
            } else if(i % 3 == 0)
                result[i] = Math.min(result[i/3], result[i-1]) + 1;
            else if(i % 2 == 0)
                result[i] = Math.min(result[i/2], result[i-1]) + 1;
            else
                result[i] = result[i-1] + 1;
        }
        System.out.println(result[N]);
    }
}