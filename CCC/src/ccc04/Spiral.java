package ccc04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Spiral {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int dir, r, c, step = 0, maxstep;
	static boolean[][]arr;
	public static void main(String[] args) throws IOException {
		int W = readInt(), H = readInt(), w = readInt(), h = readInt();
		maxstep = readInt();
		arr = new boolean[H][W];
		for(int i = 0; i<h; i++) {
			for(int j = 0; j<w; j++) {
				arr[i][j] = true;
			}
		}
		for(int i = 0; i<h; i++) {
			for(int j = W-w; j<W; j++) {
				arr[i][j] = true;
			}
		}
		for(int i = H-h; i<H; i++) {
			for(int j = 0; j<w; j++) {
				arr[i][j] = true;
			}
		}
		for(int i = H-h; i<H; i++) {
			for(int j = W-w; j<W; j++) {
				arr[i][j] = true;
			}
		}
		print(arr);
		//direction 1 = +C, 2 = -C, 3 = +R, 4 = -R
		dir = 1;
		r = 0; c = w;
		for(int i = 0; i<100; i++) {
			while(fwd()) {};
			right();
			//System.out.println(r+" "+c);
			while(fwd()) {};
			left();
			//System.out.println(r+" "+c);
			while(fwd()) {};
			right();
			//System.out.println(r+" "+c);
		}
		//System.out.println(r+" "+c);
	}
	public static void left() {
		if(dir==1) dir = 4;
		else if(dir==2) dir = 3;
		else if(dir==3) dir = 1;
		else if(dir==4) dir = 2;
	}
	public static void right() {
		if(dir==1) dir = 3;
		else if(dir==2) dir = 4;
		else if(dir==3) dir = 2;
		else if(dir==4) dir = 1;
	}
	public static boolean fwd() {
		if(step==maxstep) return false;
		System.out.println(r+" "+c);
		arr[r][c] = true;
		if(dir==1) {
			if(c+1==arr.length || arr[r][c+1]) return false;
			else c++;
		} else if(dir==2) {
			if(c-1<0 || arr[r][c-1]) return false;
			else c--;
		} else if(dir==3) {
			if(r+1==arr.length || arr[r+1][c]) return false;
			else r++;
		} else {
			if(r-1<0 || arr[r-1][c]) return false;
			else r--;
		}
		step++;
		return true;
	}
	public static void print(boolean[][]arr) {
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
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
