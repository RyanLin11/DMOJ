package ichb17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ParallelUniverse {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][]bit;
	static long[]arr;
	public static void main(String[] args) throws IOException {
		int N = readInt(), Q = readInt();
		bit = new int[32][N+1];
		arr = new long[N+1];
		for(int i = 1; i<=N; i++) {
			arr[i] = readLong();
			construct(i, arr[i]);
		}
		for(int i = 0; i<Q; i++) {
			char c = readCharacter();
			if(c=='U') {
				int x = readInt(); long val = readLong();
				updateHelper(x, val);
				arr[x] = val;
			} else {
				queryHelper(readInt(), readInt(), readLong());
			}
		}
	}
	public static void construct(int x, long val) {
		for(int i = 0; i<32; i++) {
			if(((val>>i)&1) == 0) {
				for(int j = x; j<bit[i].length; j+=j&(-j)) {
					bit[i][j]++;
				}
			}
		}
	}
	public static void updateHelper(int x, long val) {
		for(int i = 0; i<32; i++) {
			long pre = (arr[x]>>i) & 1;
			long cur = (val>>i) & 1;
			if(pre==0 && cur==1) {
				update(i, x, -1);
			} else if(pre==1 && cur==0) {
				update(i, x, 1);
			}
		}
	}
	public static void update(int in, int x, int d) {
		for(int i = x; i<bit[in].length; i+=i&(-i)) {
			bit[in][i] += d;
		}
	}
	public static void queryHelper(int l, int r, long val) {
		long ans = 0;
		for(int i = 0; i<32; i++) {
			if(query(i,r)-query(i,l-1)==0) {
				ans |= ((val>>i) & 1)<<i;
			}
		}
		System.out.println(ans);
	}
	public static int query(int in, int x) {
		int sum = 0;
		for(int i = x; i>0; i-=i&(-i)) {
			sum += bit[in][i];
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
