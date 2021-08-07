package ecoo20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class OnlineShopping {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for(int i = 0; i<t; i++) {
			int[][]arr = new int[10000][101];
			HashMap<String, Integer>map = new HashMap<>();
			int n = readInt();
			for(int j = 0; j<n; j++) {
				int m = readInt();
				for(int k = 0; k<m; k++) {
					String s = next(); int p = readInt(), q = readInt();
					if(!map.containsKey(s)) map.put(s,map.size());
					arr[map.get(s)][p]+=q;
				}
			}
			n = readInt();
			int c = 0;
			for(int j = 0; j<n; j++) {
				String s = next();
				int q = readInt();
				for(int k = 0; k<101 && q!=0; k++) {
					if(arr[map.get(s)][k]<=q) {
						q-=arr[map.get(s)][k];
						c+=k*arr[map.get(s)][k];
					} else {
						c+=q*k;
						q=0;
					}
				}
			}
			System.out.println(c);
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
