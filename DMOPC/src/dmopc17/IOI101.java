package dmopc17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class IOI101 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		char[]c = next().toCharArray();
		HashMap<Character,Character>map = new HashMap<>();
		map.put('0', 'O');
		map.put('1', 'l');
		map.put('3', 'E');
		map.put('4', 'A');
		map.put('5', 'S');
		map.put('6', 'G');
		map.put('8', 'B');
		map.put('9', 'g');
		for(int i = 0; i<c.length; i++) {
			if(map.containsKey(c[i])) System.out.print(map.get(c[i]));
			else System.out.print(c[i]);
		}
		System.out.println();
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
