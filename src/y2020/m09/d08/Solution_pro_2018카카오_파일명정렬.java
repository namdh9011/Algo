package y2020.m09.d08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
- 

*/

public class Solution_pro_2018카카오_파일명정렬 {
	public static void main(String[] args) throws Exception {
		String[] files = {"img12.png", "img10", "img02.png", "img1.png", "IMG01.gif","img2.png"};
		System.out.println(Arrays.toString(solution(files)));
	}
	
	public static String[] solution(String[] files) {
        class File implements Comparable<File>{
        	String name;
        	String head;
        	int number;
        	String tail;
			public File(String name, String head, int number, String tail) {
				this.name = name;
				this.head = head;
				this.number = number;
				this.tail = tail;
			}
			@Override
			public String toString() {
				return "File [name=" + name + ", head=" + head + ", number=" + number + ", tail=" + tail + "]";
			}
			@Override
			public int compareTo(File o) {
				if(this.head.equals(o.head)) {
					return this.number-o.number;
				}else {
					return this.head.compareTo(o.head);
				}
			}
			
        }
		String[] answer = {};
		int N = files.length;
		String[] filename = new String[N];
		ArrayList<File> al = new ArrayList<>();
		for(int i=0;i<N;i++) {
			filename[i] = files[i].toUpperCase();
			here : for(int j=0;j<filename[i].length();j++) {
				if(filename[i].charAt(j)>='0'&&filename[i].charAt(j)<='9') {
					for(int k=j;k<filename[i].length();k++) {
						if(filename[i].charAt(k)<'0'||filename[i].charAt(k)>'9') {
							if(k+1<filename[i].length()&&filename[i].charAt(k+1)>='0'&&filename[i].charAt(k)<='9') {
								String he = filename[i].substring(0,j);
								int nu =Integer.parseInt(filename[i].substring(j,k));
								String ta = filename[i].substring(k,filename[i].length());
								al.add(new File(files[i], he, nu, ta));
								break here;
							}
						}else if(k+1==filename[i].length()) {
							String he = filename[i].substring(0,j);
							int nu =Integer.parseInt(filename[i].substring(j,k+1));
							al.add(new File(files[i], he, nu, ""));
							break here;
						}
					}
				}
			}
		}
		Collections.sort(al);
		answer = new String[al.size()];
		for(int i=0;i<N;i++) {
			answer[i] = al.get(i).name;
		}
        return answer;
    }
}
