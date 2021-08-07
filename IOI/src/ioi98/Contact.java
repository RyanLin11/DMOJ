package ioi98;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.*;

public class Contact {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int a = readInt(), b = readInt(), n = readInt();
		char[]c = next().toCharArray();
		int[]arr = new int[b];
		int[]freq = new int[1<<(b+1)];
		for(int i = 0; i<c.length-1; i++) {
			for(int j = a-1; j<Math.min(i,arr.length); j++) {
				freq[arr[j]]++;
			}
			int x = c[i]-48;
			for(int j = Math.min(i, arr.length-1); j>0; j--) {
				arr[j] = (arr[j-1]<<1) + x;
			}
			arr[0] = (1<<1) + x;
		}
		for(int j = a-1; j<arr.length; j++) {
			freq[arr[j]]++;
		}
		TreeMap<Integer, ArrayList<String>>ans = new TreeMap<>();
		for(int i = 0; i<freq.length; i++) {
			if(freq[i]==0) continue;
			if(!ans.containsKey(freq[i])) {
				ans.put(freq[i], new ArrayList<String>());
			}
			ans.get(freq[i]).add(Integer.toBinaryString(i).substring(1));
		}
		int cnt = 0;
		for(int i: ans.descendingKeySet()) {
			if(cnt>=n) break;
			Collections.sort(ans.get(i),new compareString());
			System.out.println(i+" "+String.join(" ", ans.get(i)));
			cnt++;
		}
	}
	static class compareString implements Comparator<String>{
		public int compare(String a, String b) {
			if(a.length()<b.length()) {
				return 1;
			} else if(a.length()>b.length()) {
				return -1;
			} else {
				return b.compareTo(a);
			}
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
