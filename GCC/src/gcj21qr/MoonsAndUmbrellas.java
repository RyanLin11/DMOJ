package gcj21qr;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MoonsAndUmbrellas {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for(int t = 1; t<=T; t++){
		    int x = readInt(); //cj
		    int y = readInt(); //jc
		    char[]c = next().toCharArray();
		    //0 = c is chosen, 1 = j is chosen
		    long[][]dp = new long[c.length][2];
		    if(c[0] == 'C') {
		    	dp[0][1] = Integer.MAX_VALUE;
		    } else if(c[0] == 'J') {
		    	dp[0][0] = Integer.MAX_VALUE;
		    }
		    for(int i = 1; i<c.length; i++){
		        if(c[i] == '?'){
		            //choose c
		            dp[i][0] = Math.min(dp[i-1][1] + y, dp[i-1][0]); //jc or cc
		            //choose j
		            dp[i][1] = Math.min(dp[i-1][0] + x, dp[i-1][1]); //cj or jj
		        } else if(c[i] == 'C'){
		            //choose c
		            dp[i][0] = Math.min(dp[i-1][1] + y, dp[i-1][0]); //jc or cc
		            dp[i][1] = Integer.MAX_VALUE;
		        } else {
		            //choose j
		            dp[i][1] = Math.min(dp[i-1][0] + x, dp[i-1][1]); //cj or jj
		            dp[i][0] = Integer.MAX_VALUE;
		        }
		    }
		    System.out.println("Case #"+t+": "+Math.min(dp[c.length-1][0], dp[c.length-1][1]));
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