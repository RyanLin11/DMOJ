package gfssoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class PursuitOfKnowledge {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		int t = readInt();
		ArrayList<Integer>[]list = new ArrayList[n+1];
		int[][]distance = new int[n+1][n+1];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i<m; i++) {
			list[readInt()].add(readInt());
		}
		int Q = readInt();
		for(int i = 0; i<Q; i++) {
			int a = readInt();
			int b = readInt();
			Queue<Integer>q = new LinkedList<>();
			boolean[]visited = new boolean[n+1];
			visited[a] = true;
			boolean found = false;
			q.offer(a);
			while(!q.isEmpty()) {
				int u = q.poll();
				if(distance[a][b]!=0) {
					System.out.println(distance[a][b]);
					found = true;
					break;
				}
				for(int v: list[u]) {
					if(!visited[v]) {
						q.offer(v);
						visited[v] = true;
						distance[a][v] = distance[a][u] + t;
					}
				}
			}
			if(!found) System.out.println("Not enough hallways!");
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
