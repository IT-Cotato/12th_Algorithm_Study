import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[20];
        List<Integer> list = new ArrayList<>();
        int count;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append(" ");
            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            count = 0;
            list.clear();
            for (int j = 0; j < arr.length; j++) {
                list.add(arr[j]);
                for(int before : list) {
                    if(before > arr[j])
                        count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}