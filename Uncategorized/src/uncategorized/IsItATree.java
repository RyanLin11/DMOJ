package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IsItATree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[]visited = new boolean[4];
	static boolean[]incl = new boolean[4];
	static int[][]arr = new int[4][4];
	static int numVertices = 0, startvertex = 0;
	public static void main(String[] args) throws IOException {
		int sum = 0;
		for(int i = 0; i<4; i++) {
			for(int j = 0; j<4; j++) {
				arr[i][j] = readInt();
				sum+=arr[i][j];
			}
		}
		for(int i = 0; i<4; i++) {
			for(int j = 0; j<4; j++) {
				if(arr[i][j]>0) {
					numVertices++;
					incl[i] = true;
					startvertex = i;
					break;
				}
			}
		}
		if((sum/2.0)!=numVertices-1) {
			System.out.println("No");
			return;
		}
		if(DFSHelper()) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
	}
	public static void DFS(int u) {
		visited[u] = true;
		for(int v = 0; v<arr[u].length; v++) {
			if(arr[u][v]>0 && !visited[v]) DFS(v);
		}
	}
	public static boolean DFSHelper() {
		DFS(startvertex);
		for(int i = 0; i<visited.length; i++) {
			if(!visited[i] && incl[i]) return false;
		}
		return true;
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
