package y2021.m05.d06;

import java.util.ArrayList;
import java.util.Stack;

public class Solution_pro_수식최대화 {
	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		System.out.println(solution(expression));
	}
	public static String[] command = {"+-*","+*-","-*+","-+*","*+-","*-+"};
    public static ArrayList<Long> initnum;
    public static ArrayList<Character> initexp;
    public static long solution(String expression) {
        long answer = 0;
        initnum = new ArrayList<>();
        initexp = new ArrayList<>();
        init(expression);
        for(int i=0;i<6;i++){
            answer = Math.max(Math.abs(sol(command[i])), answer);
        }
        return answer;
    }
    public static void init(String expression){
        String s = "";
        for(int i=0;i<expression.length();i++){
            char curr = expression.charAt(i);
            if(curr=='+'||curr=='-'||curr=='*'){
                initnum.add(Long.parseLong(s));
                s="";
                initexp.add(curr);
            }else{
                s+=curr;
            }
        }
        initnum.add(Long.parseLong(s));
    }
    public static long sol(String comline){
        Stack<Long> num = new Stack<>();
        Stack<Character> exp = new Stack<>();
        Stack<Long> revnum = new Stack<>();
        Stack<Character> revexp = new Stack<>();
        num.add(initnum.get(0));
        for(int i=0;i<initnum.size()-1;i++){
            num.add(initnum.get(i+1));
            exp.add(initexp.get(i));
        }
        for(int k=0;k<3;k++){
            char com = comline.charAt(k);
            while(!num.isEmpty()){
                long t = num.pop();
                revnum.add(t);
            }
            while(!exp.isEmpty()){
                char t = exp.pop();
                revexp.add(t);
            }
            num.add(revnum.pop());
            int n = revexp.size();
            for(int i=0;i<n;i++){
                char e = revexp.pop();
                Long curr = revnum.pop();
                if(com==e){
                    long temp = cal(e, num.pop(), curr);
                    num.add(temp);
                }else{
                    num.add(curr);
                    exp.add(e);
                }
            }
        }
        return num.pop();
    }
    public static long cal(char com, long a, long b){
        if(com=='+'){
            return a+b;
        }else if(com=='-'){
            return a-b;
        }else{
            return a*b;
        }
    }
}
