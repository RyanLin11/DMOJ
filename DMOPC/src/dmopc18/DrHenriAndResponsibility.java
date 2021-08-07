package dmopc18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DrHenriAndResponsibility {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[]arr = new int[n];
		int sum = 0;
		for(int i = 0; i<n; i++) {
			arr[i] = readInt();
			sum+=arr[i];
		}
		boolean[]pos = new boolean[sum+1];
		pos[0] = true;
		for(int i = 0; i<arr.length; i++) {
			for(int j = pos.length-1; j>=0; j--) {
				if(pos[j])pos[j+arr[i]] = true;
			}
		}
		for(int i = sum/2; i>=0; i--) {
			if(pos[i]) {
				System.out.println(Math.abs(sum-2*i));
				break;
			}
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
