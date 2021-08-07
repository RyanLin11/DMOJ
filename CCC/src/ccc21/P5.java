package ccc21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(next()), M = Integer.parseInt(next());
		int[]arr = new int[N];
		Arrays.fill(arr, 1);
		int[]x = new int[M];
		int[]y = new int[M];
		int[]z = new int[M];
		for(int i = 0; i<M; i++) {
			x[i] = Integer.parseInt(next())-1;
			y[i] = Integer.parseInt(next())-1;
			z[i] = Integer.parseInt(next());
		}
		for(int i = 0; i<M; i++) {
			if(z[i] == 2) {
				for(int j = x[i]; j<=y[i]; j++) {
					arr[j] = 2;
				}
			}
		}
		for(int i = 0; i<M; i++) {
			if(z[i] == 1) {
				boolean alltwo = true;
				for(int j = x[i]; j<=y[i]; j++) {
					if(arr[j] != 2) {
						alltwo = false;
						break;
					}
				}
				if(alltwo) {
					System.out.println("Impossible");
					return;
				}
			}
		}
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
}
