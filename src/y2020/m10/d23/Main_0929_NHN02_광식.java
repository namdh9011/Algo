package y2020.m10.d23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_0929_NHN02_광식{

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      int n = Integer.parseInt(br.readLine());
      ArrayList<Integer> q = new ArrayList<>();
      int[] cnt = new int[101];
      for (int i = 0; i < n; i++) {
         st = new StringTokenizer(br.readLine());
         if (st.countTokens() > 1) {
            st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            q.add(num);
            cnt[num]++;
         } else {
            int max = Arrays.stream(cnt).max().getAsInt();
            if (q.isEmpty())
               System.out.print(-1);
            else {
               for (int j = 0; j < q.size(); j++) {
                  if (cnt[q.get(j)] == max) {
                     System.out.print(q.get(j) + " ");
                     cnt[q.get(j)]--;
                     q.remove(j);
                     break;
                  }
               }
            }
         }
      }
      br.close();
   }

}