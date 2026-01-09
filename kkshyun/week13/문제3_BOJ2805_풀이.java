import java.io.*;

public class Main {
    static int[] trees;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        int max = 0;
        trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(s[i]);
            max = Math.max(max, trees[i]);
        }
        // 이분탐색(나무 최대길이에서 반씩 줄이면서 M이 되는지 확인)
        bw.write(binarySearch(0, max)+"\n");
        bw.flush();
        bw.close();
    }

    static long binarySearch(int start, int end) {
        if(start >= end)
            return start-1;
        int mid = (start + end) / 2;
        long sum = 0;
        for (int i = 0; i < trees.length; i++) {
            sum += Math.max(trees[i] - mid,0);
        }
        if(sum > M) // 나무를 많이 자르는거니까 더 길이를 보존해도 됨
            return binarySearch(mid+1, end);
        else if(sum < M)
            return binarySearch(start, mid);
        else
            return mid;
    }
}