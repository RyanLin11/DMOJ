package ccc02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheStudentsCouncilBreakfast {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int ap = readInt();
		int bp = readInt();
		int cp = readInt();
		int dp = readInt();
		int target = readInt();
		int combo = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<=(target/ap); i++) {
			for(int j = 0; j<=(target/bp); j++) {
				for(int k = 0; k<=(target/cp); k++) {
					for(int l = 0; l<=(target/dp); l++) {
						if(ap*i+bp*j+cp*k+l*dp==target) {
							System.out.println("# of PINK is "+i+" # of GREEN is "+j+" # of RED is "+k+" # of ORANGE is "+l);
							min = Math.min(min, i+j+k+l);
							combo++;
						}
					}
				}
			}
		}
		System.out.println("Total combinations is "+combo+".");
		System.out.println("Minimum number of tickets to print is "+min+".");
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
