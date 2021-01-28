package y2020.m10.d24;

import java.util.Scanner;
import java.util.Stack;

/*
2
B2(RG)
3(R2(GB))
 */
/*
3
3(BR2(R))
B(RGB(RG))
1B2R3G
 */
class Main_NHN_3_2번째테케틀림 {
  private static void solution(int numOfOrder, String[] orderArr) {
	  for(int tc=0;tc<numOfOrder;tc++) {
		  String input = orderArr[tc];
		  String s = dfs(input, 0, input.length());
		  System.out.println(s);
	  }
  }
  
  
  
  private static String dfs(String input, int start, int end) {
	  Stack<Character> stack = new Stack<>();
	  int[] se = new int[100];
	  int index=0;
	  String s = "";
	  boolean flag = false;
	  for(int i=start;i<end;i++) {
		  if(input.charAt(i)=='(') {
			  stack.add('(');
			  if(!flag) {
				  se[index]=i;
				  index++;
				  flag=true;
			  }
		  }else if(input.charAt(i)==')') {
			  stack.pop();
			  if(stack.size()==0) {
				  se[index]=i;
				  index++;
				  flag=false;
			  }
		  }
	  }
	  if(index==0) {
		  return input.substring(start,end);
	  }
	  se[index]=-1;
	  s+=input.substring(start,se[0]-1);
	  for(int i=0;i<se.length;i+=2) {
		  if(se[i]==-1) {
			  break;
		  }
		  int sta = se[i];
		  int en = se[i+1];
		  if(input.charAt(sta-1)>='1'&&input.charAt(sta-1)<='9') {
			  String temp = dfs(input,sta+1,en);
			  int co = input.charAt(sta-1)-'0';
			  for(int j=0;j<co;j++) {
				  s+=temp;
			  }
		  }else if(input.charAt(sta-1)=='R') {
			  String temp = dfs(input,sta+1,en);
			  for(int j=0;j<temp.length();j++) {
				  s += "R"+temp.charAt(j);
			  }
		  }else if(input.charAt(sta-1)=='G') {
			  String temp = dfs(input,sta+1,en);
			  for(int j=0;j<temp.length();j++) {
				  s += "G"+temp.charAt(j);
			  }
		  }else if(input.charAt(sta-1)=='B') {
			  String temp = dfs(input,sta+1,en);
			  for(int j=0;j<temp.length();j++) {
				  s += "B"+temp.charAt(j);
			  }
		  }
	  }
	  return s;
}



private static class InputData {
    int numOfOrder;
    String[] orderArr;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

      inputData.orderArr = new String[inputData.numOfOrder];
      for (int i = 0; i < inputData.numOfOrder; i++) {
        inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.numOfOrder, inputData.orderArr);
  }
}