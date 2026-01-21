import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		String[] minusSplit = input.split("-");

		int sum = 0;

		for (int i = 0; i < minusSplit.length; i++) {
			String part = minusSplit[i];
			String[] plusSplit = part.split("\\+");

			if (i == 0) {
				for (String s : plusSplit) {
					sum += Integer.parseInt(s);
				}
			} else {
				for (String s : plusSplit) {
					sum -= Integer.parseInt(s);
				}
			}
		}

		bw.write(String.valueOf(sum));

		bw.flush();
		bw.close();
	}
}