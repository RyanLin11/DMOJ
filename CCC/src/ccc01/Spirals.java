package ccc01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Spirals {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for(int i = 0; i<t; i++) {
			int x = readInt(), y = readInt();
			int[][]arr = new int[10][10];
			int r = 4, c = 4;
			arr[r][c] = x;
			int incr = 0, num = x+1;
			for(int j = 0; num<=y; j=(j+1)%4) {
				if(j==0) { //down
					incr++;
					for(int k = 0; k<incr && num<=y; k++) {
						r++;
						arr[r][c] = num;
						num++;
					}
				} else if(j==1) { //right
					for(int k = 0; k<incr && num<=y; k++) {
						c++;
						arr[r][c] = num;
						num++;
					}
				} else if(j==2) { //up
					incr++;
					for(int k = 0; k<incr && num<=y; k++) {
						r--;
						arr[r][c] = num;
						num++;
					}
				} else { //left
					for(int k = 0; k<incr && num<=y; k++) {
						c--;
						arr[r][c] = num;
						num++;
					}
				}
			}
			//formatting
			boolean[]filledrow = new boolean[10];
			boolean[]filledcol = new boolean[10];
			boolean[]twofig = new boolean[10];
			for(int j = 0; j<arr.length; j++) {
				for(int k = 0; k<arr[j].length; k++) {
					if(arr[j][k]!=0) {
						filledrow[j] = true;
						filledcol[k] = true;
						if(arr[j][k]>=10) twofig[k] = true;
					}
				}
			}
			//printing
			for(int j = 0; j<arr.length; j++) {
				if(!filledrow[j]) continue;
				String s = "";
				for(int k = 0; k<arr[j].length; k++) {
					if(!filledcol[k]) continue;
					if(arr[j][k]>=10) {
						s+=arr[j][k];
					} else {
						if(twofig[k]) {
							if(arr[j][k]==0) s+="  ";
							else s+=" "+arr[j][k];
						} else {
							if(arr[j][k]==0) s+=" ";
							else s+=arr[j][k];
						}
					}
					s+=" ";
				}
				s = s.substring(0,s.length()-1);
				System.out.println(s);
			}
			if(i!=t-1) System.out.println();
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
