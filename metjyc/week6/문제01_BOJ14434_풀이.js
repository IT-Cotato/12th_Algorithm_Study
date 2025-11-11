const fs = require("fs");
const input = fs.readFileSync(0, "utf8").trim().split("\n");

let line = 0;
const [N, M, K, Q] = input[line++].trim().split(" ").map(Number);

// 놀이기구 키 제한 M개 (1..M) → 접근 시 kk-1 사용
const p = input[line++].trim().split(" ").map(Number);

// K일 동안 키가 자라는 아이 번호 (1..N) → 0-based로 저장
const cIdx = input[line++]
  .trim()
  .split(" ")
  .map((v) => Number(v) - 1);

// 질의 Q줄: (i, j, k) 모두 1-based로 들어옴
const qwerty = new Array(Q);
for (let q = 0; q < Q; q++) {
  qwerty[q] = input[line++].trim().split(" ").map(Number);
}

// 1) 각 질의의 "최초 성공일"을 이분 탐색으로 찾기
//    L[q] = 1, R[q] = K+1  (K+1은 끝까지도 불가능)

const L = new Array(Q).fill(1);
const R = new Array(Q).fill(K + 1);

const hasActive = () => {
  for (let q = 0; q < Q; q++) if (L[q] < R[q]) return true;
  return false;
};

while (hasActive()) {
  // mid별 버킷 (1..K, 그리고 K+1)
  const bucket = Array.from({ length: K + 2 }, () => []);

  for (let q = 0; q < Q; q++) {
    if (L[q] < R[q]) {
      const mid = (L[q] + R[q]) >> 1; // floor((L+R)/2)
      bucket[mid].push(q);
    }
  }

  // 이번 라운드에서 사용할 누적 성장 카운터
  const cnt = new Array(N).fill(0);

  // 1..K일 스윕: "성장 먼저", 그 날을 mid로 가진 질의들 판정
  for (let t = 1; t <= K; t++) {
    cnt[cIdx[t - 1]]++;

    const list = bucket[t];
    for (let idx = 0; idx < list.length; idx++) {
      const q = list[idx];
      const [ii, jj, kk] = qwerty[q]; // 모두 1-based
      const need = p[kk - 1]; // 놀이기구 k의 키 제한
      const have = cnt[ii - 1] + cnt[jj - 1];

      if (have >= need) {
        R[q] = t; // mid=t에서 성립 => 더 이른 날이 있는지 왼쪽으로
      } else {
        L[q] = t + 1; // 아직 부족 => 더 뒤 날로
      }
    }
  }

  // mid = K+1 버킷: K일까지 모두 반영된 cnt로 판정
  const tail = bucket[K + 1];
  if (tail.length) {
    for (let idx = 0; idx < tail.length; idx++) {
      const q = tail[idx];
      const [ii, jj, kk] = qwerty[q];
      const need = p[kk - 1];
      const have = cnt[ii - 1] + cnt[jj - 1];

      if (have >= need) {
        // 실제 최초 성공일은 1..K 어딘가 => 오른쪽 경계만 줄이기
        R[q] = K;
      } else {
        // 끝까지도 불가능
        L[q] = K + 1;
      }
    }
  }
}

const diff = new Array(K + 2).fill(0);
for (let q = 0; q < Q; q++) {
  const d = R[q];
  if (d <= K) diff[d] += 1; // d일부터 매일 1씩 더해짐
}

let running = 0;
let out = [];
for (let t = 1; t <= K; t++) {
  running += diff[t];
  out.push(String(running));
}
console.log(out.join("\n"));
