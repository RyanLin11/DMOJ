package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BobAndBusStops {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		int[]arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = readInt();
		}
		Arrays.sort(arr);
		for(int i = 0; i<q; i++) {
			int l = readInt(), r = readInt();
			int u = Arrays.binarySearch(arr,l);
			int v = Arrays.binarySearch(arr, r);
			int ans = 0;
			if(u>=0 && v>=0) {
				ans = v-u+1;
			} else if(u>=0){
				v = -v-1;
				ans = v-u;
			} else if(v>=0) {
				u = -u-1;
				ans = v-u+1;
			} else {
				v = -v-1;
				u= -u-1;
				ans = v-u;
			}
			System.out.println(ans);
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
