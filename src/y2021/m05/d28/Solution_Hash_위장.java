package y2021.m05.d28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution_Hash_위장 {
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		System.out.println(Arrays.toString(solution(genres,plays)));
	}
	public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> sum = new HashMap<>();
        HashMap<String, PriorityQueue<int[]>> musics = new HashMap<>();
        int n = genres.length;
        for(int i=0;i<n;i++){
            String genre = genres[i];
            int play = plays[i];
            if(sum.get(genre)==null){
                sum.put(genre,play);
                PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
                    public int compare(int[] o1, int[] o2){
                        if(o1[1]==o2[1]){
                            return o1[0]-o2[0];
                        }
                        return o2[1]-o1[1];
                    }
                });
                pq.add(new int[] {i,plays[i]});
                musics.put(genre,pq);
            }else{
                sum.put(genre,sum.get(genre)+play);
                PriorityQueue<int[]> pq = musics.get(genre);
                pq.add(new int[] {i,plays[i]});
                musics.put(genre,pq);
            }
        }
        int size = sum.size();
        int[][] data = new int[size][2];
        String[] gen = new String[size];
        int index = 0;
        for(String s:sum.keySet()){
            data[index][0]=index;
            data[index][1]=sum.get(s);
            gen[index++]=s;
        }
        Arrays.sort(data,new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o2[1]-o1[1];
            }
        });
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<data.length;i++){
            String curr = gen[data[i][0]];
            PriorityQueue<int[]> pq = musics.get(curr);
            int[] cu = pq.poll();
            al.add(cu[0]);
            if(pq.size()>0){
                cu = pq.poll();
                al.add(cu[0]);
            }
        }
        int[] answer = new int[al.size()];
        for(int i=0;i<al.size();i++){
            answer[i]=al.get(i);
        }
        return answer;
    }
}

