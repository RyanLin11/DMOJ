package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coins {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		double[]arr = new double[n+1];
		arr[1] = readDouble();
		arr[0] = 1-arr[1];
		for(int i = 1; i<n; i++) {
			double h = readDouble();
			double t = 1-h;
			arr[i+1] = h*arr[i];
			for(int j = i; j>0; j--) {
				arr[j] = h*arr[j-1]+t*arr[j];
			}
			arr[0] = t*arr[0];
		}
		double count = 0;
		for(int i = n; i>=(n/2)+1; i--) {
			count+=arr[i];
		}
		System.out.println(count);
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
