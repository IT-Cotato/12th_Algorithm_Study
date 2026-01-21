package kingmingyu.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문제1_BOJ1541_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String calc = br.readLine();

        String[] calcIdx = calc.split("-");

        int[] nums = new int[51];

        boolean flag = false;
        for(int i = 0; i < calcIdx.length; i++){
            if(i == 0 && calcIdx[i].isEmpty())
                flag = true;
            try{
                nums[i] = Integer.parseInt(calcIdx[i]);
            }
            catch (Exception e){
                String[] temp = calcIdx[i].split("\\+");
                int sum = 0;
                for(int j = 0; j < temp.length; j++){
                    sum += Integer.parseInt(temp[j]);
                }
                nums[i] = sum;
            }
        }

        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                if(flag == true){
                    sum -= nums[i];
                }
                else{
                    sum += nums[i];
                }
            }
            else{
                sum -= nums[i];
            }
        }

        System.out.println(sum);
    }
}
