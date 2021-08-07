package ceoi18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.*;

public class Toys {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static HashSet<Integer>[]list;
	static HashMap<Integer,HashSet<Integer>>map;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		map = new HashMap<>();
		f(n);
		System.out.println(map.get(n).size());
		int[]arr = new int[map.get(n).size()];
		int j = 0;
		for(int x: map.get(n)) {
			arr[j] = x; j++;
		}
		Arrays.sort(arr);
		for(int i = 0; i<arr.length; i++) System.out.print(arr[i]+" ");
		System.out.println();
	}
	public static HashSet<Integer> f(int x) {
		if(map.get(x)!=null) return map.get(x);
		HashSet<Integer> temp = new HashSet<>();
		temp.add(x-1);
		for(int i = 2; i<=Math.sqrt(x); i++) {
			if(x%i==0) {
				for(int j: f(x/i)) {
					temp.add(j+i-1);
				}
			}
		}
		map.put(x, temp);
		return map.get(x);
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