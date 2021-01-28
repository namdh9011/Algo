package y2020.m07.d07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11401_이항계수3_남동해 {
	public static int N,K;
	public static long A,B;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_11401.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		long p = 1000000007;

        long[] factorial = new long[N+1];
        factorial[0] = 1;
        factorial[1] = 1;
        // factorial 구하기
        for(int i=2; i<=N; i++) factorial[i] = (factorial[i-1]*i)%p;
        long denominator = (factorial[K]*factorial[N-K])%p;

        // fermatNum(denominator의 K-2 제곱 구하기)
        long index = p-2;
        long fermatNum = 1;
        while(index > 0){
            if(index%2==1){
                fermatNum *= denominator;
                fermatNum %= p;
            }
            denominator = (denominator*denominator)%p;
            index /= 2;
        }
        long result = ((factorial[N]%p)*(fermatNum%p))%p;
        System.out.print(result);
	}
}
