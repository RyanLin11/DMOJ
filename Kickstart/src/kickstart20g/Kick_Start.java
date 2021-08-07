package kickstart20g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kick_Start {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for(int i = 0; i<T; i++) {
			char[]c = next().toCharArray();
			char[]s1 = {'K','I','C','K'};
			char[]s2 = {'S','T','A','R','T'};
			long t1 = 0, t2 = 0;
			int[]pow = new int[6];
			pow[0] = 1;
			for(int j = 1; j<pow.length; j++) {
				pow[j] = pow[j-1] * 31;
			}
			for(int j = 0; j<s1.length; j++) {
				t1*= 31;
				t1 += s1[j];
			}
			for(int j = 0; j<s2.length; j++) {
				t2 *= 31;
				t2 += s2[j];
			}
			int start = 0;
			int[]arr = new int[100001];
			int h1 = 0, h2 = 0;
			for(int j = 0; j<c.length; j++) {
				if(j>=4) h1 -= c[j-4] * pow[3];
				h1 *= 31;
				h1 += c[j];
				if(j>=5) h2 -= c[j-5] * pow[4];
				h2 *= 31;
				h2 += c[j];
				if(h1 == t1) {
					arr[start]++;
				} else if(h2 == t2) {
					start++;
				}
			}
			long total = 0;
			for(int j = 0; j<arr.length; j++) {
				total += (start - j) * arr[j];
			}
			System.out.println("Case #"+(i+1)+": "+total);
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
