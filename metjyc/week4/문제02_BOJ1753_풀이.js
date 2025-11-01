const fs = require("fs");

const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [V, E] = input[0].split(" ").map(Number);
const K = Number(input[1]);

const graph = Array.from({ length: V + 1 }, () => []);

for (let i = 2; i < 2 + E; i++) {
  const [u, v, w] = input[i].split(" ").map(Number);
  graph[u].push({ to: v, w });
}

const INF = 1e18;
const dist = Array(V + 1).fill(INF);
dist[K] = 0;

class MinHeap {
  constructor() {
    this.h = [];
  }
  size() {
    return this.h.length;
  }
  _swap(a, b) {
    [this.h[a], this.h[b]] = [this.h[b], this.h[a]];
  }
  push(val) {
    this.h.push(val);
    let i = this.h.length - 1;
    while (i > 0) {
      const p = Math.floor((i - 1) / 2);
      if (this.h[p][0] <= this.h[i][0]) break;
      this._swap(p, i);
      i = p;
    }
  }
  pop() {
    const n = this.h.length;
    if (n === 0) return null;
    if (n === 1) return this.h.pop();

    this._swap(0, n - 1);
    const out = this.h.pop();

    let i = 0;
    while (true) {
      const l = i * 2 + 1;
      const r = i * 2 + 2;
      let m = i;

      if (l < this.h.length && this.h[l][0] < this.h[m][0]) m = l;
      if (r < this.h.length && this.h[r][0] < this.h[m][0]) m = r;

      if (m === i) break;
      this._swap(i, m);
      i = m;
    }

    return out;
  }
}

const pq = new MinHeap();
pq.push([0, K]);

while (pq.size()) {
  const cur = pq.pop();
  if (!cur) break;
  const [d, u] = cur;

  if (d !== dist[u]) continue;

  for (const { to: v, w } of graph[u]) {
    const nd = d + w;
    if (nd < dist[v]) {
      dist[v] = nd;
      pq.push([nd, v]);
    }
  }
}

let out = "";
for (let i = 1; i <= V; i++) {
  out += (dist[i] === INF ? "INF" : String(dist[i])) + "\n";
}
console.log(out.trim());
