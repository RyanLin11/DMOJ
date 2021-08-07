package wc18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class GymTour {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[]list;
	static boolean[]gym;
	static int[]sum, depth;
	public static void main(String[] args) throws IOException {
		int N = readInt(), K = readInt(), F = readInt();
		list = new ArrayList[N+1];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		gym = new boolean[N+1];
		sum = new int[N+1];
		depth = new int[N+1];
		for(int i = 0; i<K; i++) {
			gym[readInt()] = true;
		}
		for(int i = 0; i<N-1; i++) {
			int a = readInt(), b = readInt();
			list[a].add(b);
			list[b].add(a);
		}
		//answer generation
		f(1, -1);
		int first = sum[1] - max(depth);
		sum = new int[N+1];
		gym[F] = true;
		g(1, -1);
		int second = sum[1];
		System.out.println(Math.min(first, second));
	}
	public static boolean f(int u, int prev) {
		boolean flag = false;
		for(int v: list[u]) {
			if(v != prev) {
				if(f(v, u)) {
					sum[u] += sum[v];
					depth[u] = Math.max(depth[u], depth[v]);
					flag = true;
				}
			}
		}
		if((flag || gym[u]) && u != 1) {
			sum[u] += 2;
			depth[u]++;
		}
		return flag || gym[u];
	}
	public static int max(int[]arr) {
		int max = 0;
		for(int i = 0; i<arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		return max;
	}
	public static boolean g(int u, int prev) {
		boolean flag = false;
		for(int v: list[u]) {
			if(v != prev) {
				if(g(v, u)) {
					sum[u] += sum[v];
					flag = true;
				}
			}
		}
		if((flag || gym[u]) && u != 1) {
			sum[u]++;
		}
		return flag || gym[u];
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
