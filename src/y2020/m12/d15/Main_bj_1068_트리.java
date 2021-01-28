package y2020.m12.d15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
5
-1 0 0 1 1
2
 */

class Main_bj_1068_트리 {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] data = new int[N];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		data[i] = Integer.parseInt(st.nextToken());
    	}
    	int remove = Integer.parseInt(br.readLine());
    	Node root = new Node(0,new ArrayList<>());
    	for(int i=1;i<N;i++) {
    		
    	}
    }
    
    public static class Node{
    	int num;
    	ArrayList<Node> al;
		public Node(int num, ArrayList<Node> al) {
			this.num = num;
			this.al = al;
		}
    }
}
