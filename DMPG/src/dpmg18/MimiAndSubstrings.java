package dpmg18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class MimiAndSubstrings {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		HashMap<Character, Integer>map = new HashMap<>();
		char[]c = next().toCharArray();
		int K = readInt();
		int cnt = 0;
		for(int i = 0; i<c.length; i++) {
			if(map.containsKey(c[i])) {
				map.put(c[i], map.get(c[i])+1);
			} else {
				map.put(c[i], 1);
			}
			if(i>=K) {
				int f = map.get(c[i-K]);
				if(f==1) {
					map.remove(c[i-K]);
				} else {
					map.put(c[i-K], f-1);
				}
			}
			if(i>=K-1 && map.size()==1) cnt++;
		}
		System.out.println(cnt);
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
