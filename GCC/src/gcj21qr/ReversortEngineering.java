package gcj21qr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ReversortEngineering {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for(int t = 1; t<=T; t++) {
			int n = readInt(), c = readInt();
			System.out.print("Case #"+t+":");
			//impossible case
			if(c < n-1 || c >= (n * n + n)/2) {
				System.out.println(" IMPOSSIBLE");
				continue;
			}
			//create list
			ArrayList<Integer>list = new ArrayList<>();
			list.add(1);
			for(int i = 2; i<=n; i++) {
				int l = 0, r = list.size(), idx = list.size();
				for(int j = 0; l <= r && c - (n - i)> 0; j++, c--) {
					if(j % 2 == 0) {
						//add to right
						idx = r;
						r--;
					} else {
						//add to left
						idx = l;
						l++;
					}
				}
				if(idx == list.size()) list.add(i);
				else list.add(idx, i);
			}
			//display list
			for(int i: list) {
				System.out.print(" "+i);
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
