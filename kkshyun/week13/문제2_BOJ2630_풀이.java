import java.io.*;

public class Main {
    static int[][] graph;
    static int whiteCount = 0;
    static int blueCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }

        cal(0,0,N);
        bw.write(whiteCount+"\n");
        bw.write(blueCount+"\n");
        bw.flush();
        bw.close();
    }
    public static void cal(int startX, int startY, int size) {
        boolean sameColor = true;
        int color = graph[startX][startY];

        // 범위 안에 있는 숫자가 다 같은 숫자 -> 색깔++;
        // 다른 숫자가 하나라도 나오면 -> 재귀적으로 호출

        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if(color != graph[i][j]) {
                    sameColor = false;
                }
            }
        }

        if(sameColor) {
            if(color == 0)
                whiteCount++;
            else
                blueCount++;
            return;
        }

        cal(startX, startY, size/2);
        cal(startX+size/2, startY, size/2);
        cal(startX, startY+size/2, size/2);
        cal(startX+size/2, startY+size/2, size/2);
    }
}