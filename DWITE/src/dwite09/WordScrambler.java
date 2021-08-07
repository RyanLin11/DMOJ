package dwite09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class WordScrambler {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<String>ans;
	public static void main(String[] args) throws IOException {
		for(int j = 0; j<5; j++) {
			char[]c = next().toCharArray();
			ArrayList<Character>list = new ArrayList<>();
			for(int i = 0; i<c.length; i++) list.add(c[i]);
			ans = new ArrayList<>();
			f(list, new ArrayList<>());
			Collections.sort(ans);
			for(int i = 0; i<ans.size(); i++) System.out.println(ans.get(i));
		}
	}
	public static void f(ArrayList<Character>pick, ArrayList<Character>chosen) {
		if(pick.isEmpty()) {
			String str = "";
			for(int i = 0; i<chosen.size(); i++) str+=chosen.get(i);
			ans.add(str);
		}
		for(int i = 0; i<pick.size(); i++) {
			char c = pick.remove(0);
			chosen.add(c);
			f(pick, chosen);
			chosen.remove(chosen.size()-1);
			pick.add(c);
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
