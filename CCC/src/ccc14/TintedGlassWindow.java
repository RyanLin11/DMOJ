package ccc14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TintedGlassWindow {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		int T = readInt();
		TreeMap<Integer, Integer>row = new TreeMap<>();
		TreeMap<Integer, Integer>col = new TreeMap<>();
		int[]row1 = new int[N];
		int[]col1 = new int[N];
		int[]row2 = new int[N];
		int[]col2 = new int[N];
		int[]tint = new int[N];
		for(int i = 0; i<N; i++) {
			col1[i] = readInt();
			row1[i] = readInt();
			col2[i] = readInt();
			row2[i] = readInt();
			tint[i] = readInt();
			row.put(row1[i], 0); row.put(row2[i], 0);
			col.put(col1[i], 0); col.put(col2[i], 0);
		}
		//assign sorted values to arrays (index -> value)
		long[]rows = new long[row.size()];
		long[]cols = new long[col.size()];
		int cnt = 0;
		for(int r: row.keySet()) {
			rows[cnt] = r;
			cnt++;
		}
		cnt = 0;
		for(int c: col.keySet()) {
			cols[cnt] = c;
			cnt++;
		}
		//map row coordinates to array index values (value -> index)
		cnt = 0;
		for(int r: row.keySet()) {
			row.put(r, cnt);
			cnt++;
		}
		cnt = 0;
		for(int c: col.keySet()) {
			col.put(c, cnt);
			cnt++;
		}
		//range updates
		int[][]arr = new int[row.size()+1][col.size()+1];
		for(int i = 0; i<N; i++) {
			arr[row.get(row1[i])][col.get(col1[i])]+=tint[i];
			arr[row.get(row1[i])][col.get(col2[i])]-=tint[i];
			arr[row.get(row2[i])][col.get(col1[i])]-=tint[i];
			arr[row.get(row2[i])][col.get(col2[i])]+=tint[i];
		}
		//do horizontal psa
		for(int i = 0; i<arr.length; i++) {
			for(int j = 1; j<arr[i].length; j++) {
				arr[i][j] += arr[i][j-1];
			}
		}
		//do vertical psa
		for(int i = 1; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				arr[i][j] += arr[i-1][j];
			}
		}
		//calculate
		long sum = 0;
		for(int i = 0; i<arr.length-1; i++) {
			for(int j = 0; j<arr[i].length-1; j++) {
				if(arr[i][j] >= T) sum += (rows[i+1] - rows[i]) * (cols[j+1] - cols[j]);
			}
		}
		System.out.println(sum);
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
