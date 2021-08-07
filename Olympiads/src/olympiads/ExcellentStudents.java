package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class ExcellentStudents {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][]arr;
	static int[]bit;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		arr = new int[N+1][3];
		for(int i = 0; i<3; i++) arr[0][i] = Integer.MAX_VALUE;
		for(int i = 0; i<3; i++) {
			for(int j = 1; j<=N; j++) {
				arr[readInt()][i] = j;
			}
		}
		Integer[]id = new Integer[N+1];
		for(int i = 0; i<id.length; i++) {
			id[i] = i;
		}
		Arrays.sort(id, new sortByIndex());
		bit = new int[N+1];
		Arrays.fill(bit, Integer.MAX_VALUE);
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			if(query(arr[id[i]][1])> arr[id[i]][2]) {
				cnt++;
			}
			update(arr[id[i]][1], arr[id[i]][2]);
		}
		System.out.println(cnt);
	}
	public static void update(int x, int val) {
		for(int i = x; i<bit.length; i+=i&(-i)) {
			bit[i] = Math.min(bit[i], val);
		}
	}
	public static int query(int x) {
		int min = Integer.MAX_VALUE;
		for(int i = x; i>0; i-=i&(-i)) {
			min = Math.min(min, bit[i]);
		}
		return min;
	}
	public static class sortByIndex implements Comparator<Integer>{
		public int compare(Integer a, Integer b) {
			return Integer.compare(arr[a][0], arr[b][0]);
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
