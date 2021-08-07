package vm7wc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class GGG {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[]arr = new int[1000001];
		for(int i = 0; i<n; i++) {
			arr[readInt()]=i+1;
		}
		int m = readInt();
		ArrayList<Integer>list = new ArrayList<>();
		for(int i = 0; i<m; i++) {
			int y = readInt();
			if(arr[y]==0) continue;
			int x = arr[y];
			if(list.isEmpty()||x>list.get(list.size()-1)) {
				list.add(x);
			} else {
				int u = Collections.binarySearch(list, x);
				if(u<0) {
					u = -u-1;
					list.set(u, x);
				}
			}
		}
		System.out.println(list.size());
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
