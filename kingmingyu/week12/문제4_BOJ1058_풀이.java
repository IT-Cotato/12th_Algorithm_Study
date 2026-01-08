package kingmingyu.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문제4_BOJ1058_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int isFriendArr[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                if(i == j) isFriendArr[i][j] = 0;

                if(str.charAt(j) == 'N') isFriendArr[i][j] = 999;
                else isFriendArr[i][j] = 1;
            }
        }

        int max = 0;


        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                // 자기 자신인 경우
                if(i == j) continue;
                boolean isFriend = false;

                if(isFriendArr[i][j] == 1){
                    isFriend = true;
                }
                for(int k = 0; k < n; k++){
                    if(isFriendArr[i][k] + isFriendArr[k][j] == 2){
                        isFriend = true;
                        break;
                    }
                }
                if (isFriend) count++;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
