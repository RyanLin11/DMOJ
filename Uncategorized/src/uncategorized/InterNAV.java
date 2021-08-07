package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class InterNAV {
	static class Pair{
		int r, c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[][]arr;
	public static void main(String[] args) throws IOException {
		int m = readInt();
		int n = readInt();
		arr = new char[n][m];
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		ArrayList<Integer>ans = new ArrayList<>();
		Queue<Pair> q = new LinkedList<>();
		for(int i = 0; i<n; i++) {
			arr[i] = next().toCharArray();
			for(int j = 0; j<m; j++) {
				if(arr[i][j]=='1') {
					q.add(new Pair(i,j));
					arr[i][j] = '#';
					ans.add(1);
					break;
				}
			}
		}
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int i = 0; i<dir.length; i++) {
				int dr = p.r+dir[i][0];
				int dc = p.c+dir[i][1];
				if(dr>=0 && dr<n && dc>=0 && dc<m && arr[dr][dc]!='#') {
					q.offer(new Pair(dr,dc));
					if(arr[dr][dc]!='O') ans.add(Integer.parseInt(arr[dr][dc]+"")); 
					arr[dr][dc] = '#';
				}
			}
		}
		Collections.sort(ans);
		for(int i = 0; i<ans.size(); i++) {
			System.out.print(ans.get(i)+" ");
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
