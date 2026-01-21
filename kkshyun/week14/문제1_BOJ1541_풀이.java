import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split("-");
        int max = 0;
        int sum = 0;
        for (int i = 0; i < tokens.length; i++) {
            max = 0;
            String[] s = tokens[i].split("\\+");
            for (int j = 0; j < s.length; j++) {
                max += Integer.parseInt(s[j]);
            }
            if(i == 0) {
                sum += max;
            } else {
                sum -= max;
            }
        }
        System.out.println(sum);
    }
}