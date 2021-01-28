package y2020.m07.d17;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
풀이시간 : 42분
시간 : 80ms
메모리 : 12980KB

*/
public class Main_BJ_1063_킹_남동해 {
	public static int kingi,kingj, stonei,stonej,N,board[][],di[]= {0,0,1,-1,-1,-1,1,1},dj[]= {1,-1,0,0,1,-1,1,-1};
	public static String com[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_1063.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		board = new int[8][8];
		String s = st.nextToken();
		kingj = s.charAt(0)-'A';
		kingi = 7-(s.charAt(1)-'1');
		s = st.nextToken();
		stonej = s.charAt(0)-'A';
		stonei = 7-(s.charAt(1)-'1');
		N = Integer.parseInt(st.nextToken());
		com = new String[N];
		board[kingi][kingj]=1;
		board[stonei][stonej]=2;
		for(int i=0;i<N;i++) {
			move(br.readLine());
		}
		int a = kingj+'A';
		int b = 8 - kingi;
		System.out.println((char)a + "" + b);
		a = stonej+'A';
		b = 8 - stonei;
		System.out.println((char)a + "" + b);
	}
	private static void move(String c) {
		int dir=0;
		if(c.equals("R")) dir=0;
		else if(c.equals("L")) dir=1;
		else if(c.equals("B")) dir=2;
		else if(c.equals("T")) dir=3;
		else if(c.equals("RT")) dir=4;
		else if(c.equals("LT")) dir=5;
		else if(c.equals("RB")) dir=6;
		else if(c.equals("LB")) dir=7;
		
		int ni = kingi+di[dir];
		int nj = kingj+dj[dir];
		if(ni>=0&&nj>=0&&ni<8&&nj<8) {
			if(board[ni][nj]==0) {
				board[ni][nj]=1;
				board[kingi][kingj]=0;
				kingi=ni;
				kingj=nj;
			}else if(board[ni][nj]==2) {
				int nni=ni+di[dir];
				int nnj=nj+dj[dir];
				if(nni>=0&&nnj>=0&&nni<8&&nnj<8) {
					board[nni][nnj]=2;
					board[ni][nj]=1;
					board[kingi][kingj]=0;
					kingi=ni;
					kingj=nj;
					stonei=nni;
					stonej=nnj;
				}else {
					return;
				}
			}
		}
	}
}
