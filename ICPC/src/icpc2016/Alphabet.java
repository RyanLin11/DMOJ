package icpc2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Alphabet {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String s = next();
		int[]end = new int[s.length()+1];
		int len = 1;
		end[0] = s.charAt(0);
		for(int i = 0; i<s.length(); i++) {
			int x = s.charAt(i)-97;
			if(x<end[0]) {
				end[0] = x;
			} else if(x>end[len-1]){
				end[len] = x;
				len++;
			} else {
				int u = Arrays.binarySearch(end,0,len,x);
				if(u<0) u = -u-1;
				end[u] = x;
			}
		}
		System.out.println(26-len);
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
