import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int R, C, max = 0;
    static Set<Character> set;
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }
        set = new HashSet<Character>();
        set.add(board[0][0]);
        dfs(0,0, 1);
        bw.write(max+"\n");
        bw.flush();
        bw.close();
    }
    static void dfs(int row, int col, int depth) {
        max = Math.max(max, depth);

        for(int i = 0; i < 4; i++) {
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];
            if(nextRow>=0 && nextRow<R && nextCol>=0 && nextCol<C) {
                if(!set.contains(board[nextRow][nextCol])) {
                    set.add(board[nextRow][nextCol]);
                    dfs(nextRow, nextCol,depth + 1);
                    set.remove(board[nextRow][nextCol]);
                }
            }
        }
    }
}