package coci06;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class Bond {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		double[][]arr = new double[n][n];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				arr[i][j] = readInt()/100.0;
			}
		}
		double[]mem = new double[(int)Math.pow(2, n)];
		mem[0] = 1;
		for(int i = 0; i<mem.length; i++) {
			ArrayList<Integer>set = new ArrayList<>();
			int count = 0;
			for(int j = 0; j<n; j++) {
				int t = i&(1<<j);
				if(t==0) {
					set.add(j);
				} else {
					count++;
				}
			}
			for(int j: set) {
				mem[i|(1<<j)] = Math.max(mem[i|(1<<j)], arr[count][j]*mem[i]);
			}
		}
		System.out.println(mem[mem.length-1]*100);
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
