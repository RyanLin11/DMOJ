package ccc04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Fractal {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int l, w, xint;
	static ArrayList<Integer>list;
	public static void main(String[] args) throws IOException {
		l = readInt(); w = readInt(); xint = readInt();
		list = new ArrayList<>();
		f(0, 1, w/3, 0, 1);
		Collections.sort(list);
		int prev = -1;
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i)!=prev)System.out.print(list.get(i)+" ");
			prev = list.get(i);
		}
		System.out.println();
	}
	//x is leftmost, y is downmost
	public static void f(int lvl, int dir, double len, double x, double y) {
		if(lvl==l) {
			if(dir==1||dir==2) {
				if(x<=xint && xint<=x+3*len) {
					list.add((int)y);
				}
			}
			if(dir==3||dir==4) {
				if(x==xint) {
					for(int i = (int)y; i<=y+3*len; i++) {
						list.add(i);
					}
				}
			}
			return;
		}
		if(dir==1) {//up
			f(lvl+1, 1, len/3, x, y);//left
			f(lvl+1, 3, len/3, x+len, y);
			f(lvl+1, 1, len/3, x+len, y+len);
			f(lvl+1, 4, len/3, x+2*len, y);
			f(lvl+1, 1, len/3, x+2*len, y); //right
		} else if(dir==2) {//down
			f(lvl+1, 2, len/3, x, y); //left
			f(lvl+1, 3, len/3, x+len, y-len);
			f(lvl+1, 2, len/3, x+len, y-len);
			f(lvl+1, 4, len/3, x+2*len, y-len);
			f(lvl+1, 2, len/3, x+2*len, y); //right
		} else if(dir==3) {//left
			f(lvl+1, 3, len/3, x, y); //left
			f(lvl+1, 2, len/3, x-len, y+len);
			f(lvl+1, 3, len/3, x-len, y+len);
			f(lvl+1, 1, len/3, x-len,y+2*len);
			f(lvl+1, 3, len/3, x, y+2*len); //right
		} else {//right
			f(lvl+1, 4, len/3, x, y+2*len);//left
			f(lvl+1, 1, len/3, x, y+2*len);
			f(lvl+1, 4, len/3, x+len, y+len);
			f(lvl+1, 2, len/3, x, y+len);
			f(lvl+1, 4, len/3, x, y);//right
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
