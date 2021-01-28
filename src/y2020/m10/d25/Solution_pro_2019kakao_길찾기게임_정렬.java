package y2020.m10.d25;

import java.util.*;
/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_2019kakao_길찾기게임_정렬 {
	public static void main(String[] args) throws Exception {
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		System.out.println(Arrays.deepToString(solution(nodeinfo)));
	}

	public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        ArrayList<Node> al = new ArrayList<>();
        for(int i=0;i<nodeinfo.length;i++){
            Node temp = new Node(nodeinfo[i][0],nodeinfo[i][1],i+1);
            al.add(temp);
        }
        Collections.sort(al);
        
        Node root = al.get(0);
        for(int i=1;i<nodeinfo.length;i++){
            insertNode(root,al.get(i));
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans = preOrder(root,ans);
        for(int i=0;i<ans.size();i++){
            answer[0][i]=ans.get(i);
        }
        ans.clear();
        ans = postOrder(root,ans);
        for(int i=0;i<ans.size();i++){
            answer[1][i]=ans.get(i);
        }
        return answer;
        
    }
    public static ArrayList<Integer> postOrder(Node root, ArrayList<Integer> answer){
        if(root.left!=null){
            postOrder(root.left,answer);
        }
        if(root.right!=null){
            postOrder(root.right,answer);
        }
        answer.add(root.index);
        return answer;
    }
    public static ArrayList<Integer> preOrder(Node root, ArrayList<Integer> answer){
        answer.add(root.index);
        if(root.left!=null){
            preOrder(root.left,answer);
        }
        if(root.right!=null){
            preOrder(root.right,answer);
        }
        return answer;
    }
    
    public static void insertNode(Node root, Node n1){
        if(root.x>n1.x){
            if(root.left==null){
                root.left=n1;
            }else{
                insertNode(root.left, n1);
            }
        }else{
            if(root.right==null){
                root.right=n1;
            }else{
                insertNode(root.right, n1);
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
            return "Node [x=" + this.x + " y=" + this.y + " index=" + this.index + "]"; 
        }
    }
}
