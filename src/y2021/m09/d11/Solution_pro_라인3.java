package y2021.m09.d11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution_pro_라인3 {
	public static void main(String[] args) {
//		int[][] jobs = {{1, 5, 2, 3}, {2, 2, 3, 2}, {3, 1, 3, 3}, {5, 2, 1, 5}, {7, 1, 1, 1}, {9, 1, 1, 1}, {10, 2, 2, 9}};
		int[][] jobs = {{0, 2, 3, 1}, {5, 3, 3, 1}, {10, 2, 4, 1}};
//		int[][] jobs = {{0, 5, 1, 1}, {2, 4, 3, 3}, {3, 4, 4, 5}, {5, 2, 3, 2}};
		System.out.println(Arrays.toString(solution(jobs)));
	}
	
	public static int[] solution(int[][] jobs) {
        ArrayList<Integer> temp = new ArrayList<>();
        int n = jobs.length;
        int num = jobs[0][2];
        int curtime = jobs[0][0]+jobs[0][1];
        temp.add(num);
        ArrayList<int[]> al = new ArrayList<>();		//0=분류번호, 1=시간, 2=중요도 배열
        for(int i=1;i<n;i++){
            //분류번호가 현재 분류번호와 같을 경우 - 시간 증가
            if(num == jobs[i][2]) {
            	curtime+=jobs[i][1];
            	continue;
            }
            
        	//분류번호가 현재 분류번호와 다를 경우
            if(jobs[i][0]<curtime){		//요청시간이 현재시간보다 작을경우 - 리스트
            	int len = al.size();
            	boolean flag = false;
            	for(int j=0;j<len;j++) {
            		int[] curr = al.get(j);
            		if(curr[0]==jobs[i][2]) {
            			al.add(new int[] {jobs[i][2], curr[1]+jobs[i][1], curr[2]+jobs[i][3]});
            			flag = true;
            			al.remove(j);
            			break;
            		}
            	}
            	if(!flag) {
            		al.add(new int[] {jobs[i][2], jobs[i][1], jobs[i][3]});
            	}
            }else{							//요청시간이 현재시간보다 크거나 같을 경우
            	if(jobs[i][0]==curtime) {
            		al.add(new int[] {jobs[i][2], jobs[i][1], jobs[i][3]});
            	}else {
            		i--;
            	}
            	
            	if(al.size()>0) {
                	Collections.sort(al, new Comparator<int[]>() {
                		@Override
                		public int compare(int[] o1, int[] o2) {
                			if(o1[2]>o2[2]) {
                				return o2[2]-o1[2];
                			}else if(o1[2]==o2[2]) {
                				return o1[0]-o2[0];
                			}
                			return -1;
                		}
                	});
                	int[] curr = al.get(0);
                	num = curr[0];
                	if(temp.get(temp.size()-1)!=num) {
                		temp.add(num);
                	}
                	curtime += curr[1];
                	al.remove(0);
                }else {
                	i++;
                	curtime = jobs[i][0]+jobs[i][1];
                	num = jobs[i][2];
                	if(temp.get(temp.size()-1)!=num) {
                		temp.add(num);
                	}
                }
            }
        }
        int len = al.size();
        for(int i=0;i<len;i++) {
        	Collections.sort(al, new Comparator<int[]>() {
        		@Override
        		public int compare(int[] o1, int[] o2) {
        			if(o1[2]>o2[2]) {
        				return o2[2]-o1[2];
        			}else if(o1[2]==o2[2]) {
        				return o1[0]-o2[0];
        			}
        			return -1;
        		}
        	});
        	if(temp.get(temp.size()-1)!=al.get(0)[0]) {
        		temp.add(al.get(0)[0]);
        	}
        }
        int[] answer = new int[temp.size()];
        for(int i=0;i<temp.size();i++) {
        	answer[i]=temp.get(i);
        }
        return answer;
    }
}
