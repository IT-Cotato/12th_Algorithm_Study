package kingmingyu.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 문제1_BOJ17413_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        String str = br.readLine();

        boolean intag = false;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '<'){
                answer.append(sb.reverse());
                sb.setLength(0);

                answer.append(str.charAt(i));
                intag = true;
            }
            else if(str.charAt(i) == '>'){
                answer.append(str.charAt(i));
                intag = false;
            }
            else if(intag){
                answer.append(str.charAt(i));
            }
            else if(str.charAt(i) == ' '){
                answer.append(sb.reverse()).append(" ");
                sb.setLength(0);
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        answer.append(sb.reverse());
        System.out.println(answer);
    }
}
