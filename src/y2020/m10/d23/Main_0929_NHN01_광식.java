package y2020.m10.d23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_0929_NHN01_광식 {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      int n = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      HashMap<String, Integer> hm = new HashMap<>();
      while (st.hasMoreTokens()) {
         String insect = st.nextToken();
         if (hm.containsKey(insect)) {
            int cnt = hm.get(insect);
            hm.put(insect, cnt + 1);
         } else
            hm.put(insect, 1);
      }
      Set<String> keys = hm.keySet();
      int[] count = new int[hm.size()];
      int idx = 0;
      int total = 0;
      for (String key : keys) {
         count[idx] = hm.get(key);
         total += count[idx++];
      }
      Arrays.sort(count);
      int buy = 1;
      boolean flag = true;
      int cnt = count[count.length - 1];
      for (int i = count.length - 2; i >= 0; i--) {
         if (cnt == count[i])
            continue;
         else if (buy == 1 && cnt - 1 == count[i]) {
            buy--;
            count[i]++;
            total++;
            cnt = count[i];
         } else {
            flag = false;
            total--;
         }
      }
      System.out.println((flag) ? "Y" : "N");
      System.out.println(total);
      System.out.println(hm.size());
   }

}