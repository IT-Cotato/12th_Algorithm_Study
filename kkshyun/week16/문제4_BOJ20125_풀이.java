import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        boolean findHead = false;
        int heartX = 0;
        int heartY = 0;
        int leftArm = 0;
        int rightArm = 0;
        int waist = 0;
        int leftLeg = 0;
        int rightLeg = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if(!findHead) {
                    if(s.charAt(j) =='*') {
                        findHead = true;
                        heartX = i+1;
                        heartY = j;
                        sb.append(heartX+1).append(" ").append(heartY+1).append("\n");
                        break;
                    }
                } else {
                    if(s.charAt(j) !='*')
                        continue;
                    if(i == heartX && j < heartY)
                        leftArm++;
                    else if(i == heartX && j > heartY)
                        rightArm++;
                    else if(i > heartX && j == heartY)
                        waist++;
                    else if(i > heartX && j < heartY)
                        leftLeg++;
                    else if(i > heartX && j > heartY)
                        rightLeg++;
                }
            }
        }
        sb.append(leftArm).append(" ").append(rightArm).append(" ").append(waist).append(" ").append(leftLeg).append(" ").append(rightLeg);
        System.out.println(sb);
    }
}