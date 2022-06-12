import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110_공유기설치봉진님 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 1;
        int end = arr[n-1] - arr[0];

        int result = 0;

        while(start <= end){
            int mid = (start + end)/2;
            int left = arr[0];
            int count = 1;

            for(int i = 1; i < n; i++){
                if(arr[i] - left >= mid){
                    count++;
                    left = arr[i];
                }
            }

            if(count >= c){
                result = mid;
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }

        System.out.println(result);
    }
}