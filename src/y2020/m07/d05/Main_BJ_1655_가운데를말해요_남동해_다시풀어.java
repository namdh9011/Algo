package y2020.m07.d05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_BJ_1655_가운데를말해요_남동해_다시풀어 {
	public static int N;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_1655.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			pq.add(Integer.parseInt(br.readLine()));
			
		}
		
		
	}
}
