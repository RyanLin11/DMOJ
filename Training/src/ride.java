/*
ID: ryanlin1
LANG: JAVA
PROG: ride
*/
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.*;

public class ride {
	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		char[]s = next().toCharArray();
		char[]t = next().toCharArray();
		int a = 1;
		for(int i = 0; i<s.length; i++) {
			a*=(s[i]-'A'+1);
		}
		int b = 1;
		for(int i = 0; i<t.length; i++) {
			b*=(t[i]-'A'+1);
		}
		if(a%47==b%47) pw.println("GO");
		else pw.println("STAY");
		pw.close();
		br.close();
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
