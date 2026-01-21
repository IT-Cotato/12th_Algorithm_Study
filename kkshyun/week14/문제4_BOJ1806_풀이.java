import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int S = Integer.parseInt(s[1]);
        Integer[] arr = new Integer[N];
        s = br.readLine().split(" ");
        int sum = 0;
        int startIndex = 0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
            sum += arr[i];
            while(sum >= S) {
                minLength = Math.min(minLength, i-startIndex+1);
                sum -= arr[startIndex];
                startIndex++;
            }
        }
        if(minLength == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(minLength);
    }
}