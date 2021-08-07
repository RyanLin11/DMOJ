package gfssoc17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class PathToWaterloo {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		HashMap<String, Integer>map = new HashMap<>();
		map.put("home", 0);
		map.put("Waterloo GO", 1);
		int n = readInt();
		int t = readInt();
		ArrayList<Integer>[]list = new ArrayList[n+2];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i<n; i++) {
			map.put(readLine(), map.size());
		}
		for(int i = 0; i<t; i++) {
			String[]temp = readLine().split("-");
			int s = map.get(temp[0]);
			int e = map.get(temp[1]);
			list[s].add(e);
			list[e].add(s);
		}
		Queue<Integer>q = new LinkedList<>();
		boolean[]visited = new boolean[n+2];
		int[]dist = new int[n+2];
		q.offer(0);
		visited[0] = true;
		while(!q.isEmpty()) {
			int u = q.poll();
			if(u==1) {
				System.out.println(dist[u]);
				return;
			}
			for(int v: list[u]) {
				if(!visited[v]) {
					visited[v] = true;
					dist[v] = dist[u] + 1;
					q.offer(v);
				}
			}
		}
		System.out.println("RIP ACE");
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
