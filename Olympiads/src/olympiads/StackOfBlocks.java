package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

public class StackOfBlocks {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		HashSet<Long>set = new HashSet<>();
		HashSet<Long>temp = new HashSet<>();
		int n = readInt();
		int t = readInt();
		set.add(0L);
		for(int i = 0; i<n; i++) {
			int x = readInt();
			for(long j: set) {
				temp.add(j+x);
			}
			set.addAll(temp);
			temp.clear();
		}
		long min = Long.MAX_VALUE;
		for(long i: set) {
			if(i>=t) min = Math.min(min, i-t);
		}
		if(min==Long.MAX_VALUE) min = -1; 
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
