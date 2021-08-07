package bts19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Parkour {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int X = readInt(), Y = readInt(), H = readInt(), V = readInt();
		int T = readInt();
		for(int i = 0; i<T; i++) {
			//vertical section
			double y = 0.5*X + i*1.5;
			if(Y<=y && y<= Y+V && (X-i)%2==0 && i+(X-i)/2 < T) {
				System.out.println("YES");
				return;
			}
			//horizontal section
			double x = (Y - i*1.5) / 0.5;
			if(X<= x && x<=X+H && (x-i)%2==0 && i+(x-i)/2 < T) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
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
