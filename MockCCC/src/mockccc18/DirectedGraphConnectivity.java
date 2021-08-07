package mockccc18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DirectedGraphConnectivity {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][]graph;
	static boolean[]visited;
	static class Edge{
		int src, dest;
		public Edge(int src, int dest) {
			this.src = src;
			this.dest = dest;
		}
	}
	public static void main(String[] args) throws IOException {
		int V = readInt();
		int E = readInt();
		graph = new int[V][V];
		for(int i = 0; i<V; i++) {
			for(int j = 0; j<V; j++) {
				graph[i][j] = 0;
			}
		}
		Edge[]arr = new Edge[E];
		for(int i = 0; i<E; i++) {
			int src = readInt()-1;
			int dest = readInt()-1;
			graph[src][dest] = 1;
			arr[i] = new Edge(src,dest);
		}
		
		for(int i = 0; i<E; i++) {
			graph[arr[i].src][arr[i].dest]= 0;
			if(dfsHelper()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			graph[arr[i].src][arr[i].dest]= 1;
		}

	}
	public static boolean dfs(int src) {
		if(src==graph.length-1) return true;
		visited[src] = true;
		for(int i = 0; i<graph[src].length; i++) {
			if(graph[src][i]==1 && !visited[i]) {
				if(dfs(i)) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean dfsHelper() {
		visited = new boolean[graph.length];
		return dfs(0);
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
