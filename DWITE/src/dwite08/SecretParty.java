package dwite08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class SecretParty {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for(int k = 0; k<5; k++) {
			int n = readInt();
			ArrayList<Integer>[]list = new ArrayList[10000];
			for(int i = 0; i<list.length; i++) {
				list[i] = new ArrayList<>();
			}
			boolean[]visited = new boolean[10000];
			int[]targetDist = new int[10000];
			for(int i = 0; i<n; i++) {
				int s = readInt();
				int e = readInt();
				list[s].add(e);
				list[e].add(s);
			}
			Queue<Integer>q = new LinkedList<>();
			q.offer(2);
			visited[2] = true;
			while(!q.isEmpty() && targetDist[q.peek()]<2) {
				int u = q.poll();
				for(int v: list[u]) {
					if(!visited[v] && v!=1) {
						
						q.offer(v);
						visited[v] = true;
						targetDist[v] = targetDist[u]+1;
					}
				}
			}
			ArrayList<Integer>invited = new ArrayList<>();
			for(int v: list[1]) {
				if(!visited[v]) {
					invited.add(v);
				}
			}
			Collections.sort(invited);
			boolean atLeastOne = false;
			for(int v: invited) {
				System.out.print(v+" ");
				atLeastOne = true;
			}
			if(!atLeastOne) System.out.println("none");
			else System.out.println();
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
