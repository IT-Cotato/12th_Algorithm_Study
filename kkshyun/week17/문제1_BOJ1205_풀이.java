import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N == 0) {
            System.out.println("1");
            return;
        }

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(N == P && newScore <= arr[N-1]) {
            System.out.println("-1");
            return;
        }

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (arr[i] > newScore){
                rank++;
            }
        }
        System.out.println(rank);
    }
}