const fs = require("fs");
const input = fs.readFileSync(0, "utf8").trim().split("\n");

class MaxHeap {
  constructor() {
    this.h = [];
  }

  size() {
    return this.h.length;
  }

  push(x) {
    const h = this.h;
    h.push(x);
    let i = h.length - 1;

    while (i > 0) {
      const p = (i - 1) >> 1; // 부모 인덱스
      if (h[p] >= h[i]) break;
      [h[p], h[i]] = [h[i], h[p]];
      i = p;
    }
  }

  pop() {
    const h = this.h;
    if (h.length === 0) return null;

    const top = h[0];
    const last = h.pop();

    if (h.length > 0) {
      h[0] = last;
      let i = 0;

      while (true) {
        const l = i * 2 + 1;
        const r = i * 2 + 2;
        let best = i;

        if (l < h.length && h[l] > h[best]) best = l;
        if (r < h.length && h[r] > h[best]) best = r;

        if (best === i) break;

        [h[i], h[best]] = [h[best], h[i]];
        i = best;
      }
    }

    return top;
  }
}

const n = Number(input[0]);
const heap = new MaxHeap();
let out = [];

for (let i = 1; i <= n; i++) {
  const arr = input[i].split(" ").map(Number);
  const a = arr[0];

  if (a === 0) {
    const val = heap.pop();
    out.push(val === null ? "-1" : String(val));
  } else {
    for (let j = 1; j <= a; j++) heap.push(arr[j]);
  }
}

console.log(out.join("\n"));
