import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 최대거리를 이분탐색으로 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int C = Integer.parseInt(s[1]);
        int[] location = new int[N];
        for (int i = 0; i < N; i++) {
            int loc = Integer.parseInt(br.readLine());
            location[i] = loc;
        }
        Arrays.sort(location);

        // upperbound 로 구해 가능한 최대 길이는 -1을 해야함
        bw.write(possible(location, location[location.length-1], C)+"\n");
        bw.flush();
        bw.close();

    }
    public static int possible(int[] loc, int maxLoc, int c) {
        int low = 0, high = maxLoc+1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            int count = count(loc, mid);
            if (count < c) high = mid;
            else low = mid + 1;
        }
        return low -1;
    }

    public static int count(int[] loc, int length) {
        int houseCount = 1;
        int beforeHouse = 0;
        for (int i = 1; i < loc.length; i++) {
            if(loc[i] >= loc[beforeHouse]+length) {
                houseCount++;
                beforeHouse = i;
            }
        }
        return houseCount;
    }
}