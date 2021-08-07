package tle16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MealPlan {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int mod = 1000000007;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int B = readInt();
		int L = readInt();
		int D = readInt();
		ArrayList<Integer>[]list = new ArrayList[3];
		for(int i = 0; i<list.length; i++)list[i] = new ArrayList<>();
		for(int i = 0; i<B; i++) list[0].add(readInt());
		for(int i = 0; i<L; i++) list[1].add(readInt());
		for(int i = 0; i<D; i++) list[2].add(readInt());
		for(int i = 0; i<list.length; i++) Collections.sort(list[i]);
		long[][]f = new long[n+1][3];
		f[0][2] = 1;
		for(int i = 1; i<=n; i++) {
			for(int j = 0; j<list[0].size(); j++) {
				int p = i-list[0].get(j);
				if(p<0) break;
				f[i][0]+=f[p][2];
				f[i][0]%=mod;
			}
			for(int j = 0; j<list[1].size(); j++) {
				int p = i-list[1].get(j);
				if(p<0) break;
				f[i][1]+=f[p][0];
				f[i][1]%=mod;
			}
			for(int j = 0; j<list[2].size(); j++) {
				int p = i-list[2].get(j);
				if(p<0) break;
				f[i][2]+=f[p][1];
				f[i][2]%=mod;
			}
		}
		f[0][2] = 0;
		for(int i = n; i>=0; i--) {
			if(f[i][0]+f[i][1]+f[i][2]>0) {
				System.out.println((f[i][0]+f[i][1]+f[i][2])%mod+" "+(n-i));
				return;
			}
		}
		System.out.println(0+" "+n);
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
