package kingmingyu.week12;

import java.util.*;
import java.io.*;

class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class 문제3_BOJ15686_풀이 {
    public static int n, m;
    public static List<Point> houses = new ArrayList<>();
    public static List<Point> chicken = new ArrayList<>();
    public static boolean[] selected;
    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int now = Integer.parseInt(st.nextToken());
                if(now == 1) houses.add(new Point(i, j));
                if(now == 2) chicken.add(new Point(i, j));
            }
        }

        dfs(0, 0);

        System.out.println(result);

    }

    public static void dfs(int start, int count){
        if(count == m){
            calcDist();
            return;
        }

        for(int i = start; i < chicken.size(); i++){
            selected[i] = true;
            dfs(i + 1, count + 1);
            selected[i] = false;
        }
    }

    public static void calcDist(){
        int totalDist = 0;

        for(Point house : houses){
            int minDist = Integer.MAX_VALUE;

            for(int i = 0; i < chicken.size(); i++){
                if(selected[i]){
                    int dist = Math.abs(house.x - chicken.get(i).x) + Math.abs(house.y - chicken.get(i).y);
                    minDist = Math.min(dist, minDist);
                }
            }
            totalDist += minDist;
        }

        result = Math.min(result, totalDist);
    }
}
