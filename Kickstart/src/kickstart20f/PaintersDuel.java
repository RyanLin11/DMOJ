package kickstart20f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PaintersDuel {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[][]vis;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for(int i = 0; i<T; i++) {
			int s = readInt(), ra = readInt(), pa = readInt(), rb = readInt(), pb = readInt(), c = readInt();
			vis = new boolean[s+1][2*(s+1)];
			for(int j = 0; j<c; j++) {
				vis[readInt()][readInt()] = true;
			}
			vis[ra][pa] = true;
			vis[rb][pb] = true;
			System.out.println("Case #"+(i+1)+": "+play(ra, pa, rb, pb, false, false));
		}
	}
	public static int play(int r, int c, int or, int oc, boolean s, boolean os) {
		int max = Integer.MIN_VALUE;
		boolean move = false;
		if(c%2==0 && r-1>0 && c-1>0 && !vis[r-1][c-1]) {
			vis[r-1][c-1] = true;
			max = Math.max(max, 1-play(or, oc, r-1, c-1, os, false));
			vis[r-1][c-1] = false;
			move = true;
		} else if(c%2==1 && r+1<vis.length && c+1<2*(r+1) && !vis[r+1][c+1]){
			vis[r+1][c+1] = true;
			max = Math.max(max, 1-play(or, oc, r+1, c+1, os, false));
			vis[r+1][c+1] = false;
			move = true;
		}
		if(c-1 > 0 && !vis[r][c-1]) {
			vis[r][c-1] = true;
			max = Math.max(max, 1-play(or, oc, r, c-1, os, false));
			vis[r][c-1] = false;
			move = true;
		} 
		if(c+1 < 2*r && !vis[r][c+1]) {
			vis[r][c+1] = true;
			max = Math.max(max, 1-play(or, oc, r, c+1, os, false));
			vis[r][c+1] = false;
			move = true;
		}
		if(!move) {
			if(os) {
				return 0;
			} else {
				return -play(or, oc, r, c, os, true);
			}
		} else {
			return max;
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
