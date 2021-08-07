package dwite11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class BearTrees {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[]list;
	static int[]in;
	public static void main(String[] args) throws IOException {
		for(int k = 0; k<5; k++) {
			int n = readInt();
			list = new ArrayList[n];
			in = new int[n];
			for(int i = 0; i<list.length; i++) {
				list[i] = new ArrayList<>();
			}
			for(int i = 0; i<n-1; i++) {
				int x = readInt(), y = readInt();
				list[x].add(y);
				list[y].add(x);
				in[x]++;
				in[y]++;
			}
			//in stores change in size by choosing it(-1 for excluding parent, -1 for eliminating it)
			for(int i = 1; i<in.length; i++) {
				in[i]-=2;
			}
			System.out.println(dfs(0,-1));
		}
	}
	public static int dfs(int u, int prev) {
		if(in[u]==-1) return 0;
		ArrayList<Integer>al = new ArrayList<>();
		for(int v: list[u]) {
			if(v!=prev) al.add(in[u]+dfs(v, u));
		}
		Collections.sort(al);
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<al.size(); i++) {
			max = Math.max(max, al.get(i)-i);
		}
		return max;
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
