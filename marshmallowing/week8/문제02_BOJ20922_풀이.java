import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr=new int[100001];
		int[] deleteArr=new int[n];

		int length=0;
		int maxLength=0;
		int deletePosition=0;

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int x=Integer.parseInt(st.nextToken());
			deleteArr[i]=x;
			arr[x]++;
			if(arr[x]<=k){
				length++;
			}else{
				if(length>maxLength){
					maxLength=length;
				}
				for(int j=deletePosition; j<=i; j++){
					arr[deleteArr[j]]--;
					if(deleteArr[j]==x){
						deletePosition=j+1;
						break;
					}
					length--;
				}
			}
		}

		if(length>maxLength){
			maxLength=length;
		}

		bw.write(String.valueOf(maxLength));

		bw.flush();
		bw.close();
		br.close();
	}
}