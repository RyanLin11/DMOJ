package ccc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.text.DecimalFormat;

public class ArrivalTime {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		DecimalFormat df = new DecimalFormat("00");
		String s = next();
		int h = Integer.parseInt(s.split(":")[0]);
		int m = Integer.parseInt(s.split(":")[1]);
		int min = 60*h+m;
		if(min>1140) {
			System.out.println(df.format((h+2)%24)+":"+df.format(m));
			return;
		}
		double dist = 120.0;
		double time = 0;
		double[]speed = new double[1440];
		Arrays.fill(speed, 1);
		Arrays.fill(speed, 420,599, 0.5);
		Arrays.fill(speed, 900,1139,0.5);
		for(int i = min; dist>0; i++) {
			dist-=speed[i];
			time++;
		}
		System.out.println(df.format((int)((min+time)/60))+":"+df.format((min+time)%60));
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
