package vm7wc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreePlanting {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		long[][]bit = new long[2005][2005];
		long sum = 0;
		for(int i = 0; i<N; i++) {
			int d = readInt(), r = readInt(), c = readInt(), x = readInt();
			if(d==1) {
				int pr = Math.min(2000,r+c-1), pc = Math.max(1, pr-2000+1);
				int pos = c-pc+1;
				for(int j = pos; pr-j+1>0 && pc+j-1<=2000; j+=j&(-j)) {
					bit[pr-j+1][pc+j-1] += x;
				}
			} else {
				int r1 = r-x, c1 = c+x;
				int pr = Math.min(2000, r1+c1-1), pc = Math.max(1, pr-2000+1), pos = c1-pc+1;
				long sum1 = 0;
				for(int j = pos; j>0; j-=j&(-j)) {
					sum1 += bit[pr-j+1][pc+j-1];
				}
				int r2 = r+1, c2 = c-1;
				int pr2 = Math.min(2000, r2+c2-1), pc2 = Math.max(1, pr2-2000+1), pos2 = c2-pc2+1;
				long sum2 = 0;
				for(int j = pos2; j>0; j-=j&(-j)) {
					sum2 += bit[pr2-j+1][pc2+j-1];
				}
				sum+=sum1-sum2;
			}
		}
		System.out.println(sum%1000000007);
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
