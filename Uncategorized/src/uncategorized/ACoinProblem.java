package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class ACoinProblem {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair{
		int cj, id;
		public Pair(int cj, int id) {
			this.cj = cj;
			this.id = id;
		}
	}
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int v = readInt();
		int[]d = new int[n];
		for(int i = 0; i<d.length; i++) {
			d[i] = readInt();
		}
		ArrayList<Pair>[]s = new ArrayList[n+1];
		for(int i = 0; i<s.length; i++) s[i] = new ArrayList<>();
		for(int i = 0; i<v; i++) {
			int cj = readInt();
			int lj = readInt()-1;
			s[lj].add(new Pair(cj, i));
		}
		//dp table filling
		int[]ans = new int[v]; //to store the answer corresponding to the id
		int[]arr = new int[10001];
		Arrays.fill(arr, Integer.MAX_VALUE);
		for(int i = 0; i<arr.length; i+=d[0]) {
			arr[i] = i/d[0];
			for(Pair p: s[0]) {
				if(arr[p.cj]==Integer.MAX_VALUE) ans[p.id] = -1;
				else ans[p.id] = arr[p.cj]; 
			}
		}
		for(int i = 1; i<n; i++) {
			for(int j = d[i]; j<arr.length; j++) {
				if(arr[j-d[i]]!=Integer.MAX_VALUE)arr[j] = Math.min(arr[j-d[i]]+1, arr[j]);
			}
			for(Pair p: s[i]) {
				if(arr[p.cj]==Integer.MAX_VALUE) ans[p.id] = -1;
				else ans[p.id] = arr[p.cj]; 
			}
		}
		//print answer
		for(int x: ans) {
			System.out.println(x);
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
