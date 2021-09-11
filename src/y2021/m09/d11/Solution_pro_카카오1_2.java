package y2021.m09.d11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution_pro_카카오1_2 {
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		System.out.println(Arrays.toString(solution(id_list, report,k)));
	}
	
	public static int[] solution(String[] id_list, String[] report, int k) {
        HashSet<String> set = new HashSet<>();							//중복 제거
        HashMap<String, Integer> cnt = new HashMap<>();					//key가 신고당한횟수
        HashMap<String, ArrayList<String>> member = new HashMap<>();	//key를 신고한사람
        HashSet<String> stop = new HashSet<>();							//정지당한 사람
        for(int i=0;i<report.length;i++) {
        	set.add(report[i]);
        }
        
        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
        	String[] curr = it.next().split(" ");
        	String bad = curr[1];
        	String repoter = curr[0];
        	if(cnt.get(bad)==null) {
        		cnt.put(bad, 1);
        	}else {
        		int temp = cnt.get(bad)+1;
        		cnt.put(bad, temp);
        	}
        	if(member.get(bad)==null) {
        		ArrayList<String> al = new ArrayList<>();
        		al.add(repoter);
        		member.put(bad, al);
        	}else {
        		ArrayList<String> al = member.get(bad);
        		al.add(repoter);
        		member.put(bad, al);
        	}
        }
        
        Set<String> keyset = cnt.keySet();
        for(String key: keyset) {
        	if(cnt.get(key)>=k) {
        		stop.add(key);
        	}
        }
        
        HashMap<String, Integer> ret = new HashMap<>();				//key가 받는 메일수
        it = stop.iterator();
        while(it.hasNext()) {
        	String bad = it.next();
        	ArrayList<String> curr = member.get(bad);
        	int len = curr.size();
        	for(int i=0;i<len;i++) {
        		String mail = curr.get(i);
        		if(ret.get(mail)==null) {
        			ret.put(mail,1);
        		}else {
        			ret.put(mail, ret.get(mail)+1);
        		}
        	}
        }
        
        int idlen = id_list.length;
        int[] answer = new int[idlen];
        for(int i=0;i<idlen;i++) {
        	String repoter = id_list[i];
        	if(ret.get(repoter)!=null) {
        		answer[i]=ret.get(repoter);
        	}
        }
        return answer;
    }
}
