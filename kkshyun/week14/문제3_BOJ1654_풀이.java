import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int K, N;
    static int[] kLength;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        K = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        kLength = new int[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            kLength[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, kLength[i]);
        }
        System.out.println(binarySearch(1,max+1)-1);
    }

    public static long binarySearch(long start, long end) {
        long mid, count;
        while(start < end) {
            mid = (start + end) / 2;
            count = 0;
            for (int i = 0; i < K; i++) {
                count += kLength[i] / mid;
            }
            if(count < N)
                end = mid;
            else
                start = mid + 1;
        }
        return end;
    }
}