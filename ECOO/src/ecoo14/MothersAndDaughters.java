package ecoo14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class MothersAndDaughters {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]parent, ancestor;
	static HashMap<String, Integer>map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		int n = readInt();
		parent = new int[2*n];
		ancestor = new int[2*n];
		for(int i = 0; i<parent.length; i++) {
			parent[i] = -1;
			ancestor[i] = -1;
		}
		for(int i = 0; i<n; i++) {
			String s1 = next();
			String s2 = next();
			if(!map.containsKey(s1)) map.put(s1, map.size());
			if(!map.containsKey(s2)) map.put(s2, map.size());
			parent[map.get(s2)] = map.get(s1);
		}
		for(int i = 0; i<ancestor.length; i++) {
			if(parent[i]!=-1)ancestor[i] = parent[parent[i]];
		}
		for(int i = 0; i<10; i++) {
			int d = map.get(next());
			System.out.println("Cousins: "+numCousins(d)+", Sisters: "+numSisters(d));
		}
	}
	public static int numSisters(int d) {
		if(parent[d]==-1) {
			return 0;
		}
		int n = 0;
		for(int i = 0; i<parent.length; i++) {
			if(parent[i]==parent[d]) n++;
		}
		return n-1;
	}
	public static int numCousins(int d) {
		if(ancestor[d]==-1) {
			return 0;
		}
		int n = 0;
		for(int i = 0; i<ancestor.length; i++) {
			if(ancestor[i]==ancestor[d]) {
				n++;
			}
		}
		return n-(numSisters(d)+1);
	}
	public static String next () throws IOException {
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
