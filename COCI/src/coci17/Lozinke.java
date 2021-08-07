package coci17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Lozinke {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class byLength implements Comparator<String>{
		public int compare(String a, String b) {
			if(a.length()<b.length()) return -1;
			else if(a.length()>b.length()) return 1;
			else return 0;
		}
	}
	public static void main(String[] args) throws IOException {
		int n = readInt();
		HashMap<String, Integer>map = new HashMap<>();
		String[]arr = new String[n];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = next();
		}
		Arrays.sort(arr, new byLength());
		int cnt = 0;
		for(int i = 0; i<arr.length; i++) {
			int len = arr[i].length();
			HashSet<String>s = new HashSet<>();
			for(int j = 0; j<len; j++) {
				for(int k = j+1; k<=len; k++) {
					s.add(arr[i].substring(j,k));
				}
			}
			for(String x: s) {
				if(map.containsKey(x)) {
					cnt+=map.get(x);
				}
			}
			if(map.containsKey(arr[i])) {
				cnt+=map.get(arr[i]);
				map.put(arr[i], map.get(arr[i])+1);
			} else {
				map.put(arr[i], 1);
			}
		}
		System.out.println(cnt);
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
