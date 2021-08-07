package ecoo16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Spindie {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for(int k = 0; k<10; k++) {
			int N = readInt();
			HashSet<Integer>set = new HashSet<>();
			int[]arr = new int[N];
			for(int i = 0; i<N; i++) {
				arr[i] = readInt();
				set.add(arr[i]);
			}
			HashSet<Integer>temp = new HashSet<>();
			for(int i = 0; i<2; i++) {
				for(int x: set) {
					for(int j = 0; j<N; j++) {
						temp.add(x+arr[j]);
						temp.add(x*arr[j]);
					}
				}
				set.addAll(temp);
				temp.clear();
			}
			for(int i = 0; i<5; i++) {
				System.out.print(set.contains(readInt())?"T":"F");
			}
			System.out.println();
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
