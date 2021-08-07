package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Balance {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		HashSet<Integer>set = new HashSet<>();
		HashSet<Integer>tmp = new HashSet<>();
		int sum = 0;
		for(int i = 0; i<N; i++) {
			int k = readInt();
			sum += k;
			for(int j: set) {
				tmp.add(j+k);
			}
			tmp.add(k);
			set.addAll(tmp);
		}
		int min = Integer.MAX_VALUE;
		for(int i: set) {
			min = Math.min(min, Math.abs(sum - 2*i));
		}
		System.out.println(min);
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
