package y2021.m05.d29;

import java.util.HashSet;

public class Solution_brute_소수찾기 {
	public static void main(String[] args) {
		String numbers = "011";
		System.out.println(solution(numbers));
	}
	public static boolean eratos[], visit[];
    public static HashSet<Integer> set;
    public static int tar[], answer;
    public static int solution(String numbers) {
        answer = 0;
        int n = numbers.length();
        int max_num = 1;
        for(int i=0;i<n;i++){
            max_num*=10;
        }
        eratos = new boolean[max_num];
        era(max_num);
        set = new HashSet<>();
        for(int i=1;i<=n;i++){
            visit = new boolean[n];
            tar = new int[i];
            comb(i,n,0,numbers);
        }
        return answer;
    }
    public static void comb(int k, int n, int count,String numbers){
        if(count==k){
            int a = tran();
            if(!eratos[a]){
                eratos[a]=true;
                answer++;
            }
            return;
        }
        for(int i=0;i<n;i++){
            if(!visit[i]){
                visit[i]=true;
                tar[count]=numbers.charAt(i)-'0';
                comb(k,n,count+1,numbers);
                visit[i]=false;
            }
        }
    }
    public static int tran(){
        int n = tar.length;
        int ret = 0;
        for(int i=0;i<n;i++){
            ret=ret*10+tar[i];
        }
        return ret;
    }
    public static void era(int n){
        eratos[0]=eratos[1]=true;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(eratos[i]){
                continue;
            }
            for(int j=i*i;j<n;j+=i){
                eratos[j]=true;
            }
        }
    }
}

