package ccc03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.*;

public class Blindfold {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int rows;
	static int columns;
	static class Point{
		char dir;
		int r,c;
		boolean visited = false;
		public Point(int r, int c, char dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		public boolean isSafe() {
			if(r>=rows || r<0 || c>=columns || c<0 || arr[r][c]=='X') {
				return false;
			}
			return true;
		}
		public void forward() {
			if(dir=='N') {
				r--;
			} else if(dir=='E') {
				c++;
			} else if(dir=='S') {
				r++;
			} else if(dir=='W') {
				c--;
			}
			visited = true;
		}
		public void right() {
			if(dir=='N') {
				dir='E';
			} else if(dir=='E') {
				dir='S';
			} else if(dir=='S') {
				dir='W';
			} else if(dir=='W') {
				dir='N';
			}
		}
		public void left() {
			if(dir=='N') {
				dir='W';
			} else if(dir=='W') {
				dir='S';
			} else if(dir=='S') {
				dir='E';
			} else if(dir=='E') {
				dir='N';
			}
		}
	}
	static ArrayList<Point>list = new ArrayList<>();
	static char[][]arr;
	public static void main(String[] args) throws IOException {
		rows = readInt();
		columns = readInt();
		arr = new char[rows][columns];
		for(int i = 0; i<rows; i++) {
			arr[i] = next().toCharArray();
		}
		for(int i = 0; i<rows; i++) {
			for(int j = 0; j<columns; j++) {
				if(arr[i][j]=='.') {
					list.add(new Point(i,j,'N'));
					list.add(new Point(i,j,'E'));
					list.add(new Point(i,j,'S'));
					list.add(new Point(i,j,'W'));
				}
			}
		}
		int n = readInt();
		for(int i = 0; i<n; i++) {
			char c = readCharacter();
			if(c=='F') {
				ListIterator<Point>iterator = list.listIterator();
				while(iterator.hasNext()) {
					Point p = iterator.next();
					p.forward();
					if(!p.isSafe()) iterator.remove();
				}
			} else if(c=='L') {
				for(int j = 0; j<list.size(); j++) {
					list.get(j).left();
				}
			} else if(c=='R') {
				for(int j = 0; j<list.size(); j++) {
					list.get(j).right();
				}
			}
		}
		for(int i = 0; i<list.size(); i++) {
			Point e = list.get(i);
			arr[e.r][e.c] = '*'; 
		}
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]);
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
