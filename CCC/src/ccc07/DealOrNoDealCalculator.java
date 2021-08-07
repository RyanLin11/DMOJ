package ccc07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DealOrNoDealCalculator {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int[]money = {1,500,1000,5000,10000,25000,50000,100000,500000,1000000};
		int n = readInt();
		for(int i = 0; i<n; i++) {
			money[readInt()-1] = 0;
		}
		int sum = 0;
		for(int i = 0; i<10; i++) {
			sum+=money[i];
		}
		int offer = readInt();
		if(offer>sum/(10-n)) System.out.println("deal");
		else System.out.println("no deal");
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
