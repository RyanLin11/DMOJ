package rte16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MuleWars {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for(int i = 0; i<t; i++) {
			int n = readInt(), c = readInt();
			int[]arr = new int[n+1];
			for(int j = 0; j<c; j++) {
				String s = next();
				int x = readInt();
				if(s.equals("A")) {
					int y = readInt();
					if(arr[y]>=0) arr[y]+=x;
				} else if(s.equals("Q")) {
					System.out.println(Math.max(arr[x], 0));
				} else if(s.equals("G")) {
					int cnt = 0;
					for(int k = 1; k<=x; k++) {
						if(arr[k]>=0) cnt+=arr[k];
					}
					System.out.println(cnt);
				} else if(s.equals("L")) {
					int cnt = 0;
					for(int k = n-x+1; k<=n; k++) {
						if(arr[k]>=0) cnt+=arr[k];
					}
					System.out.println(cnt);
				} else {
					arr[x] = -1;
				}
			}
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
