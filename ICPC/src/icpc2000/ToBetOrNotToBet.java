package icpc2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.text.DecimalFormat;
import java.util.Arrays;

public class ToBetOrNotToBet {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		DecimalFormat df = new DecimalFormat("0.0000");
		for(int i = 0; i<n; i++) {
			int m = readInt();
			int t = readInt();
			int[]ins = new int[m+3];
			String[]s = readLine().split(" ");
			for(int j = 0; j<s.length; j++) {
				if(s[j].equals("L")) ins[j+1] = Integer.MIN_VALUE;
				else ins[j+1] = Integer.parseInt(s[j]);
			}
			double[]dpr = new double[m+3];
			double[]dpc = new double[m+3];
			double[]hold = new double[m+3];//temp holding for skipped turn
			double[]holdfill = new double[m+3];
			dpr[0] = 1;
			for(int j = 0; j<t; j++) {
				for(int k = 0; k<=m; k++) {
					if(ins[k+1]==Integer.MIN_VALUE)holdfill[k+1] += 0.5*dpr[k];
					else dpc[k+1+ins[k+1]] += 0.5*dpr[k];
					if(ins[k+2]==Integer.MIN_VALUE)holdfill[k+2]+=0.5*dpr[k]; 
					else dpc[k+2+ins[k+2]]+= 0.5*dpr[k];
				}
				for(int k = 0; k<holdfill.length; k++) {
					dpc[k] += hold[k];
					hold[k] = holdfill[k];
				}
				dpc[m+1]+=dpr[m+1];dpc[m+2]+=dpr[m+2];
				dpr = dpc;
				holdfill = new double[m+3];
				dpc = new double[m+3];
			}
			double ans = dpr[m+1]+dpr[m+2];
			double y = Math.round(ans*10000)/10000.0;
			if(ans<0.5) {
				System.out.println("Bet against. "+df.format(y));
			} else if(ans>0.5) {
				System.out.println("Bet for. "+df.format(y));
			} else {
				System.out.println("Push. "+df.format(y));
			}
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
