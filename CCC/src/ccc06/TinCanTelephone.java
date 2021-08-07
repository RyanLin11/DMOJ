package ccc06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TinCanTelephone {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int xr, yr, xj, yj;
	static double mrj, brj;
	public static void main(String[] args) throws IOException {
		xr = readInt(); 
		yr = readInt(); 
		xj = readInt(); 
		yj = readInt();
		if(xr!=xj) {
			mrj = (double)(yj-yr) / (xj-xr);
			brj = yj - mrj*xj;
		}
		int n = readInt();
		int cnt = 0;
		for(int i = 0; i<n; i++) {
			int m = readInt();
			int[]x = new int[m];
			int[]y = new int[m];
			for(int j = 0; j<m; j++) {
				x[j] = readInt();
				y[j] = readInt();
			}
			for(int j = 0; j<m; j++) {
				if(intersect(x[j], y[j], x[(j+1)%m], y[(j+1)%m])) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
	public static boolean intersect(int x1, int y1, int x2, int y2) {
		//r-j line is vertical
		if(xr==xj) {
			//lines are parallel
			if(x1==x2) {
				//lines are concurrent
				if(x1==xr) {
					return !(Math.min(y1, y2)>Math.max(yj, yr) || Math.max(y1, y2)<Math.min(xj, xr));
				} else {
					return false;
				}
			} else {
				double m = (double)(y2-y1) / (x2-x1);
				double b = y1 - m*x1;
				double y = m*xr + b;
				return Math.min(yr, yj) <=y && y<= Math.max(yr, yj) && Math.min(y1, y2) <= y && y<=Math.max(y1, y2);
			}
		} else {
			//a - b line is vertical
			if(x1==x2) {
				double y = mrj*x1 + brj;
				return Math.min(y1, y2) <= y && y <= Math.max(y1, y2) && Math.min(yr, yj) <= y && y<=Math.max(yr, yj);
			} else {
				double m = (double)(y2-y1) / (x2-x1);
				double b = y1 - m*x1;
				//lines are parallel
				if(mrj==m) {
					//concurrent lines
					if(b==brj) {
						return !(Math.min(x1, x2)>Math.max(xj, xr) || Math.max(x1, x2)<Math.min(xj, xr));
					} else {
						return false;
					}
				} else {
					double x = (b-brj) / (mrj - m);
					return Math.min(xr, xj)<=x && x<=Math.max(xr, xj) && Math.min(x1, x2) <= x && x <= Math.max(x1, x2);
				}
			}
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
