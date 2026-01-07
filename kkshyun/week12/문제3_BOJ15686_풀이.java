import java.io.*;
import java.util.ArrayList;

public class Main {
    static class Point {
        int col;
        int row;
        public Point(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }
    static ArrayList<Point> onePoints = new ArrayList<>();
    static ArrayList<Point> twoPoints = new ArrayList<>();
    static boolean[] visited;
    static int N, M;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        // 치킨집 중 M개를 고르고(조합) 여기에서 각 집의 치킨거리의 합
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        // 입력받기(0 : 빈칸, 1 : 집, 2 : 치킨집)
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(s[j]);
                if(num == 1)
                    onePoints.add(new Point(i,j));
                else if(num == 2)
                    twoPoints.add(new Point(i,j));
            }
        }

        visited = new boolean[twoPoints.size()];

        // 치킨집 선정
        choiceChicken(0, twoPoints.size(), M);
        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
    static void choiceChicken(int start, int n, int r) {
        if(r == 0) {
            // 치킨거리 계산
            calChickenStreet();
            return;
        }
        for(int i = start; i < n; i++) {
            visited[i] = true;
            choiceChicken(i+1, n, r-1);
            visited[i] = false;
        }
    }
    static void calChickenStreet() {
        int sum = 0;
        int min;
        for (int i = 0; i < onePoints.size(); i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < visited.length; j++) {
                if(visited[j])
                    min = Math.min(Math.abs(onePoints.get(i).col-twoPoints.get(j).col) + Math.abs(onePoints.get(i).row-twoPoints.get(j).row), min);
            }
            sum += min;
        }
        result = Math.min(result, sum);
    }
}