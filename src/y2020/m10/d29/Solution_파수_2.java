package y2020.m10.d29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/
/*
조건
- 숫자로만
- 13~15자리
- '-' 3개이하
- 맨앞이나 맨뒤에는 '-' 올 수 없음
- 같은 형식이 많은 것부터 출력
 */
public class Solution_파수_2 {
	public static void main(String[] args) throws Exception {
		String[] numbers = {"111-123-1154725","123-456-1248861","1576248651456","-184321-4832-4267","48-4-41-48-4111","15675123157895",
				"8752164-15723489","4572315-15753248","123-752-1725","482165-4515-","547-724-1287561","123-4xx-1123457","x1234578932415","11-121-1563-485215"};
		System.out.println(Arrays.toString(solution(numbers)));
	}
	
	public static int[] solution(String[] numbers) {
        HashMap<String, Integer> map = new HashMap<>();
        here : for(int num=0;num<numbers.length;num++) {
        	int[] type = new int[4];
        	int count=0;
        	int index=0;
        	String curr = numbers[num];
        	if(curr.charAt(0)=='-'||curr.charAt(curr.length()-1)=='-') {	//맨앞 맨뒤
        		continue;
        	}
        	for(int i=0;i<curr.length();i++) {
        		if(curr.charAt(i)>='0'&&curr.charAt(i)<='9') {
        			count++;
        		}else if(curr.charAt(i)=='-') {
        			if(index==3) {	// - 3개이하
        				continue here;
        			}
        			type[index]=count;
        			index++;
        		}else {	//0~9,- 가 아닌경우
        			continue here;
        		}
        	}
        	if(count<13||count>15) {	//숫자 개수 13~15
        		continue;
        	}
        	type[index]=count;
        	StringBuilder sb = new StringBuilder();
        	for(int i=0;i<type.length-1;i++) {
        		sb.append(type[i]).append('-');
        	}
        	sb.append(type[3]);
        	
        	if(map.get(sb.toString())==null) {
        		map.put(sb.toString(), 1);
        	}else {
        		map.put(sb.toString(), map.get(sb.toString())+1);
        	}
        }
        Set<String> keys = map.keySet();
        ArrayList<Integer> al = new ArrayList<>();
        for(String key:keys) {
        	al.add(map.get(key));
        }
        Collections.sort(al);
        int[] answer = new int[al.size()];
        for(int i=0;i<al.size();i++) {
        	answer[al.size()-i-1]=al.get(i);
        }
        return answer;
    }
}
