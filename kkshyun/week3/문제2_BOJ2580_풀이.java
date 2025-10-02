import java.io.*;

public class BJ_2580_0930 {
    static int[][] graph;
    static int length;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        length = 9;
        String[] s;
        graph = new int[length][length];
        for (int i = 0; i < length; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < length; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }

        dfs(0,0);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                bw.write(graph[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static boolean dfs(int row, int col) {
        if (row == length) return true; // 모든 행 채움
        int nextRow = (col == length - 1) ? row + 1 : row;
        int nextCol = (col == length - 1) ? 0 : col + 1;
        if(graph[row][col] != 0)
            return dfs(nextRow, nextCol);
        for (int i = 1; i <= 9; i++) {
            if(possible(row, col, i)) {
                graph[row][col] = i;
                if (dfs(nextRow, nextCol)) return true; // 해답 찾으면 즉시 종료
                graph[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean possible(int row, int col, int target) {
        // 겹치는 열 원소가 있는지 확인
        for (int i = 0; i < length; i++) {
            if(graph[row][i] == target) return false;
        }

        // 겹치는 행 원소가 있는지 확인
        for (int i = 0; i < length; i++) {
            if(graph[i][col] == target) return false;
        }

        // 네모칸에 들어갈 수 있는지 확인
        int recRow = row - row%3;
        int recCol = col - col%3;
        for (int i = recRow; i < recRow+3; i++) {
            for (int j = recCol; j < recCol+3; j++) {
                if(graph[i][j] == target) return false;
            }
        }
        return true;
    }
}
