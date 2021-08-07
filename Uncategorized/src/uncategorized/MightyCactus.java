package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class MightyCactus {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		double N = readInt();
		int M = readInt(), K = readInt();
		double[]a = new double[K];
		int[]t = new int[K];
		for(int i = 0; i<K; i++) {
			t[i] = readInt();
			a[i] = readDouble()/100;
		}
		int[]arr = new int[200002];
		for(int i = 0; i<M; i++) {
			int s = readInt(), l = readInt(), x = readInt();
			arr[s]+=x;
			arr[s+l]-=x;
		}
		for(int i = 1; i<arr.length; i++) arr[i]+=arr[i-1];
		for(int i = 0; i<arr.length; i++) {
			double min = Double.MAX_VALUE;
			for(int j = 0; j<K; j++) {
				min = Math.min(min, (arr[i]-t[j])*(1-a[j]));
			}
			min = Math.max(min,0);
			N-=min;
		}
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(N>0?df.format(Math.round(N*100)/100.0):"Act Like A Cactus.");
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
