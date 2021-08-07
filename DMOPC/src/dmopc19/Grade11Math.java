package dmopc19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Grade11Math {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]parent, left, right;
	public static void main(String[] args) throws IOException {
		int len = readInt(), m = readInt();
		int mod = (int)1e9+7;
		String s = next();
		long[]pow = new long[len];
		pow[0] = 1;
		for(int i = 1; i<len; i++) {
			pow[i] = (pow[i-1]<<1)%mod;
		}
		parent = new int[len];
		left = new int[len];
		right = new int[len];
		Arrays.fill(parent, -1);
		for(int i = 0; i<len; i++) {
			left[i] = i;
			right[i] = i;
		}
		long sum = 0;
		if(s.charAt(0)=='1') {
			parent[0] = 0;
			sum+=pow[len-1]; sum%=mod;
		}
		for(int i = 1; i<parent.length; i++) {
			if(s.charAt(i)=='1') {
				parent[i] = i;
				if(s.charAt(i-1)=='1') {
					union(i-1,i);
				}
				sum+=pow[len-i-1]; sum%=mod;
			}
		}
		for(int i = 0; i<m; i++) {
			int l = readInt()-1, r = readInt()-1;
			if(parent[l]<0 || parent[r]<0 || find(l)!=find(r)) {
				if(parent[l]<0) {
					parent[l] = l;
					sum+=pow[len-l-1]; sum%=mod;
					if(l-1>=0 && parent[l-1]>=0)union(l-1, l);
				}
				for(int j = right[find(l)]+1; j<=r; j=right[find(j)]+1) {
					if(parent[j]<0) {
						sum+=pow[len-j-1]; sum%=mod;
						parent[j] = j;
					}
					union(j, j-1);
				}
				if(r+1<len && parent[r+1]>=0) {
					union(r, r+1);
				}
			}
			System.out.println(sum);
		}
	}
	public static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x] = find(parent[x]);
	}
	public static void union(int u, int v) {
		int x = find(u), y = find(v);
		if(x!=y) {
			parent[x] = y;
			//left[y] = Math.min(left[y], left[x]);
			//right[y] = Math.max(right[y], right[x]);
		}
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
