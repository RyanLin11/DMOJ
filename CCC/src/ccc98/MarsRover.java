package ccc98;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MarsRover {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for(int i = 0; i<t; i++) {
			int n = readInt();
			int dir = 0; //0=bwd, 1=lft, 2=fwd, 3=right
			int dx = 0, dy = 0;
			while(n!=0) {
				if(n==1) { //move ahead
					int d = readInt();
					if(dir==0) dy-=d;
					else if(dir==1) dx-=d;
					else if(dir==2) dy+=d;
					else if(dir==3) dx+=d;
				} else if(n==2) { //turn right
					dir = (dir+1)%4;
				} else if(n==3) { //turn left
					dir = (dir+3)%4;
				}
				n = readInt();
			}
			System.out.println("Distance is "+(Math.abs(dx)+Math.abs(dy)));
			if(dir==0) { //backward
				if(dy>0) {
					move(dy);
					if(dx<0) { //move right
						left();
						move(dx);
					} else if(dx>0){ //move left
						right();
						move(dx);
					}
				} else if(dy<0) {
					if(dx<0) { //move right
						left();
						move(dx);
						left();
						move(dy);
					} else if(dx>0) { //move left
						right();
						move(dx);
						right();
						move(dy);
					} else {
						right();
						right();
						move(dy);
					}
				} else {
					if(dx<0) {
						left();
						move(dx);
					} else if(dx>0) {
						right();
						move(dx);
					}
				}
			} else if(dir==1) { //left
				if(dx>0) {
					move(dx);
					if(dy>0) { //move down
						left();
						move(dy);
					} else if(dy<0) { //move up
						right();
						move(dy);
					}
				} else if(dx<0) {
					if(dy>0) { //move down 
						left();
						move(dy);
						left();
						move(dx);
					} else if(dy<0) { //move up
						right();
						move(dy);
						right();
						move(dx);
					} else {
						right();
						right();
						move(dx);
					}
				} else {
					if(dy>0) {
						left();
						move(dy);
					} else if(dy<0) {
						right();
						move(dy);
					}
				}
			} else if(dir==2) {
				if(dy<0) {
					move(dy);
					if(dx<0) { //move right
						right();
						move(dx);
					} else if(dx>0) { //move left
						left();
						move(dx);
					}
				} else if(dy>0) {
					if(dx<0) { //move right
						right();
						move(dx);
						right();
						move(dy);
					} else if(dx>0) { //move left
						left();
						move(dx);
						left();
						move(dy);
					} else {
						right();
						right();
						move(dy);
					}
				} else {
					if(dx<0) {
						right();
						move(dx);
					} else if(dx>0) {
						left();
						move(dx);
					}
				}
			} else if(dir==3) {
				if(dx<0) {
					move(dx);
					if(dy>0) {//move back
						right();
						move(dy);
					} else if(dy<0) { //move forward
						left();
						move(dy);
					}
				} else if(dx>0) {
					if(dy>0) { //move back
						right();
						move(dy);
						right();
						move(dx);
					} else if(dy<0) { //move forward
						left();
						move(dy);
						left();
						move(dx);
					} else {
						right();
						right();
						move(dx);
					}
				} else {
					if(dy>0) {
						right();
						move(dy);
					} else if(dy<0) {
						left();
						move(dy);
					}
				}
			}
			if(i!=t-1)System.out.println();
		}
	}
	public static void right() {
		System.out.println(2);
	}
	public static void left() {
		System.out.println(3);
	}
	public static void move(int x) {
		System.out.println(1);
		System.out.println(Math.abs(x));
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
