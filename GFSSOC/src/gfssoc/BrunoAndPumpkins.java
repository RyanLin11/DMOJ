package gfssoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BrunoAndPumpkins {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int t = readInt();
		int[]arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = readInt()+1000;
		}
		Arrays.sort(arr);
		int eq = Arrays.binarySearch(arr, 1000);
		eq = -eq-1;
		int min = Integer.MAX_VALUE;
		if(eq+t-1<arr.length)min = Math.min(min,arr[eq+t-1]-1000);
		//first step into right direction
		for(int i = eq; i<eq+t && i<arr.length; i++) {
			if(i-t+1<0) continue;
			min = Math.min(min, 2*arr[i]-arr[i-t+1]-1000);
		}
		if(eq-t>=0)min = Math.min(min, 1000-arr[eq-t]);
		//first step into left direction
		for(int i = eq-1; i>eq-t && i>=0; i--) {
			if(i+t-1>=arr.length)continue;
			min = Math.min(min, arr[i+t-1]-2*arr[i]+1000);
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
