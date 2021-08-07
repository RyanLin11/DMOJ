package ecoo12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class DecodingDNA {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for(int i = 0; i<5; i++) {
			String str = next();
			int index = str.indexOf("TATAAT");
			int start = index+10;
			int end = str.length()-1;
			boolean found = false;
			for(int j = start; j<str.length(); j++) {
				for(int k = j+6; k<str.length(); k++) {
					if(str.indexOf(compare(str.substring(j,k)),k)>=0) {
						end = j;
						found = true;
						break;
					}
				}
				if(found) break;
			}
			String rna = str.substring(start,end);
			System.out.println((i+1)+": "+transcribe(rna));
		}
	}
	public static String transcribe(String str) {
		StringBuilder sb = new StringBuilder("");
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i)=='A') {
				sb.append('U');
			} else if(str.charAt(i)=='C') {
				sb.append('G');
			} else if(str.charAt(i)=='G') {
				sb.append('C');
			} else if(str.charAt(i)=='T') {
				sb.append('A');
			}
		}
		return sb.toString();
	}
	public static String compare(String str) {
		StringBuilder sb = new StringBuilder("");
		for(int i = str.length()-1; i>=0; i--) {
			if(str.charAt(i)=='A') {
				sb.append('T');
			} else if(str.charAt(i)=='C') {
				sb.append('G');
			} else if(str.charAt(i)=='G') {
				sb.append('C');
			} else if(str.charAt(i)=='T') {
				sb.append('A');
			}
		}
		return sb.toString();
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
