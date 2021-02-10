package y2021.m02.d10;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_pro_후보키_틀린풀이 {
	public static void main(String[] args) throws Exception {
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		System.out.println(solution(relation));
	}
	public static int a[], answer, b[][],c;
	public static boolean visit[];
	public static int solution(String[][] relation) {
        answer = 0;
        int N = relation.length;
        int M = relation[0].length;
        b = new int[N*N][M+1];
        a = new int[M];
        c = 0;
        visit = new boolean[M];
        dfs(relation,0,N,M);
        Arrays.sort(b, (o1,o2)-> o1[M]-o2[M]);
        for(int i=0;i<b.length;i++) {
        	boolean flag = checkTuple(i,N,M,relation);
        	if(!flag) {
        		answer++;
        	}
        }
        return answer;
    }

	private static void dfs(String[][] relation,int count,int N,int M) {
		if(count==M) {
			for(int i=0;i<M;i++) {
				if(a[i]==1) {
					b[c][i]=1;
					b[c][M]++;
				}
			}
			c++;
			return;
		}
		a[count]=1;
		dfs(relation,count+1,N,M);
		a[count]=0;
		dfs(relation,count+1,N,M);
	}

	private static boolean checkTuple(int c,int N,int M, String[][] relation) {
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			String temp = "";
			for(int j=0;j<M;j++) {
				if(!visit[j]&&b[c][j]==1) {
					temp+=relation[i][j];
				}
			}
			if(temp.equals("")) {
				return true;
			}else if(map.get(temp)==null) {
				map.put(temp, 1);
			}else {
				return true;
			}
		}
		for(int i=0;i<M;i++) {
			if(b[c][i]==1) {
				visit[i]=true;
			}
		}
		return false;
	}
}
