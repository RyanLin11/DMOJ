package ccc10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UpAndDown {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int a = readInt();
		int b = readInt();
		int c = readInt();
		int d = readInt();
		int s = readInt();
		int ap = 0;
		int bp = 0;
		int ad = 1;
		int bd = 1;
		int acount = 0;
		int bcount = 0;
		for(int i = 1; i<=s; i++) {
			if(ad==1)ap++;
			else ap--;
			acount++;
			if(bd==1)bp++;
			else bp--;
			bcount++;
			if(ad==1 && acount==a) {
				ad=-1;
				acount=0;
			} else if(ad==-1 && acount==b) {
				ad=1;
				acount = 0;
			}
			if(bd==1 && bcount==c) {
				bd=-1;
				bcount=0;
			} else if(bd==-1 && bcount==d) {
				bd=1;
				bcount=0;
			}
		}
		ap = Math.abs(ap);
		bp = Math.abs(bp);
		if(ap>bp) {
			System.out.println("Nikky");
		} else if(ap<bp) {
			System.out.println("Byron");
		} else {
			System.out.println("Tied");
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
