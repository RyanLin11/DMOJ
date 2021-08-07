package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class BrucesHomework {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt(), T = readInt();
		int[]w = new int[N];
		for(int i = 0; i<N; i++) {
			w[i] = readInt();
		}
		double[]v = new double[N];
		int cnt = 0;
		for(int i = 0; i<M; i++) {
			int a = readInt();
			for(int j = 0; j<a; j++) {
				v[readInt()-1] += (1.0 / a);
			}
			cnt += a == 0? 1:0;
		}
		double[]dp = new double[T+1];
		for(int i = 0; i<N; i++) {
			for(int j = T; j>=w[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
			}
		}
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(df.format(cnt + Math.round(dp[T]*100)/100.0));
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
