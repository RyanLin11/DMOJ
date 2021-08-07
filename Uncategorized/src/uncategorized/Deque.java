package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Deque {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[]arr;
	static long[][]memo, memo2;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		arr = new long[n];
		memo = new long[n][n];
		memo2 = new long[n][n];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = readInt();
		}
		System.out.println(Taro(0,arr.length-1));
	}
	public static long Taro(int x, int y) {
		if(x>y) return 0;
		if(memo[x][y]!=0) return memo[x][y];
		return memo[x][y]=Math.max(arr[x]-Jiro(x+1,y),arr[y]-Jiro(x,y-1));
	}
	public static long Jiro(int x, int y) {
		if(x>y) return 0;
		if(memo2[x][y]!=0) return memo2[x][y];
		return memo2[x][y]=Math.max(arr[x]-Taro(x+1,y), arr[y]-Taro(x,y-1));
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
