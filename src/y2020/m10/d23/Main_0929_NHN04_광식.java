package y2020.m10.d23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_0929_NHN04_광식 {
   static int n;
   static int[][] map;
   static boolean[][] visit;

   static void dfs(int x, int y, int profit, int fuel, String town) {
      fuel += 10;
      if (fuel < 0)
         return;
      if (y == n - 1) {
         profit += 100;
         System.out.println(town + profit + " " + fuel);
         return;
      }

      for (int i = 0; i < map[x].length; i++) {
         if (map[y][i] != 0) {
            visit[y][i] = true;
            fuel -= map[y][i];
            profit += 200;
            dfs(y, i, profit, fuel, town + (char) (i + 65) + " ");
            visit[y][i] = false;
            fuel += map[y][i];
            profit -= 200;
         }
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      int fuel = Integer.parseInt(st.nextToken());
      map = new int[n][n];
      visit = new boolean[n][n];
      int m = Integer.parseInt(br.readLine());
      for (int i = 0; i < m; i++) {
         st = new StringTokenizer(br.readLine());
         int from = (int) (st.nextToken().charAt(0) - 'A');
         int to = (int) (st.nextToken().charAt(0) - 'A');
         int cost = Integer.parseInt(st.nextToken());
         map[from][to] = cost;
      }
      for (int i = 1; i < n; i++) {
         if (map[0][i] != 0) {
            int profit = -100;
            dfs(0, i, profit, fuel - map[0][i], "A " + (char) (i + 65) + " ");
         }
      }
      System.out.println();
   }

}