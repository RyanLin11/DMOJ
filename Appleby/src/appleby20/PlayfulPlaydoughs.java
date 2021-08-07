package appleby20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PlayfulPlaydoughs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), Q = readInt();
		long[]arr = new long[100001];
		for(int i = 0; i<N; i++) {
			arr[readInt()]++;
		}
		for(int i = 0; i<Q; i++) {
			int d = readInt();
			int x = readInt();
			if(d == 1) {
				long a = arr[x];
				int y = x / 2;
				int z = x - y;
				arr[y] += a;
				arr[z] += a;
				arr[x] -= a;
			} else {
				System.out.println(arr[x]);
			}
			/*for(int j = 0; j<6; j++) {
				System.out.print(arr[j]+" ");
			}
			System.out.println();*/
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
