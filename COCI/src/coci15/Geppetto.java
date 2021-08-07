package coci15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;

public class Geppetto {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]arr;
	static int n,m, count=0;
	static ArrayList<Integer>[]list;
	static ArrayList<HashSet<Integer>>setlist = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		n = readInt();
		m = readInt();
		list = new ArrayList[n+1];
		for(int i = 0; i<list.length; i++) list[i] = new ArrayList<>();
		for(int i = 0; i<m; i++) {
			int x = readInt();
			int y = readInt();
			list[x].add(y);
			list[y].add(x);
		}
		for(int i = 1; i<=n; i++) {
			recurse(i);
		}
		//System.out.println(Arrays.toString(occur));
		System.out.println(count+1);
	}
	static HashSet<Integer>path = new HashSet<>();
	static HashSet<Integer>set = new HashSet<>();
	public static void recurse(int s) {
		path.add(s);
		//System.out.println(path.toString());
		count++;
		HashSet<Integer>temp = new HashSet<>();
		for(int x: list[s]) {
			/*if(!path.contains(x)) {
				set.add(x);
				temp.add(x);
			}*/
			if(!path.contains(x)) temp.add(x);
			path.add(x);
		}
		for(int i = s; i<=n; i++) {
			if(!path.contains(i) && !set.contains(i)) {
				recurse(i);
			}
		}
		for(int x: temp) {
			path.remove(x);
		}
		path.remove(s);
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
