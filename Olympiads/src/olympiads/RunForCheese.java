package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class RunForCheese {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[][][]dp;
	static long[]pos;
	static int n, l, u;
	public static void main(String[]args) throws IOException {
		n = readInt(); l = readInt();
		pos = new long[n+1];
		dp = new long[2][n+1][n+1];
		for(int i = 0; i<n; i++) {
			pos[i] = readInt();
		}
		pos[n] = l;
		Arrays.sort(pos);
		u = Arrays.binarySearch(pos, l);
		//transitions
		//dpl[i][j] = Math.max(pos[i+1]-pos[i]+arrlf[i+1][j]+dpl[i+1][j], pos[j]-pos[i]+arrrt[i+1][j]+dpr[i+1][j]);
		//dpr[i][j] = Math.max(pos[j]-pos[i]+arrlf[i][j-1]+dpl[i][j-1], pos[j]-pos[j-1]+arrrt[i][j-1]+dpr[i][j-1]);
		System.out.println(Math.min(f(0,0,n),f(1,0,n)));
	}
	//lf = 0 if left, lf = 1 if right
	public static long f(int lf, int i, int j) {
		if(i>j || j<u || i>u) return Long.MAX_VALUE/2;
		if(i==j)return 0;
		if(dp[lf][i][j]!=0) return dp[lf][i][j];
		if(lf==0) return dp[lf][i][j]=Math.min((n+1-(j-i))*(pos[j]-pos[i])+f(1,i+1,j), (n+1-(j-i))*(pos[i+1]-pos[i])+f(0,i+1,j));
		else return dp[lf][i][j]=Math.min((n+1-(j-i))*(pos[j]-pos[i])+f(0,i, j-1), (n+1-(j-i))*(pos[j]-pos[j-1])+f(1, i, j-1));
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
