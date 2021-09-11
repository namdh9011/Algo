package y2021.m09.d11;

public class Solution_pro_카카오2 {
	public static void main(String[] args) {
		int n = 1000000;
		int k = 3;
		System.out.println(solution(n,k));
	}
	
	public static int solution(int n, int k) {
        int answer = 0;
        String num = change(n,k);				//진수변환
        String[] split = num.split("0");
        int len = split.length;
        for(int i=0;i<len;i++) {
        	if(split[i].equals("")) continue;
        	Long temp = Long.parseLong(split[i]);
        	if(check(temp)) {
        		answer++;
        	}
        }
        return answer;
    }
	
	private static boolean check(Long num) {
		if(num==1) {
			return false;
		}
		for(int i=2;i<=(long)Math.sqrt(num);i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}

	public static String change(int n, int k){
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.append(n%k);
            n/=k;
        }
        sb = sb.reverse();
        return sb.toString();
    }
}
