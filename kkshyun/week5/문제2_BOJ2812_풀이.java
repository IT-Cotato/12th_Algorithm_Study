import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int K = Integer.parseInt(nm[1]);
        char[] digits = br.readLine().trim().toCharArray();

        Deque<Character> stack = new ArrayDeque<>(N);

        for (char d : digits) {
            while (!stack.isEmpty() && K > 0 && stack.peekLast() < d) {
                stack.pollLast(); // 더 작은 앞자리를 제거해 큰 수를 앞으로
                K--;
            }
            stack.addLast(d);
        }

        // 아직 제거 횟수가 남았으면 뒤에서 제거
        while (K > 0) {
            stack.pollLast();
            K--;
        }

        for (char c : stack) {
            bw.write(c+"");
        }
        bw.flush();
        bw.close();
    }
}