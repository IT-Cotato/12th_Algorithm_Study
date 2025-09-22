import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Deque<Integer> stack = new ArrayDeque<>();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (command.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				stack.addLast(x);
			} else if (command.equals("pop")) {
				Integer pop = stack.pollLast();
				bw.write((pop == null ? -1 : pop) + "\n");
			} else if (command.equals("top")) {
				Integer top = stack.peekLast();
				bw.write((top == null ? -1 : top) + "\n");
			} else if (command.equals("empty")) {
				bw.write((stack.isEmpty() ? 1 : 0) + "\n");
			} else if (command.equals("size")) {
				bw.write(stack.size() + "\n");
			}
		}

		bw.flush();
	}
}