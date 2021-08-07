package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stones {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]arr;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int k = readInt();
		arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = readInt();
		}
		boolean[]taroWin = new boolean[k+1];
		for(int i = 1; i<taroWin.length; i++) {
			boolean picked = false;
			for(int j = 0; j<arr.length; j++) {
				if(i-arr[j]>=0) {
					if(!taroWin[i-arr[j]]) {
						taroWin[i] = true;
						picked = true;
						break;
					}
				}
			}
			if(!picked) {
				taroWin[i] = false;
			}
		}
		System.out.println(taroWin[k]?"First":"Second");
	}
	public static boolean Taro(int n) {
		for(int i = 0; i<arr.length; i++) {
			if(n-arr[i]>=0) {
				if(Jiro(n-arr[i])) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean Jiro(int n) {
		for(int i = 0; i<arr.length; i++) {
			if(n-arr[i]>=0) {
				if(!Taro(n-arr[i])) {
					return false;
				}
			}
		}
		return true;
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
