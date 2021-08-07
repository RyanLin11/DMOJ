package dmopc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StarstruckSqueeze {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt(), d = readInt();
		long[]arr = new long[k+1];
		Arrays.fill(arr, 1);
		int in = 0;
		for(int i = 0; i<n; i++) {
			char c = readCharacter();
			if(c=='T') {
				in++;
			} else {
				int q = readInt();
				if(arr[in]>d)continue;
				arr[in]*=q;
			}
		}
		long x = 1;
		for(int i = k; i>=0; i--) {
			if(x>d) {
				arr[i] = -1;
				continue;
			} else {
				x*=arr[i];
				if(x>d)arr[i] = -1;
				else arr[i] = x;
			}
		}
		for(int i = 1; i<=k; i++) {
			System.out.println(arr[i]<0?"dust":arr[i]);
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
