package dmopc19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Selection {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt();
		int[]arr = new int[N+1];
		for(int i = 1; i<=N; i++) {
			arr[i] = readInt();
		}
		int[][]bit = construct(arr);
		for(int i = 0; i<M; i++) {
			int x = readInt();
			if(x==1) {
				int a = readInt(), b = readInt();
				update(arr, bit, a, b);
				arr[a] = b;
			} else {
				int l = readInt(), r = readInt(), c = readInt();
				System.out.println(query(bit, l, r, c));
			}
		}
	}
	public static int[][] construct(int[]arr) {
		int[][]bit = new int[arr.length][21];
		for(int i = 1; i<bit.length; i++) {
			for(int j = i; j<bit.length; j+=j&(-j)) {
				bit[j][arr[i]]++;
			}
		}
		return bit;
	}
	public static void update(int[]arr, int[][]bit, int index, int val) {
		for(int i = index; i<bit.length; i+=i&(-i)) {
			bit[i][arr[index]]--;
			bit[i][val]++;
		}
	}
	public static int[] sum(int[][]bit, int pos) {
		int[]ans = new int[bit[0].length];
		for(int i = pos; i>0; i-=i&(-i)) {
			for(int j = bit[i].length-1; j>=0; j--) {
				ans[j] += bit[i][j];
			}
		}
		return ans;
	}
	public static int query(int[][]bit, int l, int r, int k) {
		int[]ans1 = sum(bit, r);
		int[]ans2 = sum(bit, l-1);
		int sum = 0;
		for(int i = ans1.length-1; i>=0; i--) {
			sum+=ans1[i]-ans2[i];
			if(sum>=k) return i;
		}
		return 0;
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
