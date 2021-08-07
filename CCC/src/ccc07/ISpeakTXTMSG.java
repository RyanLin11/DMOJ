package ccc07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class ISpeakTXTMSG {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		HashMap<String,String>map = new HashMap<>();
		map.put("CU","see you");
		map.put(":-)","I'm happy");
		map.put(":-(","I'm unhappy");
		map.put(";-)","wink");
		map.put(":-P","stick out my tongue");
		map.put("(~.~)","sleepy");
		map.put("TA","totally awesome");
		map.put("CCC","Canadian Computing Competition");
		map.put("CUZ","because");
		map.put("TY","thank-you");
		map.put("YW","you're welcome");
		map.put("TTYL","talk to you later");
		String s = "";
		do {
			s = next();
			if(map.containsKey(s)) {
				System.out.println(map.get(s));
			} else {
				System.out.println(s);
			}
		} while(!s.equals("TTYL"));
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
