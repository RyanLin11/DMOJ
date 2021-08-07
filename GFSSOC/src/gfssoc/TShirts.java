package gfssoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class TShirts {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int[]t = {readInt(),readInt(),readInt()};
		double[]p = {readDouble(),readDouble(),readDouble()};
		double cost = 0;
		int cnt = 0;
		while(t[0]+t[1]+t[2]>0) {
			for(int j = 0; j<3; j++) {
				if(t[j]!=0) {
					t[j]--;
					cnt++;
					cost+=p[j];
					break;
				}
			}
			if(t[0]+t[1]+t[2]>0 && cnt%3==0) {
				for(int j = 2; j>=0; j--) {
					if(t[j]!=0) {
						t[j]--;
						break;
					}
				}
			}
		}
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(df.format(Math.round(cost*100)/100.0));
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
