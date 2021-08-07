package bts18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LetterFrequency {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String s = readLine();
		int[][]freq = new int[26][s.length()+1];
		for(int i = 1; i<=s.length(); i++) {
			if(s.charAt(i-1)!=' ')freq[s.charAt(i-1)-'a'][i]++;
			for(int j = 0; j<26; j++) freq[j][i]+=freq[j][i-1];
		}
		int q = readInt();
		for(int i = 0; i<q; i++) {
			int l = readInt(), r = readInt(), h = readCharacter()-'a';
			System.out.println(freq[h][r]-freq[h][l-1]);
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
