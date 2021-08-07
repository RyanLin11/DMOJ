package ccc04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class SpaceTurtle {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int x = readInt(), y = readInt(), z = readInt();
		int fx = readInt(), fy = readInt(), fz = readInt();
		//1 = +x, 2 = -x, 3 = +y, 4 = -y, 5 = +z, 6 = -z
		int f = 1, b = 2, l = 3, r = 4, u = 5, d = 6;
		int dis = readInt();
		char dir = readCharacter();
		double ans = Double.MAX_VALUE;
		while(true) {
			int dx = 0, dy = 0, dz = 0;
			if(f==1) {
				dy = fy - y;
				dz = fz - z;
				if(x <= fx && fx <= x+dis) {
					dx = 0;
				} else {
					dx = Math.min(Math.abs(x+dis-fx), Math.abs(x-fx));
				}
				x += dis;
			} else if(f==2) {
				dy = fy - y;
				dz = fz - z;
				if(x-dis <= fx && fx <= x) {
					dx = 0;
				} else {
					dx = Math.min(Math.abs(x-dis-fx), Math.abs(x-fx));
				}
				x -= dis;
			} else if(f==3) {
				dx = fx - x;
				dz = fz - z;
				if(y <= fy && fy <= y+dis) {
					dy = 0;
				} else {
					dy = Math.min(Math.abs(y-fy), Math.abs(y+dis-fy));
				}
				y += dis;
			} else if(f==4) {
				dx = fx - x;
				dz = fz - z;
				if(y-dis <= fy && fy <=y) {
					dy = 0;
				} else {
					dy = Math.min(Math.abs(y-dis-fy), Math.abs(y-fy));
				}
				y -= dis;
			} else if(f==5) {
				dx = fx - x;
				dy = fy - y;
				if(z <= fz && fz <= z + dis) {
					dz = 0;
				} else {
					dz = Math.min(Math.abs(z-fz), Math.abs(z+dis-fz));
				}
				z += dis;
			} else {
				dx = fx - x;
				dy = fy - y;
				if(z-dis <= fz && fz <= z) {
					dz = 0;
				} else {
					dz = Math.min(Math.abs(z-dis-fz), Math.abs(z-fz));
				}
				z -= dis;
			}
			ans = Math.min(ans, Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2)));
			if(dir=='E') {
				break;
			} else if(dir=='L') {
				int tl = b, tr = f, tb = r, tf = l;
				l = tl; r = tr; b = tb; f = tf;
			} else if(dir=='R') {
				int tl = f, tr = b, tb = l, tf = r;
				l = tl; r = tr; b = tb; f = tf;
			} else if(dir=='U') {
				int tb = d, tf = u, tu = b, td = f;
				b = tb; f = tf; u = tu; d = td;
			} else {
				int tb = u, tf = d, tu = f, td = b;
				b = tb; f = tf; u = tu; d = td;
			}
			dis = readInt();
			dir = readCharacter();
		}
		DecimalFormat df = new DecimalFormat("0.00");
		ans = Math.round(ans*100);
		System.out.println(df.format(ans/100));
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
