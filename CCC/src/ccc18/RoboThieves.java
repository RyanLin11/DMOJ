package ccc18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class RoboThieves {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair{
		int r, c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static char[][]arr;
	static int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean[][]cam, visited;
	static int[][]dis;
	static Queue<Pair>q;
	static int n,m;
	public static void main(String[] args) throws IOException {
		n = readInt();
		m = readInt();
		arr = new char[n][m];
		//cam = new boolean[n][m];
		visited = new boolean[n][m];
		dis = new int[n][m];
		q = new LinkedList<>();
		for(int i = 0; i<n; i++) {
			arr[i] = next().toCharArray();
		}
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(arr[i][j]=='C') {
					for(int k = i; k>=0 && arr[k][j]!='W'; k--) {
						if(isConveyor(k,j)) continue;
						visited[k][j] = true;
					}
					for(int k = i; k<n && arr[k][j]!='W'; k++) {
						if(isConveyor(k,j)) continue;
						visited[k][j] = true;
					}
					for(int k = j; k>=0 && arr[i][k]!='W'; k--) {
						if(isConveyor(i,k)) continue;
						visited[i][k] = true;
					}
					for(int k = j; k<m && arr[i][k]!='W'; k++) {
						if(isConveyor(i,k)) continue;
						visited[i][k] = true;
					}
				} else if(arr[i][j]=='S') {
					q.add(new Pair(i,j));
				} else if(arr[i][j]=='W') {
					visited[i][j] = true;
				}
			}
		}
		if(visited[q.peek().r][q.peek().c]) q.poll();
		else visited[q.peek().r][q.peek().c] = true; 
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int i = 0; i<dir.length; i++) {
				int dr = p.r+dir[i][0];
				int dc = p.c+dir[i][1];
				if(dr>=0 && dr<n && dc>=0 && dc<m && !visited[dr][dc]) {
					dis[dr][dc] = dis[p.r][p.c]+1;
					visited[dr][dc] = true;
					if(isConveyor(dr,dc)) {
						conveyor(dr,dc);
					} else {
						q.offer(new Pair(dr,dc));
					}
				}
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(arr[i][j]=='.')System.out.println(dis[i][j]==0?-1:dis[i][j]);
			}
		}
	}
	public static void conveyor(int r, int c) {
		if(arr[r][c]=='U') {
			if(r-1>=0 && !visited[r-1][c]) {
				visited[r-1][c] = true;
				dis[r-1][c] = dis[r][c];
				conveyor(r-1,c);
			}
		} else if(arr[r][c]=='D'){
			if(r+1<n && !visited[r+1][c]) {
				visited[r+1][c] = true;
				dis[r+1][c] = dis[r][c];
				conveyor(r+1,c);
			}
		} else if(arr[r][c]=='L') {
			if(c-1>=0 && !visited[r][c-1]) {
				visited[r][c-1] = true;
				dis[r][c-1] = dis[r][c];
				conveyor(r,c-1);
			}
		} else if(arr[r][c]=='R') {
			if(c+1<m && !visited[r][c+1]) {
				visited[r][c+1] = true;
				dis[r][c+1] = dis[r][c];
				conveyor(r,c+1);
			}
		} else {
			q.offer(new Pair(r,c));
		}
	}
	public static boolean isConveyor(int r, int c) {
		return arr[r][c]=='L'||arr[r][c]=='R'||arr[r][c]=='U'||arr[r][c]=='D';
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
