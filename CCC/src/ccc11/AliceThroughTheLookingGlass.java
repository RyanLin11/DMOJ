package ccc11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AliceThroughTheLookingGlass {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int m, xa, ya;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for(int i = 0; i<t; i++) {
			m = readInt(); xa = readInt(); ya = readInt();
			//System.out.println(f(1,1,1)||f(1,2,2)||f(1,3,1));
			System.out.println(g(1,1,2,0,1)||g(1,2,3,1,2)||g(1,3,4,0,1)?"crystal":"empty");
		}
	}
	public static boolean f(int n, int x, int y) {
		System.out.println(n+" "+x+" "+y);
		if(n==m) return x==xa && ya<=y-1;
		return f(n+1, x*5+1,y*5+1)||f(n+1, x*5+2,y*5+2)||f(n+1, x*5+3,y*5+1);
	}
	public static boolean g(int n, int x1, int x2, int y1, int y2) {
		//System.out.println(n+" "+x1+" "+x2+" "+y1+" "+y2);
		if(n==m) return x1<=xa && xa<x2 && ya<y2;
		boolean flag = false;
		flag=flag||g(n+1,x1*5, x2*5, y1*5,y2*5); //original block
		flag=flag||g(n+1,x1*5+1, x1*5+2, y2*5, y2*5+1); //left top
		flag=flag||g(n+1,x1*5+2, x1*5+3, y2*5+1, y2*5+2); //center top
		flag=flag||g(n+1,x1*5+3, x1*5+4, y2*5, y2*5+1); //right top
		return flag;
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
