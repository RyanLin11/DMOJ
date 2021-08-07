package ac3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DiverseArrays {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), K = readInt();
		int[]arr = new int[N];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = readInt();
		}
		int[]freq = new int[N+1];
		int unique = 0; long cnt = 0;
		for(int l = 0, r = 0; l<arr.length; l++) {
			while(r<arr.length && unique<K) {
				if(freq[arr[r]]==0) unique++;
				freq[arr[r]]++;
				r++;
			}
			if(unique==K) cnt += N-r+1;
			freq[arr[l]]--;
			if(freq[arr[l]]==0) unique--;
		}
		System.out.println(cnt);
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
