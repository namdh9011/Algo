package y2021.m05.d21;

public class Main_solution_코테1 {
	public static void main(String[] args) {
		int money = 2308;
		int[] costs = {1000,500,20,99,10,5};
		System.out.println(solution(money, costs));
	}
	public static int coin[] = {500,100,50,10,5,1},min;
    public static int solution(int money, int[] costs) {
    	min = Integer.MAX_VALUE;
    	int answer = 0;
    	dfs(money, costs, 0,0,0,0);
    	System.out.println(min);
    	return answer;
    }
	private static void dfs(int money, int[] costs, int costsum, int moneysum,int premoney, int coincount) {
		if(min<costsum) {
			return;
		}
		if(moneysum>money) {
			int temp = money-(moneysum-premoney);
			int tar = temp*costs[5]+costsum;
			System.out.println(costsum + " " + moneysum + " " + tar + " " + min +" " + coincount + " " + money);
			if(tar<min) {
				min=tar;
			}
			return;
		}
		for(int i=0;i<5;i++) {
			if(costsum+costs[i]<min) {
				dfs(money, costs, costsum+costs[i],moneysum+coin[i],coin[i],coincount+1);
			}
		}
	}
}
