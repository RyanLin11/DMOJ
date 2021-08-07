package kickstart20f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class MetalHarvest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]l, r;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for(int i = 0; i<T; i++) {
			int N = readInt(), K = readInt();
			l = new int[N];
			r = new int[N];
			Integer[]in = new Integer[N];
			for(int j = 0; j<N; j++) {
				l[j] = readInt();
				r[j] = readInt();
			}
			for(int j = 0; j<N; j++) in[j] = j;
			Arrays.sort(in, new sort());
			int[]lft = new int[N];
			int[]rt = new int[N];
			for(int j = 0; j<N; j++) {
				lft[j] = l[in[j]];
				rt[j] = r[in[j]];
			}
			int cnt = 0;
			int r = 0;
			for(int j = 0; j<N; j++) {
				if(rt[j]<=r) continue;
				lft[j] = Math.max(lft[j], r);
				int k = (int)Math.ceil( ( rt[j] - lft[j])/(double)K );
				cnt += k;
				r = lft[j] + k * K;
			}
			System.out.println("Case #"+(i+1)+": "+cnt);
		}

	}
	public static class sort implements Comparator<Integer>{
		public int compare(Integer a, Integer b) {
			return Integer.compare(l[a], l[b]);
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
