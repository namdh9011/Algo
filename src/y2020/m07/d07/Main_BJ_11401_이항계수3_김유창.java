package y2020.m07.d07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11401_이항계수3_김유창 {
	static final int mod = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim(), " ");
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		long fac[] = new long[N + 1];
		fac[0] = 1;
		for (int i = 1; i <= N; i++)
			fac[i] = (fac[i - 1] * i) % mod;

		long bottom = (fac[R] * fac[N - R]) % mod;
		long reBottom = fermat(bottom, mod - 2);

		long result = (fac[N] * reBottom) % mod;
		System.out.println(result);
	}

	private static long fermat(long n, int x) {
		if (x == 0)
			return 1;
		long tmp = fermat(n, x / 2);
		long ret = (tmp * tmp) % mod;
		if (x % 2 == 0)
			return ret;
		else
			return (ret * n) % mod;
	}
}