package rgpc17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CubesAreLife {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), q = readInt();
		int[]map = new int[1000001];
		long[]pre = new long[n+1];
		for(int i = 1; i<=n; i++) {
			int v = readInt();
			pre[i]+=pre[i-1]+v;
			map[v] = i;
		}
		for(int i = 0; i<q; i++) {
			int a = readInt(), b = readInt();
			int l = Math.min(map[a], map[b]), r = Math.max(map[a], map[b]);
			System.out.println((pre[r]-pre[l-1])/2.0>=m?"Enough":"Not enough");
		}
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
