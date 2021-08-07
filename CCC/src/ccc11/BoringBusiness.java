package ccc11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BoringBusiness {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int[]row = {1,2,3,3,3,3,4,5,5,5,4,3,3,3,4,5,6,7,7,7,7,7,7,7,7,7,6,5};
		int[]col = {0,0,0,1,2,3,3,3,4,5,5,5,6,7,7,7,7,7,6,5,4,3,2,1,0,-1,-1,-1};
		boolean[][]map = new boolean[201][402];
		for(int i = 0; i<row.length; i++) {
			row[i]--;
			col[i]+=201;
			map[row[i]][col[i]] = true;
		}
		int r = 4, c = 200;
		char ch = readCharacter(); int dis = readInt();
		boolean valid = true;
		while(ch!='q') {
			if(ch=='d') {
				for(int i = 0; i<dis; i++) {
					r++;
					if(map[r][c]) {
						valid = false;
					}
					map[r][c] = true;
				}
			} else if(ch=='u') {
				for(int i = 0; i<dis; i++) {
					r--;
					if(map[r][c]) {
						valid = false;
					}
					map[r][c] = true;
				}
			} else if(ch=='l') {
				for(int i = 0; i<dis; i++) {
					c--;
					if(map[r][c]) {
						valid = false;
					}
					map[r][c] = true;
				}
			} else {
				for(int i = 0; i<dis; i++) {
					c++;
					if(map[r][c]) {
						valid = false;
					}
					map[r][c] = true;
				}
			}
			if(valid) {
				System.out.println((c-201)+" "+(-r-1)+" safe");
			} else {
				System.out.println((c-201)+" "+(-r-1)+" DANGER");
				break;
			}
			 ch = readCharacter();  dis = readInt();
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
