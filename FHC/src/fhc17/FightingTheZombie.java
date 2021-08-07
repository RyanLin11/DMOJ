package fhc17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FightingTheZombie {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int side;
	static double[][][]dp;
	static int[]p;
	static int[]b;
	public static void main(String[] args) throws IOException {
		//pre-processing
		p = new int[6];
		b = new int[21];
		p[0] = 4; p[1] = 6; p[2] = 8; p[3] = 10; p[4] = 12; p[5] = 20;
		b[4] = 0; b[6] = 1; b[8] = 2; b[10] = 3; b[12] = 4; b[20] = 5;
		dp = new double[6][21][421];
		for(int i = 0; i<dp.length; i++) {//side dice
			dp[i][0][0] = 1;
			for(int j = 1; j<dp[i].length; j++) {//roll
				for(int k = dp[i][j].length-1; k>=0; k--) { //prob of attaining sum
					if(dp[i][j-1][k]!=0) {
						for(int l = 1; l<=p[i]; l++) {
							dp[i][j][k+l]+=(1.0/p[i])*dp[i][j-1][k];
						}
					}
				}
			}
		}
		int t = readInt();
		for(int i = 0; i<t; i++) {
			int h = readInt();
			int s = readInt();
			double max = 0;
			for(int j = 0; j<s; j++) {
				String nxt = next();
				int in = -1;
				String str; int c;
				if(nxt.contains("+")) {
					in = nxt.indexOf("+");
					c = Integer.parseInt(nxt.substring(in, nxt.length()));
					str = nxt.substring(0,in);
				} else if(nxt.contains("-")) {
					in = nxt.indexOf("-");
					c = Integer.parseInt(nxt.substring(in, nxt.length()));
					str = nxt.substring(0, in);
				} else {
					c = 0;
					str = nxt;
				}
				String[]a2 = str.split("d");
				int roll = Integer.parseInt(a2[0]);
				int side = Integer.parseInt(a2[1]);
				double sum = 0;
				for(int k = Math.max(h-c, 0); k<401; k++) {
					sum+=dp[b[side]][roll][k];
				}
				max = Math.max(max, sum);
			}
			System.out.println("Case #"+(i+1)+": "+max);
		}
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
