package globexcup19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Codex {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long k = readLong();
		String[]name = new String[n];
		long[]diameter = new long[n];
		for(int i = 0; i<n; i++) {
			name[i] = next();
			diameter[i] = readLong();
		}
		boolean[]remove = new boolean[n];
		for(int i = 0; i<n; i++) {
			for(int j = i+1; j<n; j++) {
				if(Math.abs(diameter[j]-diameter[i])<=k) {
					remove[j] = true;
					remove[i] = true;
				}
			}
		}
		ArrayList<String>list = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			if(!remove[i]) {
				list.add(name[i]);
			}
		}
		Collections.sort(list);
		for(String s: list) {
			System.out.print(s+" ");
		}
		System.out.println();
	}
	public static String next () throws IOException {
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
