package y2020.m08.d27;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
풀이시간 : 137분
시간 : 140ms
메모리 : 18232KB
- smell맵에 상어가 이동할때마다 숫자를 늘려주고 현재 이동시간에서 맵에 표시된 시간을 뻇을때 그 값이 k보다 크면 이동시켜줌.
- 자신의 영역으로 되돌아갈 경우를 위해서 나중에 my배열을 추가 함.
*/

public class Main_BJ_19237_어른상어_남동해 {
	public static int N,M,k,map[][],di[]= {0,-1,1,0,0},dj[]= {0,0,0,-1,1},shark[][],pr[][][],smell[][],smelltime,my[][];
	public static ArrayList<Integer[]> al;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_BJ_19237.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[N][N];		//상어 현재 위치
		my = new int[N][N];			//자기 영역 표시
		smell = new int[N][N];		//냄새 시간 표시
		smelltime = 1;
		shark = new int[M+1][3];	//x,y,방향
		pr = new int[M+1][4][4];	//이동 우선 순위
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]!=0) {
					smell[i][j]=smelltime;
					shark[map[i][j]][0]=i;
					shark[map[i][j]][1]=j;
					my[i][j]=map[i][j];
				}
			}
		}
		smelltime++;
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<M+1;i++) {
			shark[i][2]=Integer.parseInt(st.nextToken());
		}
		
		//이동 우선순위 입력
		for(int i=1;i<M+1;i++) {
			for(int j=0;j<4;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<4;k++) {
					pr[i][j][k]=Integer.parseInt(st.nextToken());
				}
			}
		}
		
		boolean flag=false;			//1000초 이상
		for(int m=0;m<1000;m++) {
			for(int i=1;i<M+1;i++) {
				if(shark[i][2]!=-1) {	//상어가 제거되면 방향을 -1로 해줌
					moveShark(i);
				}
			}
			//맵을 비워줌
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=0;
				}
			}
			int count=0;	//상어가 몇 마리 남았는지 카운트
			for(int i=1;i<M+1;i++) {	//상어 위치가 비어있으면 상어 위치를 표시해주고
				if(shark[i][2]!=-1&&map[shark[i][0]][shark[i][1]]==0) {
					count++;
					my[shark[i][0]][shark[i][1]]=i;
					map[shark[i][0]][shark[i][1]]=i;
					smell[shark[i][0]][shark[i][1]]=smelltime;
				}else {					//상어 위치에 이미 이전 상어가 있으면
					shark[i][2]=-1;		//상어 제거
				}
			}
			if(count==1) {	//상어가 한마리 남으면 시간 출력하고 탈출
				flag=true;
				System.out.println(smelltime-1);
				break;
			}
			smelltime++;
		}
		if(!flag) {
			System.out.println(-1);
		}
		
	}
	private static void moveShark(int num) {
		//맵이 비어있거나 냄새가 없거나 냄새가 지워졌을때 상어 이동 표시
		for(int i=0;i<4;i++) {
			int dir = pr[num][shark[num][2]-1][i];
			int ni = shark[num][0] + di[dir];
			int nj = shark[num][1] + dj[dir];
			if(ni>=0&&nj>=0&&ni<N&&nj<N&&map[ni][nj]==0&&(smell[ni][nj]==0||smelltime-smell[ni][nj]>k)) {
				shark[num][0]=ni;
				shark[num][1]=nj;
				shark[num][2]=dir;
				return;
			}
		}
		
		//자신의 영역으로 되돌아갈 경우
		for(int i=0;i<4;i++) {
			int dir = pr[num][shark[num][2]-1][i];
			int ni = shark[num][0] + di[dir];
			int nj = shark[num][1] + dj[dir];
			if(ni>=0&&nj>=0&&ni<N&&nj<N&&my[ni][nj]==num) {
				shark[num][0]=ni;
				shark[num][1]=nj;
				shark[num][2]=dir;
				return;
			}
		}
	}
}
