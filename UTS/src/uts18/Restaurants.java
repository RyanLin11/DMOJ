package uts18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Restaurants {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), t = readInt(), k = readInt(), v = readInt();
		boolean[]arr = new boolean[n+1];
		for(int i = 0; i<v; i++) {
			arr[readInt()]=true;
		}
		int cnt = 0;
		int min = 0;
		for(int i = 1; i<=t; i++) {
			if(arr[i]) cnt++;
		}
		for(int i = t; i>0 && cnt<k; i--) {
			if(!arr[i]) {
				arr[i]=true;
				min++;
				cnt++;
			}
		}
		for(int i = t+1; i<=n; i++) {
			if(arr[i]) cnt++;
			if(arr[i-t]) cnt--;
			if(cnt<k) {
				arr[i] = true;
				min++;
				cnt++;
			}
		}
		System.out.println(min);
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
