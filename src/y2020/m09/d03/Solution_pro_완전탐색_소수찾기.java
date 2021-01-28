package y2020.m09.d03;


/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_완전탐색_소수찾기 {
	public static void main(String[] args) throws Exception {
		String numbers = "1234567";
		System.out.println(solution(numbers));
	}

	public static int N,K,a[],answer;
	public static String[] num;
	public static boolean v[],check[];
	public static int solution(String numbers) {
        answer = 0;
        N = numbers.length();
        int t = 1;
        for(int i=0;i<N;i++) {
        	t=t*10;
        }
        check = new boolean[t];
        num = new String[N];
        v = new boolean[N];
        for(int i=0;i<N;i++) {
        	num[i] = numbers.charAt(i)+"";
        }
        for(int i=1;i<=N;i++) {
        	K=i;
        	a = new int[K];
        	comb(0,0);
        }
        return answer;
    }

	private static void comb(int start, int count) {
		if(count==K) {
			String temp = "";
			for(int i=0;i<K;i++) {
				temp+=a[i];
			}
			int number = Integer.parseInt(temp);
			if(!check[number]&&primeCheck(number)){
				check[number]=true;
				answer++;
			}
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!v[i]) {
				v[i]=true;
				a[count]=Integer.parseInt(num[i]);
				comb(i,count+1);
				v[i]=false;
			}
		}
	}

	private static boolean primeCheck(int num) {
		if(num<2) {
			return false;
		}
		if(num!=2&&num%2==0) {
			return false;
		}
//		for(int i=2;i<num;i++) {	//느림
//			if(num%i==0) {
//				return false;
//			}
//		}
		for(int i=3;i<(int)Math.sqrt(num)+1;i+=2) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
}
