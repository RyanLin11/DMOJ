package ccc05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class PyramidMessageScheme {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[]list;
	static boolean[]visited;
	static int time = 0;
	public static void main(String[] args) throws IOException {
		int l = readInt();
		for(int i = 0; i<l; i++) {
			int n = readInt();
			HashMap<String,Integer>map = new HashMap<>();
			list = new ArrayList[n];
			for(int j = 0; j<list.length; j++) {
				list[j] = new ArrayList<>();
			}
			String s1 = next();
			map.put(s1, 0);
			for(int j = 0; j<n-1; j++) {
				String s2 = next();
				if(!map.containsKey(s2)) map.put(s2, map.size());
				if(!list[map.get(s1)].contains(map.get(s2)))list[map.get(s1)].add(map.get(s2));
				if(!list[map.get(s2)].contains(map.get(s1)))list[map.get(s2)].add(map.get(s1));
				s1 = s2;
			}
			int root = map.get(s1);
			Queue<Integer>q = new LinkedList<>();
			int[]dist = new int[n];
			visited = new boolean[n];
			q.offer(root);
			visited[root] = true;
			while(!q.isEmpty()) {
				int u = q.poll();
				for(int v: list[u]) {
					if(!visited[v]) {
						q.offer(v);
						visited[v] = true;
						dist[v] = dist[u]+1;
					}
				}
			}
			//find max depth
			int maxDepth = 0;
			for(int j = 0; j<dist.length; j++) {
				if(dist[j]>maxDepth) {
					maxDepth = dist[j];
				}
			}
			int newTime = 20*maxDepth;
			
			//DFS (slow way)
			visited = new boolean[n];
			visited[root] = true;
			DFS(root);
			int oldTime = 10*time;
			System.out.println(oldTime-newTime);
			time = 0;
		}
	}
	public static void DFS(int u) {
		for(int v: list[u]) {
			if(!visited[v]) {
				time++;
				visited[v] = true;
				DFS(v);
				time++;
			}
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
