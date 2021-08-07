package ccc06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Groups {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		while(n!=0) {
			int[][]arr = new int[n+1][n+1];
			for(int i = 1; i<arr.length; i++) {
				for(int j = 1; j<arr[i].length; j++) {
					arr[i][j] = readInt();
				}
			}
			//proving associativity
			boolean flag = true;
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n; j++) {
					for(int k = 1; k<=n; k++) {
						if(arr[i][arr[j][k]]!=arr[arr[i][j]][k]) {
							flag = false;
							break;
						}
					}
				}
			}
			//proving identity
			int id = -1;
			for(int i = 1; i<=n; i++) {
				boolean identity = true;
				for(int j = 1; j<=n; j++) {
					if(arr[j][i]!=j || arr[i][j]!=j) {
						identity = false;
						break;
					}
				}
				if(identity) {
					id = i;
					break;
				}
			}
			//proving inverse
			boolean inverse = false;
			for(int i = 1; i<=n; i++) {
				inverse = false;
				for(int j = 1; j<=n; j++) {
					if(arr[i][j]==id && arr[j][i]==id) {
						inverse = true;
					}
				}
				if(!inverse) break;
			}
			if(flag && id>=0 && inverse) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			n = readInt();
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
