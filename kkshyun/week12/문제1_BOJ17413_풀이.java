import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean check = false;
        for (int i = 0; i < str.length(); i++) {
            if(check) { // 괄호 안의 문자인 경우에는 그대로 출력
                if(str.charAt(i) == '>')
                    check = false;
                bw.write(str.charAt(i));
            }
            else if(str.charAt(i) == '<') { // 괄호 시작의 경우(기존에 있던 stack 내용 모두 꺼냄)
                while(!stack.isEmpty()) {
                    bw.write(stack.pollLast());
                }
                check = true;
                bw.write(str.charAt(i));
            }
            else if(str.charAt(i) == ' ') { // 괄호 안에 있는 띄어쓰기가 아닌 경우(stack에 있는 내용 모두 꺼내고 새로운 stack을 시작해야함)
                while(!stack.isEmpty()) {
                    bw.write(stack.pollLast());
                }
                bw.write(str.charAt(i));
            }
            else stack.add(str.charAt(i)); // 모두 아닌 경우 거꾸로 출력하기 위해 stack 에 넣음
        }
        while(!stack.isEmpty()) { // 출력되지 않은 stack에 있는 문자들 모두 출력
            bw.write(stack.pollLast());
        }
        bw.flush();
        bw.close();
    }
}