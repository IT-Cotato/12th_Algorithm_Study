import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		StringBuilder out = new StringBuilder();
		Deque<Character> stack = new ArrayDeque<>();
		boolean inTag = false;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '<') {
				// 태그 시작 전: 단어 뒤집어 출력
				while (!stack.isEmpty()) out.append(stack.removeLast());
				inTag = true;
				out.append(c);
			} else if (c == '>') {
				inTag = false;
				out.append(c);
			} else if (inTag) {
				// 태그 내부는 그대로
				out.append(c);
			} else {
				if (c == ' ') {
					while (!stack.isEmpty()) out.append(stack.removeLast());
					out.append(' ');
				} else {
					stack.addLast(c);
				}
			}
		}
		while (!stack.isEmpty()) out.append(stack.removeLast());

		System.out.println(out);
	}
}
