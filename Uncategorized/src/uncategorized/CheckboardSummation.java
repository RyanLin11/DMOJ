package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CheckboardSummation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[][][]bit;
	public static void main(String[] args) throws IOException {
		N = readInt(); M = readInt();
		bit = new int[2][N+1][M+1];
		int r = readInt(), c = readInt(), x = readInt();
		while(r!=0) {
			update(r, c, x);
			r = readInt(); c = readInt(); x = readInt();
		}
		int r1 = readInt(), c1 = readInt(), r2 = readInt(), c2 = readInt();
		while(r1!=0) {
			System.out.println(queryHelper(r1,c1,r2,c2));
			r1 = readInt(); c1 = readInt(); r2 = readInt(); c2 = readInt();
		}
	}
	public static void update(int r, int c, int x) {
		int d = (r%2)^(c%2);
		for(int i = r; i<=N; i+=i&(-i)) {
			for(int j = c; j<=M; j+=j&(-j)) {
				bit[d][i][j] += x;
			}
		}
	}
	public static int queryHelper(int r1, int c1, int r2, int c2) {
		int x = (r1%2)^(c1%2), y = x==0? 1:0;
		return q(x,r2,c2)-q(y,r2,c2)-q(x,r2,c1-1)+q(y,r2,c1-1)-q(x,r1-1,c2)+q(y,r1-1,c2)+q(x,r1-1,c1-1)-q(y,r1-1,c1-1);
	}
	public static int q(int d, int r, int c) {
		int sum = 0;
		for(int i = r; i>0; i-=i&(-i)) {
			for(int j = c; j>0; j-=j&(-j)) {
				sum += bit[d][i][j];
			}
		}
		return sum;
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
