package ccc21sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.TreeMap;

public class DailyCommute {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), W = readInt(), D = readInt();
		ArrayList<Integer>[]list = new ArrayList[N+1];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		//Construct reverse graph of walkways
		for(int i = 0; i<W; i++) {
			int a = readInt(), b = readInt();
			list[b].add(a);
		}
		//Do BFS on walkways
		Queue<Integer>q = new LinkedList<>();
		boolean[]vis = new boolean[N+1];
		long[]dis = new long[N+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[N] = 0;
		vis[N] = true;
		q.offer(N);
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v: list[u]) {
				if(!vis[v]) {
					vis[v] = true;
					dis[v] = dis[u] + 1;
					q.offer(v);
				}
			}
		}
		//find distance to point through subway
		long[]subdis = new long[N+1];
		int[]arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = readInt();
			subdis[arr[i]] = i;
		}
		TreeMap<Long, Integer>map = new TreeMap<>();
		for(int i = 1; i<subdis.length; i++) {
			long d = subdis[i] + dis[i];
			map.put(d, map.getOrDefault(d, 0)+1); 
		}
		for(int i = 0; i<D; i++) {
			int a = readInt()-1, b = readInt()-1;
			int x = arr[a], y = arr[b];
			long olddisx = dis[x] + subdis[x];
			long olddisy = dis[y] + subdis[y];
			//swap position of station in subway 
			long tmp = subdis[x];
			subdis[x] = subdis[y];
			subdis[y] = tmp;
			arr[a] = y;
			arr[b] = x;
			long disx = dis[x] + subdis[x];
			long disy = dis[y] + subdis[y];
			map.put(olddisx, map.get(olddisx) - 1);
			if(map.get(olddisx) == 0) map.remove(olddisx);
			map.put(olddisy, map.get(olddisy) - 1);
			if(map.get(olddisy) == 0) map.remove(olddisy);
			map.put(disx, map.getOrDefault(disx, 0) + 1);
			map.put(disy, map.getOrDefault(disy, 0) + 1);
			//return answer
			System.out.println(map.firstKey());
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
