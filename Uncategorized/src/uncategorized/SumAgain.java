package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

public class SumAgain {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt(), m = readInt();
		int[][]arr = new int[10*m][10];
		for(int i = 0; i<n; i++) {
			int x = readInt();
			int in = x%(10*m);
			HashSet<Integer>set = new HashSet<>();
			int tmp = x;
			while(tmp>0) {
				set.add(tmp%10);
				tmp/=10;
			}
			for(int a: set) {
				arr[in][a]+=x;
			}
		}
		for(int i = 0; i<q; i++) {
			int k = readInt(), t = readInt();
			System.out.println(arr[k][t]);
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
