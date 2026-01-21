import java.io.*;

public class Main {
    static int[][] graph;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < s.length; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }
        divideAndConquer(0,0,N);
        System.out.println(sb);
    }

    public static void divideAndConquer(int startCol, int startRow, int size) throws IOException {
        if(size == 1) {
            sb.append(graph[startCol][startRow]);
            return;
        }
        int temp = graph[startCol][startRow];
        boolean check = true;
        for (int i = startCol; i < startCol + size; i++) {
            for (int j = startRow; j < startRow + size; j++) {
                if(temp != graph[i][j]) {
                    check = false;
                    break;
                }
            }
        }
        if(check)
            sb.append(temp);
        else {
            int newSize = size/2;
            sb.append("(");
            divideAndConquer(startCol,startRow,newSize);
            divideAndConquer(startCol,startRow+newSize,newSize);
            divideAndConquer(startCol+newSize,startRow,newSize);
            divideAndConquer(startCol+newSize,startRow+newSize,newSize);
            sb.append(")");
        }
    }
}