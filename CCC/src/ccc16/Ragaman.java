package ccc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ragaman {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int[]arr1 = new int[26];
		int[]arr2 = new int[26];
		String str1 = next();
		String str2 = next();
		if(str1.length()!=str2.length()) {
			System.out.println("N");
			return;
		}
		int w = 0;
		for(int i = 0; i<str1.length(); i++) {
			arr1[(int)(str1.charAt(i))-97]+=1;
			if(str2.charAt(i)=='*') {
				w++;
				continue;
			} else {
				arr2[(int)(str2.charAt(i))-97]+=1;
			}
		}
		int count = 0;
		for(int i = 0; i<arr1.length; i++) {
			int dif = arr1[i]-arr2[i];
			if(dif<0) {
				System.out.println("N");
				return;
			}
			count+=dif;
		}
		if(w==count) System.out.println("A");
		else System.out.println("N");
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
