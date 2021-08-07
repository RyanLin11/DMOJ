package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FakeJudges {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		long[]pt = new long[n];
		for(int i = 0; i<n; i++) {
			pt[i] = readInt();
		}
		long[]st = new long[n];
		for(int i = 0; i<q; i++) {
			int l = readInt(), r = readInt();
			st[l-1]++;
			if(r<n)st[r]--;
		}
		for(int i = 1; i<n; i++) {
			st[i]+=st[i-1];
		}
		Arrays.sort(pt);
		Arrays.sort(st);
		long sum = 0;
		for(int i = 0; i<n; i++) {
			sum+=pt[i]*st[n-i-1];
		}
		System.out.println(sum);
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
