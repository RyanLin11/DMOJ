package ccc07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class KeepOnTruckin {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]arr;
	static int a, b, n;
	public static void main(String[] args) throws IOException {
		a = readInt();
		b = readInt();
		n = readInt();
		int[]arr = new int[n+14];
		arr[0] = 0;
		arr[1] = 990;
		arr[2] = 1010;
		arr[3] = 1970;
		arr[4] = 2030;
		arr[5] = 2940;
		arr[6] = 3060;
		arr[7] = 3930;
		arr[8] = 4060;
		arr[9] = 4970;
		arr[10] = 5030;
		arr[11] = 5990;
		arr[12] = 6010;
		arr[13] = 7000;
		for(int i = 14; i<arr.length; i++) {
			arr[i] = readInt();
		}
		Arrays.sort(arr);
		long[]ways = new long[n+14];
		int x = Arrays.binarySearch(arr, a);
		if(x<0) x = -(x+1);
		for(int j = x; j<ways.length; j++) {
			if(arr[j]>b) break;
			else ways[j]+=1;
		}
		for(int i = 0; i<ways.length; i++) {
			x = Arrays.binarySearch(arr, arr[i]+a);
			if(x<0) x = -(x+1);
			for(int j = x; j<ways.length; j++) {
				if(arr[j]>arr[i]+b) break;
				else ways[j]+=ways[i];
			}
		}
		System.out.println(ways[ways.length-1]);
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
