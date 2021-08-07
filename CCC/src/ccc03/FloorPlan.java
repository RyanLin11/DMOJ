package ccc03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class FloorPlan {
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
		int n = readInt();
		int r = readInt();
		int c = readInt();
		char[][]arr = new char[r][c];
		int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
		for(int i = 0; i<r; i++) {
			arr[i] = next().toCharArray();
		}
		boolean[][]visited = new boolean[r][c];
		ArrayList<Integer>room = new ArrayList<>();
		for(int i = 0; i<r; i++) {
			for(int j = 0; j<c; j++) {
				if(!visited[i][j] && arr[i][j]!='I') {
					Queue<Pair>q = new LinkedList<>();
					q.offer(new Pair(i,j));
					visited[i][j] = true;
					int count = 1;
					while(!q.isEmpty()) {
						Pair p = q.poll();
						for(int k = 0; k<dir.length; k++) {
							int dr = p.r+dir[k][0];
							int dc = p.c+dir[k][1];
							if(dr>=0 && dr<r && dc>=0 && dc<c && arr[dr][dc]!='I' && !visited[dr][dc]) {
								q.offer(new Pair(dr,dc));
								visited[dr][dc] = true;
								count++;
							}
						}
					}
					room.add(count);
				}
			}
		}
		Collections.sort(room);
		Collections.reverse(room);
		int count = 0;
		for(int i = 0; i<room.size(); i++) {
			if(n-room.get(i)>=0) {
				n-=room.get(i);
				count++;
			} else {
				break;
			}
		}
		if(count==1)System.out.println("1 room, "+n+" square metre(s) left over");
		else System.out.println(count+" rooms, "+n+" square metre(s) left over");
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
