package bts18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class TheGoldenPorcupine {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), t = readInt();
		long[]constant = new long[t+2];
		long[][]linear = new long[2][t+2];
		long[][]quadratic = new long[3][t+2];
		for(int i = 0; i<n; i++) {
			int l = readInt(), r = readInt(), a = readInt(), b = readInt(), c = readInt();
			constant[l]+=c; constant[r+1]-=c;
			if(l!=r) {
				linear[0][l+1]+=b; linear[0][r+1]-=b; 
				linear[1][r+1]-=b*(r-l);
				quadratic[0][l+2]+=2*a; quadratic[0][r+1]-=2*a;
				quadratic[1][l+1]+=a; quadratic[1][r+1]-=a*(2*(r-l)-1);
				quadratic[2][r+1]-=a*Math.pow(r-l, 2);
			}
		}
		for(int i = 1; i<t+2; i++) constant[i]+=constant[i-1];
		for(int i = 1; i<t+2; i++) {
			linear[0][i]+=linear[0][i-1];
			linear[1][i]+=linear[1][i-1]+linear[0][i];
		}
		for(int i = 1; i<t+2; i++) {
			quadratic[0][i]+=quadratic[0][i-1];
			quadratic[1][i]+=quadratic[1][i-1]+quadratic[0][i];
			quadratic[2][i]+=quadratic[2][i-1]+quadratic[1][i];
		}
		for(int i = 1; i<=t; i++) {
			System.out.print(constant[i]+linear[1][i]+quadratic[2][i]+" ");
		}
		/*System.out.println();
		System.out.println("constant");
		System.out.println(Arrays.toString(constant));
		System.out.println("linear");
		System.out.println(Arrays.toString(linear[0]));
		System.out.println(Arrays.toString(linear[1]));
		System.out.println("quadratic");
		System.out.println(Arrays.toString(quadratic[0]));
		System.out.println(Arrays.toString(quadratic[1]));
		System.out.println(Arrays.toString(quadratic[2]));*/
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
