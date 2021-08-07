package dwite12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MagicTrick {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for(int q = 0; q<5; q++) {
			int n = readInt();
			ArrayList<Integer>list = new ArrayList<>();
			ArrayList<Integer>ans = new ArrayList<>();
			boolean impossible = false;
			for(int i = n; i>0; i--) list.add(i);
			for(int i = 0; i<n; i++) {
				int x = readInt();
				if(x>=list.size()) {
					impossible = true;
				} else if(!impossible){
					ans.add(list.get(x));
					list.remove(x);
				}
			}
			if(impossible) {
				System.out.println("IMPOSSIBLE");
			} else {
				for(int i = 0; i<ans.size(); i++) {
					System.out.print(ans.get(i)+" ");
				}
				System.out.println();
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
