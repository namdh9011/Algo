package y2020.m07.d03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2573_빙산_남동해 {
	public static int di[] = {-1,0,1,0}, dj[] = {0,1,0,-1};
	public static int N,M,Iceberg[][],t_Iceberg[][],result;
	public static boolean v_Iceberg[][];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_BJ_2573.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Iceberg = new int[N][M];
		t_Iceberg = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				Iceberg[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		result=1;
		here:while(true) {
			tmap();
			initmap();
			
			boolean flag = false;
			v_Iceberg = new boolean[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(Iceberg[i][j]!=0 && !v_Iceberg[i][j]) {
						if(flag==true) {
							break here;
						}
						flag=true;
						dfs(i,j);
					}
				}
			}
			if(!flag) {
				result=0;
				break here;
			}
			result++;
		}
		System.out.println(result);
	}
	
	private static void dfs(int i, int j) {
		for(int d=0;d<4;d++) {
			v_Iceberg[i][j]=true;
			int ni = i + di[d];
			int nj = j + dj[d];
			if(Iceberg[ni][nj]!=0 && !v_Iceberg[ni][nj]) {
				dfs(ni,nj);
			}
		}
	}
	
	private static void initmap() {
		for(int i=0;i<N;i++) {
			Iceberg[i]=t_Iceberg[i].clone();
		}
	}
	
	private static void tmap() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int temp=Iceberg[i][j];
				if(Iceberg[i][j]!=0) {
					for(int d=0;d<4;d++) {
						int ni = i + di[d];
						int nj = j + dj[d];
						if(Iceberg[ni][nj]==0) {
							temp--;
						}
					}
				}
				if(temp<0) {
					temp=0;
				}
				t_Iceberg[i][j]=temp;
			}
		}
	}
}
