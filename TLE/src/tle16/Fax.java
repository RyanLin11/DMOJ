package tle16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Arrays;

public class Fax {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, u;
	static long max;
	static long[][][]dis;
	static long[]pos, pi, psa;
	public static void main(String[] args) throws IOException {
		n = readInt();
		dis = new long[2][n+1][n+1];
		pos = new long[n]; 
		pi = new long[n];
		psa = new long[n+1];
		HashMap<Long, Long>map = new HashMap<>();
		for(int i = 0; i<n; i++) {
			pos[i] = readLong();
			map.put(pos[i], readLong());
		}
		Arrays.sort(pos);
		u = Arrays.binarySearch(pos, 0);
		for(int i = 0; i<n; i++) {
			pi[i] = map.get(pos[i]);
			psa[i+1] = psa[i]+pi[i];
		}
		max = pi[u];
		f(0,0,n-1); f(1,0,n-1);
		System.out.println(max);
	}
	public static long f(int lf, int i, int j) {
		if(i>j||i>u||j<u) return Long.MAX_VALUE/2;
		if(i==j) return 0;
		if(dis[lf][i][j]!=0) return dis[lf][i][j];
		long ans = 0;
		if(lf==0) {
			ans= Math.min(pos[i+1]-pos[i]+f(0,i+1,j), pos[j]-pos[i]+f(1,i+1,j));
			if(ans<=psa[j+1]-psa[i+1]) {
				max = Math.max(max, psa[j+1]-psa[i]);
			} else {
				return dis[lf][i][j]=Long.MAX_VALUE/2;
			}
		} else {
			ans= Math.min(pos[j]-pos[j-1]+f(1,i,j-1), pos[j]-pos[i]+f(0,i,j-1));
			if(ans<=psa[j]-psa[i]) {
				max = Math.max(max, psa[j+1]-psa[i]);
			} else {
				return dis[lf][i][j]=Long.MAX_VALUE/2;
			}
		}
		return dis[lf][i][j]=ans;
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
