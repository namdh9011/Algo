package y2020.m10.d23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_0929_NHN03_광식 {
   static int[] candy;
   static ArrayList<Integer>[] follower;
   static boolean[] get;

   static void goFollower(int idx) {
      if (follower[idx].isEmpty())
         return;
      else {
         for (int i = 0; i < follower[idx].size(); i++) {
            int follow = follower[idx].get(i);
            if (!get[follow]) {
               candy[follow]++;
               get[follow] = true;
               goFollower(follow);
            }
         }
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      int n = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      candy = new int[n];
      follower = new ArrayList[n];
      get = new boolean[n];
      for (int i = 0; i < n; i++) {
         follower[i] = new ArrayList<>();
      }
      int idx = 0;
      while (st.hasMoreTokens()) {
         String cmd = st.nextToken();
         int playerNum = idx % n;
         switch (cmd) {
         case "A":
            candy[playerNum]++;
            goFollower(playerNum);
            Arrays.fill(get, false);
            break;
         case "J":
            candy[(playerNum + 1) % 5]++;
            goFollower((playerNum + 1) % 5);
            Arrays.fill(get, false);
            if (playerNum - 1 < 0) {
               candy[n - 1]++;
               goFollower(n - 1);
               Arrays.fill(get, false);
            } else {
               candy[playerNum - 1]++;
               goFollower(playerNum - 1);
               Arrays.fill(get, false);
            }
            Arrays.fill(get, false);
            break;
         case "Q":
            for (int i = 0; i < candy.length; i++) {
               candy[i]++;
            }
            break;
         case "K":
            int num = Integer.parseInt(st.nextToken());
            follower[playerNum].add(num);
            break;
         default:
            break;
         }
         idx++;
      }
      for (int i = 0; i < candy.length; i++) {
         System.out.print(candy[i] + " ");
      }
      br.close();
   }

}