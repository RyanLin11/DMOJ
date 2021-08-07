package dmopc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PhantomFight {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		int[]arr = new int[10001];
		int[]p = new int[n];
		int[]v = new int[n];
		for(int i = 0; i<n; i++) {
			p[i] = readInt();
			v[i] = readInt();
		}
		arr[m] = 1;
		for(int i = 0; i<n; i++) {
			if(p[i]>=v[i]) {
				for(int j = p[i]; j<arr.length; j++) {
					if(arr[j]!=0)arr[j-p[i]+v[i]] = Math.max(arr[j]+1, arr[j-p[i]+v[i]]);
				}
			} else {
				for(int j = arr.length-1; j>=p[i]; j--) {
					if(arr[j]!=0)arr[j-p[i]+v[i]] = Math.max(arr[j]+1, arr[j-p[i]+v[i]]);
				}
			}
		}
		int max = 0;
		int maxpt = 0;
		for(int i = arr.length-1; i>=0; i--) {
			if(arr[i]>max) {
				max = arr[i];
				maxpt = i;
			}
		}
		System.out.println((max-1)+" "+maxpt);
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
