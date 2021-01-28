package y2021.m01.d06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
15
AFC
AAFC
AAAFFCC
AAFCC
BAFC
QWEDFGHJMNB
DFAFCB
ABCDEFC
DADC
SDFGHJKLQWERTYU
AAAAAAAAAAAAABBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCDDDDDDDDDDDEEEEEEEEEEEEEEEFFFFFFFFC
AAAFFFFFBBBBCCCAAAFFFF
ABCDEFAAAFFFCCCABCDEF
AFCP
AAFFCPP
*/

class Main_bj_9342_염색체_덜품 {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int N = Integer.parseInt(br.readLine());
    	here : for(int tc=0;tc<N;tc++) {
    		boolean result = false;
    		String input = br.readLine();
    		if(!('A'<=input.charAt(0)&&input.charAt(0)<='F')) {
    			sb.append("Good").append("\n");
    			continue;
    		}
//    		char[] check = {'A','F','C'};
    		if(input.charAt(0)=='A') {
    			int index = 1;
    			while(true) {
    				if(index==input.length()) {
    					sb.append("Good").append("\n");
    					continue here;
    				}
    				if(input.charAt(index)=='A') {
    					index++;
    				}else if(input.charAt(index)=='F') {
    					break;
    				}else {
    					sb.append("Good").append("\n");
    					continue here;
    				}
    			}
    			while(true) {
    				if(index==input.length()) {
    					sb.append("Good").append("\n");
    					continue here;
    				}
    				if(input.charAt(index)=='F') {
    					index++;
    				}else if(input.charAt(index)=='C') {
    					break;
    				}else {
    					sb.append("Good").append("\n");
    					continue here;
    				}
    			}
    			while(true) {
    				if(index==input.length()) {
    					break;
    				}
    				if(input.charAt(index)=='C') {
    					index++;
    				}else {
    					break;
    				}
    			}
    			if(index==input.length()) {
    				
    			}
    		}else {
    			if(input.charAt(1)=='A') {
    				int index = 2;
    				while(true) {
        				if(index==input.length()) {
        					sb.append("Good").append("\n");
        					continue here;
        				}
        				if(input.charAt(index)=='A') {
        					index++;
        				}else if(input.charAt(index)=='F') {
        					break;
        				}else {
        					sb.append("Good").append("\n");
        					continue here;
        				}
        			}
        			while(true) {
        				if(index==input.length()) {
        					sb.append("Good").append("\n");
        					continue here;
        				}
        				if(input.charAt(index)=='F') {
        					index++;
        				}else if(input.charAt(index)=='C') {
        					break;
        				}else {
        					sb.append("Good").append("\n");
        					continue here;
        				}
        			}
        			while(true) {
        				if(index==input.length()) {
        					break;
        				}
        				if(input.charAt(index)=='C') {
        					index++;
        				}else {
        					break;
        				}
        			}
        			
    			}
    		}
    		if(result) {
    			sb.append("Good").append("\n");
    		}else {
    			sb.append("Infected!").append("\n");
    		}
    	}
	}
}
