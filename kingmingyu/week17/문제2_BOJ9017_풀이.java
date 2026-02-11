package kingmingyu.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제2_BOJ9017_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 전체 입력
            int[] input = new int[n];
            // 팀원 수 세기
            int[] count = new int[201];

            for(int j = 0; j < n; j++){
                int team = Integer.parseInt(st.nextToken());
                input[j] = team;
                count[team] ++;
            }

            int[] scores = new int[201];
            int[] player = new int[201];
            int[] five = new int[201];

            int rank = 1;
            for(int j = 0; j < n; j++){
                int team = input[j];
                // 팀 인원이 6명이 안되는 경우 (점수 반영 X)
                if(count[team] < 6) continue;

                // 4명까지 점수 계산
                if(player[team] < 4){
                    scores[team] += rank;
                    player[team] ++;
                }
                // 5번째 선수 저장
                else if(player[team] == 4){
                    five[team] = rank;
                    player[team]++;
                }

                rank ++;
            }

            // 순위 계산
            int winner = 0;
            int minScore = Integer.MAX_VALUE;
            int minFifth = Integer.MAX_VALUE;

            for (int j = 1; j <= 200; j++) {
                if (count[j] < 6) continue;

                if (scores[j] < minScore) {
                    minScore = scores[j];
                    minFifth = five[j];
                    winner = j;
                } else if (scores[j] == minScore) {
                    // 점수가 같으면 5번째 주자의 점수가 더 낮은 팀이 승리
                    if (five[j] < minFifth) {
                        minFifth = five[j];
                        winner = j;
                    }
                }
            }
            System.out.println(winner);

        }
    }
}
