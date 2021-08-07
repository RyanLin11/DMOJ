package ccc09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class GoodTimes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		DecimalFormat df = new DecimalFormat("00");
		String[]city = {"Ottawa","Victoria","Edmonton","Winnipeg","Toronto","Halifax","St. John's"};
		int[]delta = {0,-180,-120,-60,0,60,90};
		String t = next();
		int min = 0;
		if(t.length()==1||t.length()==2) {
			min = Integer.parseInt(t);
		} else if(t.length()==3) {
			min = Integer.parseInt(t.substring(0,1))*60+Integer.parseInt(t.substring(1,3));
		} else if(t.length()==4) {
			min = Integer.parseInt(t.substring(0,2))*60+Integer.parseInt(t.substring(2,4));
		}
		for(int i = 0; i<city.length; i++) {
			delta[i]+=min;
			if(delta[i]<0) delta[i]+=1440;
			delta[i]%=1440;
			int hour = delta[i]/60;
			int minute = delta[i]%60;
			if(hour==0) System.out.print(minute);
			else {
				System.out.print(hour+df.format(minute));
			}
			System.out.println(" in "+city[i]);
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
