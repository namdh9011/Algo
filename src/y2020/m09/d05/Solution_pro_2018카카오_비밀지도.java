package y2020.m09.d05;

import java.util.Arrays;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/
public class Solution_pro_2018카카오_비밀지도 {
	public static void main(String[] args) throws Exception {
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		System.out.println(Arrays.toString(solution(n,arr1,arr2)));
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] temp1 = new String[n];
        String[] temp2 = new String[n];
        
        for(int i=0;i<n;i++) {
        	temp1[i] = Integer.toBinaryString(arr1[i]);
        	int t = temp1[i].length();
        	if(t<n) {
        		for(int j=0;j<n-t;j++) {
        			temp1[i]="0"+temp1[i];
        		}
        	}
        	temp2[i] = Integer.toBinaryString(arr2[i]);
        	t = temp2[i].length();
        	if(t<n) {
        		for(int j=0;j<n-t;j++) {
        			temp2[i]="0"+temp2[i];
        		}
        	}
        }
        for(int i=0;i<n;i++) {
        	answer[i] = change(temp1[i],temp2[i]);
        }
        
        return answer;
    }

	private static String change(String string, String string2) {
		int n = string.length();
		String result = "";
		for(int i=0;i<n;i++) {
			if(string.charAt(i)=='0'&&string2.charAt(i)=='0') {
				result = result+" ";
			}else {
				result = result+"#";
			}
		}
		return result;
	}
}
