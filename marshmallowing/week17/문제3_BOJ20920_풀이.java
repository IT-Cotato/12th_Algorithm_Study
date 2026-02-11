import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); //개수
		int m = Integer.parseInt(st.nextToken()); //길이

		// key: 단어, value: 등장 횟수
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			if (word.length() < m) {
				continue;
			}

			// 이미 존재하면 +1, 없으면 0에서 시작해 +1
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		List<String> words = new ArrayList<>(map.keySet());

		Collections.sort(words, (a, b) -> {
			if (map.get(a) != map.get(b)) {
				return map.get(b) - map.get(a);   // 빈도
			}
			if (a.length() != b.length()) {
				return b.length() - a.length();   // 길이
			}
			return a.compareTo(b);                // 사전순
		});

		for (String word : words) {
			bw.write(word);
			bw.newLine();
		}
		bw.flush();
	}
}