import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String number = br.readLine();

		Deque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			char c = number.charAt(i);

			// 스택의 top보다 현재 숫자가 크면 앞자리 제거
			while (!stack.isEmpty() && k > 0 && stack.peekLast() < c) {
				stack.pollLast();
				k--;
			}
			stack.addLast(c);
		}

		// 제거 안 끝났으면 뒤에서 제거
		while (k > 0) {
			stack.pollLast();
			k--;
		}

		StringBuilder sb = new StringBuilder();
		for (char c : stack)
			sb.append(c);

		System.out.println(sb.toString());
	}
}
