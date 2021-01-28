package y2020.m10.d23;

import java.util.*;
/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_2019kakao_길찾기게임 {
	public static void main(String[] args) throws Exception {
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		System.out.println(solution(nodeinfo));
	}

	public static int[][] solution(int[][] nodeinfo) {
		int[][] answer = new int[2][nodeinfo.length];
        List<Node> al = new ArrayList<>();
        for(int i=0;i<nodeinfo.length;i++){
            Node temp = new Node(nodeinfo[i][0], nodeinfo[i][1],i+1);
            al.add(temp);
        }
        Collections.sort(al);
        Node root = al.get(0);
        for(int i=1;i<al.size();i++) {
        	insertNode(root,al.get(i));
        }
        
        ArrayList<Integer> temp = new ArrayList<>();
        temp = preOrder(root,temp);
        for(int i=0;i<temp.size();i++) {
        	answer[0][i]=temp.get(i);
        }
        temp.clear();
        temp = postOrder(root,temp);
        for(int i=0;i<temp.size();i++) {
        	answer[1][i]=temp.get(i);
        }
        return answer;
	}
	
	public static ArrayList<Integer> preOrder(Node root,ArrayList<Integer> answer) {
		answer.add(root.index);
		if(root.left!=null) {
			answer = preOrder(root.left,answer);
		}
		if(root.right!=null) {
			answer = preOrder(root.right,answer);
		}
		return answer;
	}
	
	public static ArrayList<Integer> postOrder(Node root,ArrayList<Integer> answer) {
		if(root.left!=null) {
			postOrder(root.left,answer);
		}
		if(root.right!=null) {
			postOrder(root.right,answer);
		}
		answer.add(root.index);
		return answer;
	}
	
	public static void insertNode(Node root, Node curr) {
		if(root.x>curr.x) {
			if(root.left==null) {
				root.left = curr;
			}else {
				insertNode(root.left, curr);
			}
		}else {
			if(root.right==null) {
				root.right = curr;
			}else {
				insertNode(root.right, curr);
			}
		}
	}
	
	public static class Node implements Comparable<Node>{
        int x;
        int y;
        int index;
        Node left = null;
        Node right = null;
        public Node(int x, int y, int index){
            this.x = x;
            this.y = y;
            this.index = index;
        }
        
        @Override
        public int compareTo(Node n1){
            if(this.y==n1.y){
                return this.x-n1.x;
            }else{
                return n1.y-this.y;
            }
        }
        
        public String toString(){
            return "Node [x=" + x + " y=" + y + " index=" + index + "]";
        }
    }
}
