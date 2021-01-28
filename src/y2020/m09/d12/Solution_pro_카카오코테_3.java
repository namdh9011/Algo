package y2020.m09.d12;

import java.util.Arrays;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
- 

*/

public class Solution_pro_카카오코테_3 {
	public static void main(String[] args) throws Exception {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		System.out.println(Arrays.toString(solution(info,query)));
	}
	
	public static int[] solution(String[] info, String[] query) {
        int[][] table = new int[info.length][5];
        //java 0 python 1 cpp 2 back 0 front 1 jun 0 sen 1 pizza 0 chi 1
        for(int i=0;i<info.length;i++) {
        	String[] temp = info[i].split(" ");
    		if(temp[0].equals("java")) {
    			table[i][0]=0;
    		}else if(temp[0].equals("python")) {
    			table[i][0]=1;
    		}else {
    			table[i][0]=2;
    		}
    		if(temp[1].equals("backend")){
    			table[i][1]=0;
    		}else {
    			table[i][1]=1;
    		}
    		if(temp[2].equals("junior")){
    			table[i][2]=0;
    		}else {
    			table[i][2]=1;
    		}
    		if(temp[3].equals("pizza")){
    			table[i][3]=0;
    		}else {
    			table[i][3]=1;
    		}
    		table[i][4]=Integer.parseInt(temp[4]);
        }
        Arrays.sort(table,(o1,o2)->o2[4]-o1[4]);
        
        int[] answer = new int[query.length];
        int[][] q_table = new int[query.length][5];
        for(int i=0;i<query.length;i++) {
        	query[i] = query[i].replace(" and ", " ");
        	String[] temp = query[i].split(" ");
        	if(temp[0].equals("java")) {
    			q_table[i][0]=0;
    		}else if(temp[0].equals("python")) {
    			q_table[i][0]=1;
    		}else if(temp[0].equals("-")){
    			q_table[i][0]=9;
    		}else {
    			q_table[i][0]=2;
    		}
    		if(temp[1].equals("backend")){
    			q_table[i][1]=0;
    		}else if(temp[1].equals("-")){
    			q_table[i][1]=9;
    		}else {
    			q_table[i][1]=1;
    		}
    		if(temp[2].equals("junior")){
    			q_table[i][2]=0;
    		}else if(temp[2].equals("-")){
    			q_table[i][2]=9;
    		}else {
    			q_table[i][2]=1;
    		}
    		if(temp[3].equals("pizza")){
    			q_table[i][3]=0;
    		}else if(temp[3].equals("-")){
    			q_table[i][3]=9;
    		}else {
    			q_table[i][3]=1;
    		}
    		q_table[i][4]=Integer.parseInt(temp[4]);
        }
        for(int i=0;i<q_table.length;i++) {
        	for(int j=0;j<table.length;j++) {
        		if((q_table[i][0]==9||table[j][0]==q_table[i][0])&&(q_table[i][1]==9||table[j][1]==q_table[i][1])&&(q_table[i][2]==9||table[j][2]==q_table[i][2])&&(q_table[i][3]==9||table[j][3]==q_table[i][3])) {
        			if(q_table[i][4]<=table[j][4]) {
        				answer[i]++;
        			}else {
        				break;
        			}
        		}
        	}
        }
        return answer;
    }
}
