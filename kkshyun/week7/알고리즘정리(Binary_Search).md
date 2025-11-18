## 이분탐색(Binary Search)

### 01. “이분탐색” 이란?

- 이진 탐색이라고도 함
- 정렬된 배열에서 원하는 값을 찾기 위해 탐색 범위를 계속해서 절반씩 줄여나가는 알고리즘
- 배열의 중앙값을 먼저 확인하고, 찾고자 하는 값이 중앙값보다 크면 오른쪽 절반, 작으면 왼쪽 절반에서 다시 탐색을 진행하는 방식
- 탐색 범위가 매번 절반으로 줄어들어 빠르게 탐색 가능
- 탐색 시간 복잡도는 O(logn)
- 반드시 정렬된 배열에서 사용

### 02. **이분탐색의 작동 원리**

1. 시작: 탐색할 배열의 시작(low)과 끝(high) 인덱스를 설정합니다.
2. 중앙값 계산: `mid = (low + high) / 2` 와 같은 방식으로 중앙 인덱스를 계산합니다.
3. 값 비교:
    - 찾고자 하는 값이 `array[mid]` 와 같으면, 해당 인덱스를 반환하고 탐색을 종료합니다.
    - 찾고자 하는 값이 `array[mid]` 보다 작으면, 탐색 범위를 왼쪽 절반으로 줄이고 `high`를 `mid - 1`로 업데이트합니다.
    - 찾고자 하는 값이 `array[mid]` 보다 크면, 탐색 범위를 오른쪽 절반으로 줄이고 `low`를 `mid + 1`로 업데이트합니다.
4. 반복: `low`와 `high`가 같아지거나 겹치지 않을 때까지 2~3번 과정을 반복합니다.

### 03. lower_bound, upper_bound

- 정렬된 배열/리스트에서 경계(첫 위치)를 찾는 함수들
- 시간복잡도는 둘 다 O(logn)
- lower_bound(x): 정렬된 시퀀스에서 처음으로 `값 ≥ x`가 되는 인덱스
- upper_bound(x): 정렬된 시퀀스에서 처음으로 `값 > x`가 되는 인덱스
- 우리가 좁히는 건 정답 인덱스 범위

```c
// 첫 a[idx] >= x 의 idx (없으면 a.length)
static int lowerBound(int[] a, int x) {
    int low = 0, high = a.length; // [low, high)
    while (low < high) {
        int mid = low + (high - low) / 2; // 오버플로우 방지
        if (a[mid] < x) low = mid + 1;
        else            high = mid;
    }
    return low;
}

// 첫 a[idx] > x 의 idx
static int upperBound(int[] a, int x) {
    int low = 0, high = a.length; // [low, high)
    while (low < high) {
        int mid = low + (high - low) / 2;
        if (a[mid] <= x) low = mid + 1;
        else             high = mid;
    }
    return low;
}
```

### 4. 닫힌 구간, 반열린 구간 비교

- 닫힌 구간 `[low, high]` (정확히 같은 값 찾기 직관적)
    - `while (low <= high)`
    - `a[mid] < x` → `low = mid + 1` / `a[mid] > x` → `high = mid - 1`
- 반열린 구간 `[low, high)` (경계·삽입 위치에 최적)
    - `while (low < high)`
    - `a[mid] < x` → `low = mid + 1` / else → `high = mid`
    - 종료 시 `low`가 곧 삽입 위치(=lower_bound)