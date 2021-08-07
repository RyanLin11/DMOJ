package ccc00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Calendar {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int d = readInt();
		System.out.println("Sun Mon Tue Wed Thr Fri Sat");
		ArrayList<String>list = new ArrayList<>();
		for(int i = 0; i<n-1; i++) {
			list.add("   ");
		}
		for(int i = 1; i<=d; i++) {
			if(Integer.toString(i).length()==1) list.add("  "+i);
			else list.add(" "+Integer.toString(i));
		}
		while(!list.isEmpty()) {
			String s = "";
			for(int i = 0; i<7 && !list.isEmpty(); i++) {
				s+=list.get(0);
				if(i!=6 && list.size()!=1)s+=" ";
				list.remove(0);
			}
			System.out.println(s);
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
