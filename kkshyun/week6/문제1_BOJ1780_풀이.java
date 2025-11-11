import java.io.*;

public class Main {
    public static int[] count;
    public static int[][] graph;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        count = new int[3]; // count[0] : -1인 종이 수, count[1] : 0인 종이 수, count[2] : 1인 종이 수
        String[] s;
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }

        checkPaperCount(0, N-1, 0, N-1);
        for (int i = 0; i < 3; i++) {
            bw.write(count[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static void checkPaperCount(int col1, int col2, int row1, int row2) {
        if(col2-col1==0 || row2-row1==0) {
            count[graph[col1][row1]+1]++;
            return;
        }
        int num = graph[col1][row1];
        for (int i = col1; i <= col2; i++) {
            for (int j = row1; j <= row2; j++) {
                if(num != graph[i][j]) {
                    int width = (col2-col1+1)/3;
                    int height = (row2-row1+1)/3;
                    for (int k = col1; k <= col2; k+=width) {
                        for (int l = row1; l <= row2; l+=height) {
                            checkPaperCount(k,k+height-1,l,l+width-1);
                        }
                    }
                    return;
                }
            }
        }
        count[num+1]++;
    }
}