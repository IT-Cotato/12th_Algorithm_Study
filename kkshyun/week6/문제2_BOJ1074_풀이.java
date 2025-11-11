import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = -1;
    static int r;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        r = Integer.parseInt(s[1]);
        c = Integer.parseInt(s[2]);
        // 재귀적으로 계산
        route(0,0, N);
    }

    public static void route(int startR, int startC, int NSize) {
        if(NSize == 1) {
            for (int i = startR; i < startR+2; i++) {
                for (int j = startC; j < startC+2; j++) {
                    count++;
                    if(i == r && j == c) {
                        System.out.println(count);
                        return;
                    }
                }
            }
        }
        else if(NSize > 1) {
            int pow = (int)Math.pow(2, NSize - 1);
            if(r >= startR && r < startR + pow) {
                if(c >= startC && c < startC + pow)
                    route(startR, startC, NSize-1);
                else {
                    count += pow*pow;
                    route(startR, startC + pow, NSize-1);
                }
            } else {
                if(c >= startC && c < startC + pow) {
                    count += pow*pow*2;
                    route(startR + pow, startC, NSize-1);
                }
                else {
                    count += pow*pow*3;
                    route(startR + pow, startC + pow, NSize-1);
                }
            }
        }
    }
}