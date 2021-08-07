package ccc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Rovarspraket {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		String consonant = "bcdfghjklmnpqrstvwxyzz";
		String vowel = "aeiou";
		String str = next();
		for(int i = 0; i<str.length(); i++) {
			String s = str.charAt(i)+"";
			if(consonant.contains(s)) {
				System.out.print(s);
				int a = Integer.MAX_VALUE;
				char avowel = ' ';
				for(int j = alpha.indexOf(s); j>=0; j--) {
					if(vowel.contains(alpha.charAt(j)+"")) {
						a = alpha.indexOf(s)-j;
						avowel = alpha.charAt(j);
						break;
					}
				}
				int b = Integer.MAX_VALUE;
				char bvowel = ' ';
				for(int j = alpha.indexOf(s); j<alpha.length(); j++) {
					if(vowel.contains(alpha.charAt(j)+"")) {
						b = j-alpha.indexOf(s);
						bvowel = alpha.charAt(j);
						break;
					}
				}
				if(a<=b) {
					System.out.print(avowel);
				} else {
					System.out.print(bvowel);
				}
				System.out.print(consonant.charAt(consonant.indexOf(s)+1));
			} else {
				System.out.print(s);
			}
		}
		System.out.println();
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
