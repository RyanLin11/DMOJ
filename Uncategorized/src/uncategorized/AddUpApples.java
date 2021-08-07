package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class AddUpApples {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>list;
	static int x, count = 0;
	public static void main(String[] args) throws IOException {
		x = readInt();
		list = new ArrayList<>();
		f(x,1);
		System.out.println("total="+count);
	}
	public static void f(int n, int prev) {
		if(n==0 && list.size()>1) {
			count++;
			System.out.print(x+"="+list.get(0));
			for(int i = 1; i<list.size(); i++) {
				System.out.print("+"+list.get(i));
			}
			System.out.println();
			return;
		}
		for(int i = prev; i<=n; i++) {
			list.add(i);
			f(n-i,i);
			list.remove(list.size()-1);
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
