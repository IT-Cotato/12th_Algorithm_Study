## DP(Dynamic Programming)

### 01. “DP” 란?

- 같은 계산이 반복되는 문제에서 계산 결과를 배열에 저장해 재사용하는 기법
- 중복 연산을 줄여 시간 복잡도를 크게 낮출 수 있음
- 보통 dp 배열이 필요함
    - dp[i] 또는 dp[i][j] 형태로 상태를 저장
- 상태 정의 + 점화식 + 초기값

### 02. DP 문제 성립 조건

1. 최적 부분 구조(Optimal Substructure)
    - 전체 문제의 최적해가 부분 문제의 최적해로 구성됨
    - 큰 문제를 작은 문제 답으로 만들 수 있어야 함
2. 중복되는 부분 문제(Overlapping Subproblem)
    - 같은 부분 문제가 여러 번 등장함
    - 이미 푼 부분 문제를 다시 풀게 되는 구조여야 함

### 03. DP 푸는 순서

1. 상태 정의
    - dp가 의미하는 값을 한 문장으로 정의
    - 예: dp[i] = i번째까지 고려했을 때의 최댓값
    - 예: dp[i][j] = i까지 봤고 상태가 j일 때의 최소 비용
2. 점화식(전이) 세우기
    - 현재 상태를 이전 상태들로부터 계산하는 식 작성
    - 예: dp[i] = max(dp[i-1], dp[i-2] + a[i])
3. 초기값 설정
    - 가장 작은 문제에서 시작할 값 채우기
    - 예: dp[0], dp[1] 같은 시작 값
4. 계산 순서 선택
    - top-down 또는 bottom-up 결정
5. 정답 도출
    - dp의 마지막 값 또는 조건에 맞는 값에서 정답 추출

### 04. Top-down 과 Bottom-up

- 공통점
    - 둘 다 dp 배열에 값을 저장하며 중복 계산을 막음
    - 점화식 기반으로 답을 만든다는 점은 동일
- 차이점
    - top-down
        - 재귀 + 메모이제이션
        - 필요한 값만 내려가서 계산하고 저장
        - 재귀 깊이 문제, 호출 오버헤드가 있을 수 있음

        ```java
        public static int[][] fibo(int N) {
        	if(N==0) {
        	    dp[N][0] = 1;
        	    dp[N][1] = 0;
        	    return dp;
        	}
        	if(N==1) {
        	    dp[N][0] = 0;
        	    dp[N][1] = 1;
        	    return dp;
        	}
        	if(dp[N][0]!=0||dp[N][1]!=0)
        	    return dp;
        
        	int count0 = fibo(N-1)[N-1][0] + fibo(N-2)[N-2][0];
        	int count1 = fibo(N-1)[N-1][1] + fibo(N-2)[N-2][1];
        	dp[N][0] = count0;
        	dp[N][1] = count1;
        	return dp;
        }
        
        ```

    - bottom-up
        - 반복문으로 작은 값부터 차곡차곡 채움
        - 보통 실행이 더 안정적이고 빠른 편
        - 필요 없는 상태까지 채울 수도 있음

        ```java
        public static void dp() {
            remember[0][0] = colors[0][0];
            remember[0][1] = colors[0][1];
            remember[0][2] = colors[0][2];
        
            for (int i = 1; i < N; i++) {
                remember[i][0] = Math.min(remember[i-1][1] + colors[i][0], remember[i-1][2] + colors[i][0]);
                remember[i][1] = Math.min(remember[i-1][0] + colors[i][1], remember[i-1][2] + colors[i][1]);
                remember[i][2] = Math.min(remember[i-1][0] + colors[i][2], remember[i-1][1] + colors[i][2]);
            }
        }
        ```


### 05. 메모리 최적화

- dp 배열이 커지는 문제가 자주 생김
- 점화식이 바로 이전 값만 참조하면 전체 배열이 필요 없음
    - 2행만 유지하는 방식
    - 1차원으로 줄이는 방식
- 예
    - dp[i]가 dp[i-1], dp[i-2]만 필요하면 변수 2개로도 가능

### 06. DP 활용 예제

- 기본
    - 피보나치 수
    - 계단 오르기
    - 연속 부분 최대 합
- 대표 DP 유형 예시
    - LIS 가장 긴 증가하는 부분 수열
    - 0/1 Knapsack 배낭 문제
    - LCS 최장 공통 부분 수열
    - 편집 거리(Edit Distance)
    - 격자 최소 비용 경로