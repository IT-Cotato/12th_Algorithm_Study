import java.io.*;

public class Main {
    public static int[] stack;
    public static int top = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] s;
        int commandResult;

        stack = new int[N + 1]; // 최대 N개 push 가능 → N+1 크기로 생성

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            commandResult = stack(s);
            if (s[0].equals("push"))
                continue; // push는 출력 없음
            bw.write(commandResult + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int stack(String[] str) {
        int stackResult = 0;
        switch (str[0]) {
            case "push":
                stack[++top] = Integer.parseInt(str[1]);
                break;
            case "pop":
                if (top == 0) return -1;
                stackResult = stack[top--];
                break;
            case "size":
                stackResult = top;
                break;
            case "empty":
                stackResult = (top == 0 ? 1 : 0);
                break;
            case "top":
                if (top == 0) return -1;
                stackResult = stack[top];
                break;
        }
        return stackResult;
    }
}