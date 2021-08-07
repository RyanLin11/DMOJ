package ecoo20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CaptchaFun {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for(int i = 0; i<t; i++) {
			int n = readInt();
			for(int j = 0; j<n; j++) {
				int h = readInt(), w = readInt();
				char[][]arr = new char[h][w];
				for(int k = 0; k<h; k++) {
					arr[k] = next().toCharArray();
				}
				//find leftmost digits
				int cnt = 0;
				int lft = 0;
				int toplft = 1000;
				for(int k = 0; k<w; k++) {
					boolean flag = false;
					for(int l = 0; l<h; l++) {
						if(arr[l][k]=='*') {
							if(!flag) {
								toplft = Math.min(toplft,l);
								cnt++; flag = true;
							}
						} else {
							flag = false;
						}
					}
					lft=k;
					if(cnt!=0) break;
				}
				//find rightmost digits
				int rcnt = 0;
				int rt = 0;
				int toprt = 1000;
				for(int k = w-1; k>=0; k--) {
					boolean flag = false;
					for(int l = 0; l<h; l++) {
						if(arr[l][k]=='*') {
							if(!flag) {
								toprt = Math.min(toprt, l);
								rcnt++; flag = true;
							}
						} else {
							flag = false;
						}
					}
					rt = k;
					if(rcnt!=0) break;
				}
				//find locations of mid
				int cntm = 0;
				int topmid = 1000;
				for(int k = lft+1; k<rt; k++) {
					boolean flag = false;
					for(int l = 0; l<h; l++) {
						if(arr[l][k]=='*') {
							if(!flag) {
								topmid = Math.min(topmid, l);
								cntm++; flag = true;
							}
						} else {
							flag = false;
						}
					}
					if(cntm!=0) break;
				}
				//determine digit
				if(cnt==1) {
					if(cntm==3) {
						if(rcnt==1) {
							if(toplft<toprt) {
								System.out.print("5");
							} else {
								System.out.print("2");
							}
						} else {
							System.out.print("9");
						}
					} else {
						if(cntm==0 || topmid<toprt) {
							System.out.print("7");
						} else {
							System.out.print("4");
						}
					}
				} else if(cnt==2) {
					if(cntm==0) System.out.print("1");
					else if(cntm==2) System.out.print("0");
					else if(rcnt==1) System.out.print("6");
					else System.out.print("8");
				} else {
					System.out.print("3");
				}
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
