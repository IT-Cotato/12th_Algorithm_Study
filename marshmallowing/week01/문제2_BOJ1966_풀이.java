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

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //문서 개수
			int b = Integer.parseInt(st.nextToken()); //목표 문서 인덱스

			st = new StringTokenizer(br.readLine());
			Deque<int[]> queue = new ArrayDeque<>();
			for (int j = 0; j < a; j++) {
				int priority = Integer.parseInt(st.nextToken());
				queue.addLast(new int[] {priority, j}); // [우선순위, 원래 인덱스]
			}

			int count = 0;

			while (!queue.isEmpty()) {
				int[] cur = queue.peekFirst();
				boolean hasHigher = false;

				// 현재 문서보다 우선순위 높은 문서 있는지 확인
				for (int[] doc : queue) {
					if (doc[0] > cur[0]) {
						hasHigher = true;
						break;
					}
				}

				if (hasHigher) {
					queue.addLast(queue.pollFirst());
				} else {
					queue.pollFirst();
					count++;
					if (cur[1] == b) {
						bw.write(count + "\n");
						break;
					}
				}
			}
		}
		bw.flush();
	}
}