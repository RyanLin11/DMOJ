package ecoo16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Arrays;

public class CamelCase {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int n = readInt();
		HashSet<String>set = new HashSet<>();
		for(int i = 0; i<n; i++) {
			set.add(next());
		}
		HashSet<Integer>pos = new HashSet<>();
		pos.add(0);
		for(int i = 0; i<10; i++) {
			String s = next();
			pos.add(0);
			int[]dp = new int[s.length()+1];
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = 0;
			for(int j = 1; j<=s.length(); j++) {
				boolean add = false;
				for(int a: pos) {
					if(set.contains(s.substring(a,j))) {
						add = true;
						dp[j] = Math.min(dp[j], dp[a]+1);
					}
				}
				if(add)pos.add(j);
			}
			//System.out.println(Arrays.toString(dp));
			//System.out.println(pos.toString());
			pos.clear();
			System.out.println(dp[s.length()]-1);
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
