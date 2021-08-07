package dstests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class BIT {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		int[]arr = new int[n+1];
		long[]bit = new long[n+1];
		int[]arrv = new int[100001];
		long[]bitv = new long[100001];//tree for q function
		for(int i = 1; i<=n; i++) {
			arr[i] = readInt();
			bit[i] = arr[i];
			arrv[arr[i]]++;
			bitv[arr[i]]++;
		}
		for(int i = 1; i<=n; i++) {
			int j = i + Integer.lowestOneBit(i);
			if(j<=n) {
				bit[j]+=bit[i];
			}
		}
		for(int i = 1; i<=100000; i++) {
			int j = i + Integer.lowestOneBit(i);
			if(j<=100000) {
				bitv[j]+=bitv[i];
			}
		}
		for(int i = 0; i<m; i++) {
			char c = readCharacter();
			if(c=='C') {
				int x = readInt(), v = readInt();
				int diff = v-arr[x]; int j = x;
				while(j<=n) {
					bit[j]+=diff;
					j+=Integer.lowestOneBit(j);
				}
				j = arr[x];
				while(j<=100000) {
					bitv[j]--;
					j+=Integer.lowestOneBit(j);
				}
				j = v;
				while(j<=100000) {
					bitv[j]++;
					j+=Integer.lowestOneBit(j);
				}
				//update array values
				arrv[arr[x]]--;
				arrv[v]++;
				arr[x] = v;
			} else if(c=='S') {
				int l = readInt(), r = readInt();
				System.out.println(sum(bit,r)-sum(bit,l-1));
			} else {
				int v = readInt();
				System.out.println(sum(bitv,v));
			}
		}
	}
	public static long sum(long[]bit, int x) {
		long sum = 0;
		while(x>0) {
			sum+=bit[x];
			x-=Integer.lowestOneBit(x);
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
