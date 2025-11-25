import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int X = Integer.parseInt(s[1]);
        int[] visitNumberArray = new int[N];
        int max = 0;
        int maxCount = 1;
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            visitNumberArray[i] = Integer.parseInt(s[i]);
        }
        for (int i = 0; i < X; i++) {
            max += visitNumberArray[i];
        }
        int temp = max;
        for (int i = 0; i < N-X; i++) {
            temp += visitNumberArray[i + X] - visitNumberArray[i];
            if(max == temp) {
                maxCount++;
            } else if(max < temp) {
                max = temp;
                maxCount = 1;
            }
            // max > temp 면 변화 없음
        }
        if(max == 0)
            bw.write("SAD\n");
        else
            bw.write(max+"\n"+maxCount);
        bw.flush();
        bw.close();
    }
}