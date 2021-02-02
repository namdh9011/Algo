package y2021.m02.d01;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class test {
	public static void main(String[] args){
		Pattern pattern = Pattern.compile("^[가-힣]*$"); //한글
		String val = "가나다라마바사"; //대상문자열
		
		Matcher matcher = pattern.matcher(val);
		System.out.println(matcher.find());
	}
}
