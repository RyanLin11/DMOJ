package coci15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Savez {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Hash implements Comparable<Hash>{
		int hash, len, freq;
		public Hash(int hash, int len, int freq) {
			this.hash = hash;
			this.len = len;
			this.freq = freq;
		}
		public int compareTo(Hash other) {
			if(this.hash==other.hash)return 0;
			if(this.len<other.len) {
				return -1;
			} else {
				return 1;
			}
		}
		public boolean equals(Hash other) {
			if(this.hash==other.hash) {
				return true;
			} else {
				return false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[]pow = new int[2000001];
		TreeSet<Hash>set = new TreeSet<>();
		pow[0] = 1;
		for(int i = 1; i<pow.length; i++) {
			pow[i] = pow[i-1]*131;
		}
		int max = 0;
		for(int i = 0; i<n; i++) {
			//processing it
			char[]arr = next().toCharArray();
			int[]pre = new int[arr.length];
			int[]suf = new int[arr.length];
			pre[0] = (arr[0]%64)*pow[0];
			suf[0] = (arr[arr.length-1]%64);
			for(int j = 1; j<arr.length; j++) {
				pre[j] = pre[j-1]+(arr[j]%64)*pow[j];
				suf[j] = (arr[arr.length-j-1]%64)+131*suf[j-1];
			}
			int longest = 1;
			for(Hash h: set) {
				if(h.len>=arr.length)break;
				if(h.hash==pre[h.len]&&h.hash==suf[h.len]&&h.freq+1>longest) longest = h.freq+1;
			}
			max = Math.max(max, longest);
			Hash temp = new Hash(pre[arr.length-1],arr.length-1,longest);
			set.remove(temp);
			set.add(temp);
		}
		System.out.println(max);
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
