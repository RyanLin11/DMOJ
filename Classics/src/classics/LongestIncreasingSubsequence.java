package classics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class LongestIncreasingSubsequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		ArrayList<Integer>list = new ArrayList<>();
		list.add(readInt());
		int last = list.get(0);
		for(int i = 1; i<n; i++) {
			int x = readInt();
			if(x<list.get(0)) {
				list.set(0, x); 
				if(list.size()==1)last = x;
			} else if(x>last) {
				list.add(x);
				last = x;
			} else {
				int in = Collections.binarySearch(list, x);
				if(in<0) in = -in-1;
				if(in>=list.size()) list.add(x);
				else list.set(in, x);
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
