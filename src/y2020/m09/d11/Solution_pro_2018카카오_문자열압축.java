package y2020.m09.d11;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
- 

*/

public class Solution_pro_2018카카오_문자열압축 {
	public static void main(String[] args) throws Exception {
		String s = "xababcdcdababcdcd";
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
        int answer = 1001;
        String[] temp = new String[s.length()/2+1];
        for(int i=1;i<s.length()/2+1;i++) {
        	int count=1;
        	for(int j=0;j<s.length();j=j+i) {
        		if(j+i*2>s.length()) {
        			if(count==1) {
        				if(temp[i]==null) {
        					temp[i]=s.substring(j,s.length());
        				}else {
        					temp[i]+=s.substring(j,s.length());
        				}
        			}else {
        				if(temp[i]==null) {
        					temp[i]=Integer.toString(count) + s.substring(j,s.length());
        				}else {
        					temp[i]+=Integer.toString(count) + s.substring(j,s.length());
        				}
        			}
        			break;
        		}
        		String curr = s.substring(j,j+i);
        		String next = s.substring(j+i,j+i*2);
        		if(curr.equals(next)) {
        			count++;
        		}else {
        			if(count==1) {
        				if(temp[i]==null) {
        					temp[i]=curr;
        				}else {
        					temp[i]+=curr;
        				}
        			}else {
        				if(temp[i]==null) {
        					temp[i]=Integer.toString(count) + curr;
        				}else {
        					temp[i]+=Integer.toString(count) + curr;
        				}
        				count=1;
        			}
        		}
        	}
        }
        for(int i=1;i<temp.length;i++) {
        	if(temp[i].length()<answer) {
        		answer = temp[i].length();
        	}
        }
        if(s.length()==1) {
        	answer=1;
        }
        return answer;
    }
}
