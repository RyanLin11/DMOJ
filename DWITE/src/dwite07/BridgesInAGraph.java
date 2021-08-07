package dwite07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BridgesInAGraph {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Edge{
		int src, dest;
		public Edge(int src, int dest) {
			this.src = src;
			this.dest = dest;
		}
	}
	public static void main(String[] args) throws IOException {
		for(int k = 0; k<5; k++) {
			int n = readInt();
			int m = readInt();
			int[][]arr = new int[n+1][n+1];
			Edge[]edge = new Edge[m];
			for(int i = 0; i<m; i++) {
				int x = readInt();
				int y = readInt();
				arr[x][y] = 1;
				arr[y][x] = 1;
				edge[i] = new Edge(x, y);
			}
			int bridge = 0;
			for(int i = 0; i<edge.length; i++) {
				arr[edge[i].src][edge[i].dest] = 0;
				arr[edge[i].dest][edge[i].src] = 0; 
				boolean[]visited = new boolean[n+1];
				Queue<Integer>q = new LinkedList<>();
				q.offer(1);
				while(!q.isEmpty()) {
					int u = q.poll();
					for(int v = 0; v<arr[u].length; v++) {
						if(!visited[v] && arr[u][v]!=0) {
							q.offer(v);
							visited[v] = true;
						}
					}
				}
				for(int j = 1; j<visited.length; j++) {
					if(!visited[j]) {
						bridge++;
						break;
					}
				}
				arr[edge[i].src][edge[i].dest] = 1;
				arr[edge[i].dest][edge[i].src] = 1; 
			}
			System.out.println(bridge);
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
