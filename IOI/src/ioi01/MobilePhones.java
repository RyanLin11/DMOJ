package ioi01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MobilePhones {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][]bit;
	public static void main(String[] args) throws IOException {
		int next = readInt();
		int S = readInt();
		bit = new int[S+1][S+1];
		next = readInt();
		while(next!=3) {
			if(next==1) {
				int r = readInt()+1, c = readInt()+1, val = readInt();
				for(int i = r; i<bit.length; i+=i&-i) {
					for(int j = c; j<bit[i].length; j+=j&-j) {
						bit[i][j]+=val;
					}
				}
			} else {
				int r1 = readInt()+1, c1 = readInt()+1, r2 = readInt()+1, c2 = readInt()+1;
				System.out.println(sum(r2,c2)-sum(r1-1,c2)-sum(r2,c1-1)+sum(r1-1,c1-1));
			}
			next = readInt();
		}
	}
	public static int sum(int r, int c) {
		int sum = 0;
		for(int i = r; i>0; i-=i&-i) {
			for(int j = c; j>0; j-=j&-j) {
				sum+=bit[i][j];
			}
		}
		return sum;
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
