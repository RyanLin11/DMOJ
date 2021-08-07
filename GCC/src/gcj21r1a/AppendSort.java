package gcj21r1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class AppendSort {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		BigInteger ten = new BigInteger("10");
		for(int t = 1; t<=T; t++) {
			int N = readInt();
			int cnt = 0;
			BigInteger last = new BigInteger("0");
			for(int i = 0; i<N; i++) {
				String s = next();
				BigInteger num = new BigInteger(s);
				//divisor
				String feed = "1";
				for(int j = 0; j<last.toString().length()-s.length(); j++) {
					feed+="0";
				}
				BigInteger div = new BigInteger(feed);
				if(s.length() < last.toString().length()) {
					cnt += last.toString().length() - s.length();
					num = num.multiply(div);
					if(num.compareTo(last) <= 0) {
						if(last.divide(div).compareTo(num.divide(div))>0) {
							num = num.multiply(ten);
							cnt++;
						} else {
							BigInteger x = last.mod(div).add(new BigInteger("1"));
							if(x.toString().length() > last.toString().length()-s.length()) {
								num = num.multiply(ten);
								cnt++;
							} else {
								num = num.add(x);
							}
						}
					}
				} else if(s.length() == last.toString().length()) {
					if(last.compareTo(num) >= 0) {
						num = num.multiply(ten);
						cnt++;
					}
				}
				last = num;
				System.out.println(last);
			}
			System.out.println("Case #"+t+": "+cnt);
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
