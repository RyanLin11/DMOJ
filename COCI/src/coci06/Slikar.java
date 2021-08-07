package coci06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Slikar {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair{
		int r, c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		int r = readInt();
		int c = readInt();
		char[][]arr = new char[r][c];
		int[][]dir = {{1,0},{-1,0},{0,1},{0,-1}};
		Queue<Pair>q = new LinkedList<>();
		int sr = 0, sc = 0;
		for(int i = 0; i<r; i++) {
			arr[i] = next().toCharArray();
			for(int j = 0; j<c; j++) {
				if(arr[i][j]=='*') {
					q.offer(new Pair(i,j));
				} else if(arr[i][j]=='S') {
					sr = i;
					sc = j;
				}
			}
		}
		boolean[][]visited = new boolean[r][c];
		int[][]flood = new int[r][c];
		for(int i = 0; i<flood.length; i++) {
			Arrays.fill(flood[i], Integer.MAX_VALUE);
		}
		if(!q.isEmpty()) {
			flood[q.peek().r][q.peek().c]= 0; 
			visited[q.peek().r][q.peek().c] = true;
		}
		while(!q.isEmpty()){
			Pair p = q.poll();
			for(int i = 0; i<dir.length; i++) {
				int dr = p.r+dir[i][0];
				int dc = p.c+dir[i][1];
				if(dr>=0 && dr<r && dc>=0 && dc<c && arr[dr][dc]!='D' && arr[dr][dc]!='X' && !visited[dr][dc]) {
					visited[dr][dc] = true;
					flood[dr][dc] = flood[p.r][p.c]+1;
					q.offer(new Pair(dr,dc));
				}
			}
		}
		q.offer(new Pair(sr,sc));
		visited = new boolean[r][c];
		visited[sr][sc] = true;
		int[][]painter = new int[r][c];
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(arr[p.r][p.c]=='D') {
				System.out.println(painter[p.r][p.c]);
				return;
			}
			for(int i = 0; i<dir.length; i++) {
				int dr = p.r+dir[i][0];
				int dc = p.c+dir[i][1];
				if(dr>=0 && dr<r && dc>=0 && dc<c && arr[dr][dc]!='X' && !visited[dr][dc] && painter[p.r][p.c]+1<flood[dr][dc]) {
					visited[dr][dc] = true;
					painter[dr][dc] = painter[p.r][p.c]+1;
					q.offer(new Pair(dr,dc));
				}
			}
		}
		System.out.println("KAKTUS");
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
