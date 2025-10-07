import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board = new int[9][9];

	static boolean found = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 백트래킹 시작
		solve(0, 0);
	}


	private static void solve(int r, int c) {
		//  한 행의 끝에 도달했을 때 (열 c가 9일 때)
		if (c == 9) {
			solve(r + 1, 0);
			return;
		}

		// 모든 행을 탐색했을 때 (행 r이 9일 때)
		if (r == 9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(board[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.print(sb);
			found = true;
			return;
		}

		// 이미 채워진 칸인 경우
		if (board[r][c] != 0) {
			solve(r, c + 1);
			return;
		}

		// 빈 칸(0)인 경우
		for (int num = 1; num <= 9; num++) {
			// 현재 숫자가 스도쿠 규칙을 위반하는지 검사
			if (isPossible(r, c, num)) {

				// 숫자 num을 보드에 임시로 채움
				board[r][c] = num;

				// 재귀 호출: 다음 칸으로 이동
				solve(r, c + 1);

				if (found) return;

				// 되돌리기
				board[r][c] = 0;
			}
		}
	}

	private static boolean isPossible(int r, int c, int num) {
		// 가로줄 검사
		for (int i = 0; i < 9; i++) {
			if (board[r][i] == num) {
				return false;
			}
		}

		// 세로줄 검사
		for (int i = 0; i < 9; i++) {
			if (board[i][c] == num) {
				return false;
			}
		}

		// 3x3 박스 검사
		int startR = (r / 3) * 3;
		int startC = (c / 3) * 3;

		for (int i = startR; i < startR + 3; i++) {
			for (int j = startC; j < startC + 3; j++) {
				if (board[i][j] == num) {
					return false;
				}
			}
		}

		return true;
	}
}