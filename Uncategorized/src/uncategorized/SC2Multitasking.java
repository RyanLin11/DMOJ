package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SC2Multitasking {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String s1 = "qwertyuiop", s2 = "asdfghjkl", s3 = "zxcvbnm";
		int n = readInt();
		int cnt = 0;
		for(int i = 0; i<n; i++) {
			String[]arr = next().split("");
			int in = 0;
			if(s1.contains(arr[0])) in = 1;
			else if(s2.contains(arr[0])) in = 2;
			else in = 3;
			int test = 0;
			boolean same = true;
			for(int j = 1; j<arr.length; j++) {
				if(s1.contains(arr[j])) test = 1;
				else if(s2.contains(arr[j])) test = 2;
				else test = 3;
				if(test!=in) {
					same = false;
					break;
				}
			}
			if(same)cnt++;
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
