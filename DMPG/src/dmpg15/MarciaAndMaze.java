package dmpg15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class MarciaAndMaze {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[][]arr;
	static int[][]h;
	static int[][]v;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		arr = new char[n][n];
		h = new int[n][n];
		v = new int[n][n];
		for(int i = 0; i<n; i++) {
			arr[i] = next().toCharArray();
		}
		Queue<Integer>qr = new LinkedList<>();
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(arr[i][j]=='.') {
					qr.offer(j);
				} else {
					while(!qr.isEmpty()) {
						h[i][qr.poll()] = j-1;
					}
				}
			}
			while(!qr.isEmpty()) {
				h[i][qr.poll()] = n-1;
			}
		}
		Queue<Integer>qv = new LinkedList<>();
		for(int j = 0; j<n; j++) {
			for(int i = 0; i<n; i++) {
				if(arr[i][j]=='.') {
					qv.offer(i);
				} else {
					while(!qv.isEmpty()) {
						v[qv.poll()][j] = i-1;
					}
				}
			}
			while(!qv.isEmpty()) {
				v[qv.poll()][j] = n-1;
			}
		}
		int max = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(arr[i][j]!='*') {
					for(int c = 1; i+c<n && j+c<n; c++) {
						if(h[i][j]>=j+c &&v[i][j]>=i+c && v[i][j+c]>=i+c && h[i+c][j]>=j+c) {
							max = Math.max(max, c);
						}
					}
				}
			}
		}
		System.out.println(max);
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
