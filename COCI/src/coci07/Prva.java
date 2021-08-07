package coci07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Prva {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int r = readInt(), c = readInt();
		char[][]arr = new char[r][c];
		for(int i = 0; i<r; i++) {
			arr[i] = next().toCharArray();
		}
		ArrayList<String>list = new ArrayList<>();
		//horizontally
		for(int i = 0; i<r; i++) {
			String s = "";
			for(int j = 0; j<c; j++) s+=arr[i][j];
			String[]str = s.split("#");
			for(int j = 0; j<str.length; j++) {
				if(str[j].length()>1)list.add(str[j]);
			}
		}
		//vertically
		for(int j = 0; j<c; j++) {
			String s = "";
			for(int i = 0; i<r; i++) s+=arr[i][j];
			String[]str = s.split("#");
			for(int i = 0; i<str.length; i++) {
				if(str[i].length()>1)list.add(str[i]);
			}
		}
		Collections.sort(list);
		System.out.println(list.get(0));
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
