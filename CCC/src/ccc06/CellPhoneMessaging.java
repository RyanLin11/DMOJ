package ccc06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class CellPhoneMessaging {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		ArrayList<Character>[] arr = new ArrayList[8];
		int a = 97;
		for(int i = 0; i<arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i = 0; i<arr.length; i++) {
			int count = 3;
			if(i==5 ||i==7) count = 4;
			for(int j = 0; j<count; j++) {
				arr[i].add((char)(a));
				a++;
			}
		}
		String s = next();
		while(!s.equals("halt")) {
			int time = 0;
			int prev = -1;
			for(int i = 0; i<s.length(); i++) {
				char c = s.charAt(i);
				for(int j = 0; j<arr.length; j++) {
					if(arr[j].contains(c)) {
						time+=arr[j].indexOf(c)+1;
						if(j==prev) time+=2;
						prev = j;
						break;
					}
				}
				
			}
			System.out.println(time);
			s = next();
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
