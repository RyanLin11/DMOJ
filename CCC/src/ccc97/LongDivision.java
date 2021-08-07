package ccc97;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongDivision {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		for(int i = 0; i<n; i++) {
			String[]sa = next().split("");
			String[]sb = next().split("");
			int[]a = new int[sa.length];
			int[]b = new int[sb.length];
			for(int j = 0; j<sa.length; j++) a[j] = Integer.parseInt(sa[j]);
			for(int j = 0; j<sb.length; j++) b[j] = Integer.parseInt(sb[j]);
			String ans = "";
			int digit = 0;
			for(int j = 0; j+b.length<=a.length; j++) {
				int cnt = 0;
				if(a[digit]==0) digit++;
				while(digit<j || compare(a,b,j)>=0) {
					for(int k = b.length-1; k>=0; k--) {
						if(a[k+j]<b[k]) {
							a[k+j-1]--;
							a[k+j]+=10;
						}
						a[k+j]-=b[k];
					}
					cnt++;
					if(a[digit]==0) digit++;
				}
				ans+=cnt;
				
			}
			int in = 0;
			for(int j = 0; j<ans.length(); j++) {
				if(ans.charAt(in)=='0') in++;
				else break;
			}
			System.out.println(ans.substring(in).isEmpty()?0:ans.substring(in));
			in = 0;
			for(int j = 0; j<a.length; j++) {
				if(a[j]==0) in++;
				else break;
			}
			ans = "";
			for(int j = in; j<a.length; j++) {
				ans+=a[j];
			}
			System.out.println(ans.isEmpty()?0:ans);
			if(i!=n-1) System.out.println();
		}
	}
	public static int compare(int[]a, int[]b, int offset) {
		for(int i = 0; i<b.length; i++) {
			if(a[i+offset]<b[i]) return -1;
			else if(a[i+offset]>b[i]) return 1;
		}
		return 0;
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
