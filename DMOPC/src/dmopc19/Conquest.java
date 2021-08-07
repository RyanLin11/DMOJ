package dmopc19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Conquest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int ah = readInt();
		int bh = ah;
		boolean[]ac = new boolean[n];
		boolean[]bc = new boolean[n];
		int[]a = new int[n];
		int[]b = new int[n];
		for(int i = 0; i<n; i++) {
			ac[i] = readCharacter()=='A';
			a[i] = readInt();
		}
		for(int i = 0; i<n; i++) {
			bc[i] = readCharacter()=='A';
			b[i] = readInt();
		}
		boolean ad = false;
		boolean bd = false;
		for(int i = 0; i<n; i++) {
			if(ac[i]) {
				if(!bd)bh-=a[i];
			} else {
				ad = true;
				if(bd) bh-=b[i-1];
			}
			if(bh<=0) {
				System.out.println("VICTORY");
				return;
			}
			bd = false;
			if(bc[i]) {
				if(!ad)ah-=b[i];
			} else {
				bd = true;
				if(ad) ah-=a[i];
			}
			ad = false;
			if(ah<=0) {
				System.out.println("DEFEAT");
				return;
			}
		}
		if(bd) bh-=b[b.length-1];
		if(bh<=0) System.out.println("VICTORY");
		else System.out.println("TIE");
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
