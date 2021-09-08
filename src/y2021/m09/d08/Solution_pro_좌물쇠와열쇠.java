package y2021.m09.d08;

public class Solution_pro_좌물쇠와열쇠 {
	public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		System.out.println(solution(key, lock));
	}
	
	public static boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        int mapNM = N+(M-1)*2;
        int[][] map = new int[mapNM][mapNM];
        
        //init
        for(int i=0;i<mapNM;i++){
            for(int j=0;j<mapNM;j++){
                map[i][j]=2;
            }
        }
        int sn = M-1;
        int en = sn+N;
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[sn+i][sn+j]=lock[i][j];
                if(lock[i][j]==0) count++;
            }
        }
        
        //solve
        for(int spin=0;spin<4;spin++){
            for(int i=0;i<en;i++){
                for(int j=0;j<en;j++){
                    if(check(map,key,i,j,M,count)){
                        return true;
                    }
                }
            }
            key = spinKey(key);
        }
        return false;
    }
    
    public static boolean check(int[][] map, int[][] key, int si, int sj, int M, int count){
        int temp = 0;
        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                if(key[i][j]==1&&map[si+i][sj+j]==1){
                    return false;
                }
                if(key[i][j]==1&&map[si+i][sj+j]==0){
                    temp++;
                }
                
            }
        }
        if(temp==count){
            return true;
        }
        return false;
    }
    
    public static int[][] spinKey(int[][] key){
        int N = key.length;
        int[][] tempkey = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                tempkey[i][j]=key[N-j-1][i];
            }
        }
        return tempkey;
    }
}
