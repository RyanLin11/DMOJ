package tsoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class AlexAndAnimalRights {
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
		for(int i = 0; i<r; i++) {
			arr[i] = next().toCharArray();
		}
		int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
		int cages = 0;
		for(int i = 0; i<r; i++) {
			for(int j = 0; j<c; j++) {
				if(arr[i][j]=='M') {
					Queue<Pair>q = new LinkedList<>();
					q.offer(new Pair(i,j));
					arr[i][j] = '#';
					cages++;
					while(!q.isEmpty()) {
						Pair p = q.poll();
						for(int k = 0; k<dir.length; k++) {
							int dr = p.r+dir[k][0];
							int dc = p.c+dir[k][1];
							if(dr>=0 && dr<r && dc>=0 && dc<c && arr[dr][dc]!='#') {
								q.offer(new Pair(dr,dc));
								arr[dr][dc]='#';
							}
						}
					}
				}
			}
		}
		System.out.println(cages);
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
