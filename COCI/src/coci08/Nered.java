package coci08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Nered {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt();
		ArrayList<Integer>a = new ArrayList<>();
		ArrayList<Integer>b = new ArrayList<>();
		for(int i = 1; i<=M; i++) {
			if(M%i==0) {
				a.add(i);
				b.add(M/i);
			}
		}
		int[][]psa = new int[N+1][N+1];
		for(int i = 0; i<M; i++) {
			psa[readInt()][readInt()] = 1;
		}
		for(int i = 1; i<psa.length; i++) {
			for(int j = 1; j<psa[i].length; j++) {
				psa[i][j]+=psa[i-1][j]+psa[i][j-1]-psa[i-1][j-1];
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 1; i<psa.length; i++) {
			for(int j = 1; j<psa[i].length; j++) {
				int x1 = i, y1 = j;
				for(int k = 0; k<a.size(); k++) {
					int x2 = a.get(k)+x1-1, y2 = b.get(k)+y1-1;
					if(x2>=psa.length || y2>=psa[i].length) continue;
					int sum = psa[x2][y2]-psa[x2][y1-1]-psa[x1-1][y2]+psa[x1-1][y1-1];
					min = Math.min(min, M-sum);
				}
			}
		}
		System.out.println(min);
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
