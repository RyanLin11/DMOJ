package dwite07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class ShortestPathAround {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for(int i = 0; i<5; i++) {
			char[][]arr = new char[10][10];
			int srcrow = 0;
			int srccol = 0;
			int destrow = 0;
			int destcol = 0;
			boolean first = true;
			for(int j = 0; j<10; j++) {
				arr[j] = next().toCharArray();
				for(int k = 0; k<10; k++) {
					if(arr[j][k]=='X' && first) {
						srcrow = j;
						srccol = k;
						first = false;
					} else if(arr[j][k]=='X' && !first) {
						destrow = j;
						destcol = k;
					}
				}
			}
			System.out.println(dijkstra(srcrow,srccol,destrow,destcol,arr));
			String s = readLine();
		}
	}
	public static int dijkstra(int srcrow, int srccol, int destrow, int destcol, char[][]arr) {
		int[][]dist = new int[10][10];
		boolean[][]visited = new boolean[10][10];
		int[][]moves = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
		for(int i = 0; i<10; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			Arrays.fill(visited[i], false);
		}
		dist[srcrow][srccol] = 0;
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				int[]start = minIndex(dist, visited);
				int ur = start[0];
				int uc = start[1];
				if(ur==destrow && uc == destcol) {
					return dist[ur][uc];
				}
				visited[ur][uc] = true;
				for(int k = 0; k<moves.length; k++) {
					int vr = ur+moves[k][0];
					int vc = uc+moves[k][1];
					if(vr>=0 && vr<arr.length && vc>=0 && vc<arr.length) {
						if(dist[ur][uc]+1<dist[vr][vc] && !visited[vr][vc] && dist[ur][uc]!=Integer.MAX_VALUE && arr[vr][vc]!='#') {
							dist[vr][vc] = dist[ur][uc]+1;
						}
					}
				}
			}
		}
		return -1;
	}
	public static int[] minIndex(int[][]dist, boolean[][]visited) {
		int min = Integer.MAX_VALUE;
		int[]minIndex = new int[2];
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				if(!visited[i][j] && dist[i][j]<min) {
					min = dist[i][j];
					minIndex[0] = i;
					minIndex[1] = j;
				}
			}
		}
		return minIndex;
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
