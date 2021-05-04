package y2021.m05.d04;

public class Solution1_pro_단체사진찍기 {
	public static void main(String[] args) {
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
		System.out.println(solution(n, data));
	}
	public static int friendmap[], location[], cnt;
    public static boolean visit[];
    public static char mem[] = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    public static int solution(int n, String[] data) {
        int answer = 0;
        cnt=0;
        location = new int[8];
        friendmap = new int['Z'+1];
        for(int i=0;i<8;i++){
            friendmap[mem[i]]=i;
        }
        visit = new boolean[8];
        perm(0,n,data);
        answer = cnt;
        return answer;
    }
    public static void perm(int count, int n, String[] data){ 
        if(count==8){
            if(solve(n, data)){
                cnt++;
            }
            return;
        }
        for(int i=0;i<8;i++){
            if(!visit[i]){
                visit[i]=true;
                location[count]=i;
                perm(count+1, n, data);
                visit[i]=false;
            }
        }
    }
    public static boolean solve(int n, String[] data){
        for(int i=0;i<n;i++){
            int a = friendmap[data[i].charAt(0)];
            int b = friendmap[data[i].charAt(2)];
            char command = data[i].charAt(3);
            int count = data[i].charAt(4)-'0';
            int dis1 = 0;
            int dis2 = 0;
            for(int j=0;j<8;j++){
                if(location[j]==a){
                    dis1=j;
                }
                if(location[j]==b){
                    dis2=j;
                }
            }
            if(command=='='&&!(Math.abs(dis1-dis2)==count+1)){ 
                return false;
            }else if(command=='<'&&Math.abs(dis1-dis2)>=count+1){
                return false;
            }else if(command=='>'&&Math.abs(dis1-dis2)<=count+1){
                return false;  
            }
        }
        return true;
    }
}
