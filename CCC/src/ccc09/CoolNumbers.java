package ccc09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class CoolNumbers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int a = readInt();
		int b = readInt();
		ArrayList<Integer>square = new ArrayList<>();
		int i = (int)Math.sqrt(a);
		while(true) {
			int ans = (int)Math.pow(i, 2);
			if(ans>b) break;
			square.add(ans);
			i++;
		}
		i = (int)Math.pow(i, 1/3);
		int count = 0;
		while(true) {
			int ans = (int) Math.pow(i,3);
			if(ans>b) break;
			if(square.contains(ans)) {
				count++;
			}
			i++;
		}
		System.out.println(count);
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
