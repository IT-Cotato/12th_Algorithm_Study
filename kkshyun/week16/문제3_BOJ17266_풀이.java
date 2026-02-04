import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            int term = arr[i+1] - arr[i];
            if(term > max*2) {
                max = (int)Math.ceil((double) term / 2);
            }
        }
        max = Math.max(max, N - arr[M-1]);
        System.out.println(max);
    }
}