package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Raytracing {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		int[]arr = new int[N+1];
		for(int i = 1; i<=N; i++) {
			arr[i] = readInt()+1;
		}
		int[][]bit = construct(arr);
		int Q = readInt();
		for(int i = 0; i<Q; i++) {
			int id = readInt();
			if(id==1) {
				int l = readInt()+1, r = readInt()+1, a = readInt()+1, b = readInt()+1;
				System.out.println(query(bit,l,r,a,b));
			} else {
				int idx = readInt()+1, h = readInt()+1;
				update(arr, bit, idx, h);
			}
		}
	}
	public static int[][] construct(int[]arr) {
		int[][]bit = new int[arr.length][arr.length];
		for(int i = 1; i<arr.length; i++) {
			add(arr, bit, i, arr[i]);
		}
		return bit;
	}
	public static void update(int[]arr, int[][]bit, int pos, int val) {
		add(arr, bit, pos, val);
		remove(arr, bit, pos, val);
		arr[pos] = val;
	}
	public static void add(int[]arr, int[][]bit, int pos, int val) {
		for(int i = val; i<bit.length; i+=i&(-i)) {
			for(int j = pos; j<bit[i].length; j+=j&(-j)) {
				bit[i][j]++;
			}
		}
	}
	public static void remove(int[]arr, int[][]bit, int pos, int val) {
		for(int i = arr[pos]; i<bit.length; i+=i&(-i)) {
			for(int j = pos; j<bit[i].length; j+=j&(-j)) {
				bit[i][j]--;
			}
		}
	}
	//sum(b, r) - sum(b, l-1) - (sum(a-1, r) - sum(a-1, l-1))
	public static int sum(int[][]bit, int pos1, int pos2) {
		int sum = 0;
		for(int i = pos1; i>0; i-=i&(-i)) {
			for(int j = pos2; j>0; j-=j&(-j)) {
				sum += bit[i][j];
			}
		}
		return sum;
	}
	public static int query(int[][]bit, int l, int r, int a, int b) {
		return sum(bit,b,r) - sum(bit,b,l-1) - sum(bit,a-1,r) + sum(bit,a-1,l-1);
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
