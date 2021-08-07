package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class TotalDestruction {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), q = readInt();
		int[]dif = new int[q-1];
		int[]arr = new int[q];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = readInt();
		}
		Arrays.sort(arr);
		int ans = n-arr[0]+1;
		for(int i = 0; i<dif.length; i++) {
			dif[i] = arr[i+1]-arr[i];
		}
		ans=ans-(n-arr[arr.length-1]);
		Arrays.sort(dif);
		for(int i = 0; i<Math.min(m-1,dif.length); i++) {
			ans= ans-dif[dif.length-i-1]+1;
		}
		System.out.println(ans);
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
