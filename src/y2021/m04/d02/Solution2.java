package y2021.m04.d02;

//git 설정 변경
public class Solution2 {

	public static void main(String[] args) {
		System.out.println(solution(19,3,4,2));
	}
	public static long solution(long N, long K, long A, long B) {
        long answer = 0;
        if(K==1) {
        	answer=(N-1)*A;
        }else {
        	while(N>1) {
        		if(N<K) {
        			answer+=(N-1)*A;
        			break;
        		}
        		if(N%K==0) {
        			long dif = N-N/K;
        			if(dif*A<B) {
        				answer+=dif*A;
        			}else {
        				answer+=B;
        			}
        			N/=K;
        		}else {
        			long dif = N-(N/K)*K;
        			answer+=dif*A;
        			N=N-dif;
        		}
        	}
        }
        return answer;
    }
}
