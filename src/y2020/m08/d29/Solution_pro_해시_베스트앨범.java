package y2020.m08.d29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_해시_베스트앨범 {
	public static void main(String[] args) throws Exception {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500,600,150,800,2500};
		
		System.out.println(Arrays.toString(solution(genres, plays)));
	}
	public static int[] solution(String[] genres, int[] plays) {
		class Music implements Comparable<Music>{
			String gen;
			int plays;
			public Music(String gen, int plays) {
				this.gen = gen;
				this.plays = plays;
			}
			@Override
			public int compareTo(Music o) {
				return o.plays - this.plays;
			}
			@Override
			public String toString() {
				return "Music [gen=" + gen + ", plays=" + plays + "]";
			}
		}
		int[] answer = {};
		int count=0;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer[][]> bmap = new HashMap<>();
        for(int i=0;i<genres.length;i++) {
        	if(map.get(genres[i])==null) {
        		map.put(genres[i], plays[i]);
        		Integer[][] temp = new Integer[2][2];
        		temp[0][0] = i;
        		temp[0][1] = plays[i];
        		temp[1][0] = -1;
        		temp[1][1] = -1;
        		bmap.put(genres[i], temp);
        		count++;
        	}else{
        		map.put(genres[i], map.get(genres[i])+plays[i]);
        		Integer[][] temp = bmap.get(genres[i]);
        		if(temp[0][1]<plays[i]) {
        			int a = temp[0][0];
        			int b = temp[0][1];
        			if(temp[1][0]==-1) {
        				count++;
        			}
        			temp[1][0] = a;
        			temp[1][1] = b;
        			temp[0][0] = i;
        			temp[0][1] = plays[i];
        		}else if(temp[0][1]>=plays[i]&&temp[1][1]<plays[i]) {
        			if(temp[1][0]==-1) {
        				count++;
        			}
        			temp[1][0] = i;
        			temp[1][1] = plays[i];
        		}else {
        			
        		}
        		bmap.put(genres[i], temp);
        	}
        }
        ArrayList<Music> ar = new ArrayList<>();
        
        for(String s : map.keySet()) {
        	int a = map.get(s);
        	ar.add(new Music(s, a));
        }
        Collections.sort(ar);
        int result[] = new int[count];
        int a=0;
        for(int i=0;i<ar.size();i++) {
        	Integer[][] temp = bmap.get(ar.get(i).gen);
        	result[a]=temp[0][0];
        	a++;
        	if(temp[1][1]!=-1) {
        		result[a]=temp[1][0];
        		a++;
        	}
        }
        answer = result;
        return answer;
    }
}
