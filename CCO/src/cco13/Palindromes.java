package cco13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Palindromes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int x = readInt();
		ArrayList<Integer>list = new ArrayList<>();
		for(int i = 2; i<=Math.min(x,31623); i++) {
			int tmp = x;
			int[]num = new int[(int)(Math.log10(tmp)/Math.log10(i))+1];
			for(int j = (int)(Math.log10(tmp)/Math.log10(i)); j>=0; j--) {
				num[j] = tmp/(int)Math.pow(i, j);
				tmp %= Math.pow(i, j);
			}
			int id = num.length-1;
			for(int j = num.length-1; j>=0; j--) {
				if(num[j] == 0) {
					id--;
				} else {
					break;
				}
			}
			boolean flag = true;
			for(int j = 0; j<(id+1)/2; j++) {
				if(num[j] != num[id-j]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				list.add(i);
			}
		}
		for(int i = 1; i<=Math.sqrt(x); i++) {
			if(x % i == 0) {
				int a = x/i - 1;
				int b = i - 1;
				if(i <= a && a>=31623) {
					list.add(a);
				}
				if(x/i <= b && b>=31623) {
					list.add(b);
				}
			}
		}
		Collections.sort(list);
		for(int i = 0; i<list.size(); i++) {
			if(i == 0 || (i > 0 && list.get(i) != list.get(i-1))) {
				System.out.println(list.get(i));
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
