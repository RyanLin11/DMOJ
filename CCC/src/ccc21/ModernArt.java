package ccc21sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ModernArt {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int M = Integer.parseInt(next());
		int N = Integer.parseInt(next());
		int K = Integer.parseInt(next());
		int[]rows = new int[M];
		int[]cols = new int[N];
		for(int i = 0; i<K; i++) {
			char d = next().charAt(0);
			int x = Integer.parseInt(next())-1;
			if(d == 'R') {
				rows[x]++;
			} else {
				cols[x]++;
			}
		}
		int cnt = 0;
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				if((rows[i] + cols[j])%2 == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
}
