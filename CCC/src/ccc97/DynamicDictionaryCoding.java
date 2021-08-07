package ccc97;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class DynamicDictionaryCoding {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		for(int i = 0; i<n; i++) {
			boolean flag = true;
			HashMap<String, Integer>map = new HashMap<>();
			while(flag) {
				String s = readLine();
				String[]words = s.split(" ");
				for(int j = 0; j<words.length; j++) {
					if(map.containsKey(words[j])) {
						words[j] = Integer.toString(map.get(words[j]));
					} else {
						map.put(words[j], map.size() + 1);
					}
				}
				if(s.isEmpty()) flag = false;
				System.out.println(String.join(" ", words));
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
