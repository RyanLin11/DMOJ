package valentine18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CtudorsCuteOrchids {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][]arr;
	static int[]c, deal;
	static int n, m;
	public static void main(String[] args) throws IOException {
		n = readInt(); m = readInt();
		arr = new int[m][n];
		c = new int[n];
		deal = new int[m];
		int[]pres = new int[n];
		for(int i = 0; i<c.length; i++) {
			c[i] = readInt();
		}
		for(int i = 0; i<arr.length; i++) {
			deal[i] = readInt();
			for(int j = 0; j<arr[i].length; j++) {
				arr[i][j] = readInt();
			}
		}
		for(int i = 0; i<n; i++) {
			pres[i] = readInt();
		}
		System.out.println(f(pres,-1));
	}
	public static int f(int[]pres, int prev) {
		int min = remcost(pres);
		for(int i = prev+1; i<m; i++) {
			if(apply(arr[i],pres)) {
				min = Math.min(min,deal[i]+f(pres, i));
				revert(arr[i],pres);
			}
		}
		return min;
	}
	public static boolean apply(int[]amt, int[]pres) {
		boolean neg = false;
		for(int i = 0; i<pres.length; i++) {
			pres[i]-=amt[i];
			if(pres[i]<0) neg = true;
		}
		if(neg) {
			revert(amt, pres);
			return false;
		} else {
			return true;
		}
	}
	public static void revert(int[]amt, int[]pres) {
		for(int i = 0; i<pres.length; i++) {
			pres[i]+=amt[i];
		}
	}
	public static int remcost(int[]pres) {
		int sum = 0;
		for(int i = 0; i<pres.length; i++) {
			sum+=pres[i]*c[i];
		}
		return sum;
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
