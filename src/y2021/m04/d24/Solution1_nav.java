package y2021.m04.d24;

public class Solution1_nav {
	public static void main(String[] args) {
		String m = "kkaxbycyz";
		String k = "abc";
		System.out.println(solution(m,k));
	}

	private static String solution(String m, String k) {
		int index = 0;
		int size = k.length();
		char tar = k.charAt(index);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m.length();i++) {
			if(m.charAt(i)!=tar) {
				sb.append(m.charAt(i));
			}else {
				index++;
				if(index>=size) {
					index=i;
					break;
				}
				tar=k.charAt(index);
			}
		}
		System.out.println(m.substring(index+1, m.length()));
		sb.append(m.substring(index+1, m.length()));
		return sb.toString();
	}
}
