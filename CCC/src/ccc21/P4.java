package ccc21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

public class P4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair implements Comparable<Pair>{
		int v, w;
		public Pair(int v, int w){
			this.v = v;
			this.w =w ;
		}
		public int compareTo(Pair other) {
			return Integer.compare(this.w, other.w);
		}
	}
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(next());
		int W = Integer.parseInt(next());
		int D = Integer.parseInt(next());
		ArrayList<Integer>[]walk = new ArrayList[N+1];
		for(int i = 0; i<walk.length; i++) {
			walk[i] = new ArrayList<>();
		}
		for(int i = 0; i<W; i++) {
			int a = Integer.parseInt(next());
			int b = Integer.parseInt(next());
			walk[a].add(b);
		}
		int[]arr = new int[N+1];
		int prev = Integer.parseInt(next());
		arr[0] = prev;
		for(int i = 1; i<N; i++) {
			int s = Integer.parseInt(next());
			arr[i] = s;
			prev = s;
		}
		for(int i = 0; i<D; i++) {
			int x = Integer.parseInt(next());
			int y = Integer.parseInt(next());
			int tmp = arr[x-1];
			arr[x-1] = arr[y-1];
			arr[y-1] = tmp;
			prev = arr[0];
			int[]nxt = new int[N+1];
			int[]waittime = new int[N+1];
			PriorityQueue<Pair>pq = new PriorityQueue<>();
			
			for(int h = 1; h<arr.length; h++) {
				nxt[prev] = arr[h];
				prev = arr[h];
				waittime[arr[h]] = h;
				pq.offer(new Pair(arr[h], waittime[arr[h]]));
			}
			
			Queue<Integer>q = new LinkedList<>();
			boolean[]vis = new boolean[N+1];
			int[]dis = new int[N+1];
			q.offer(1);
			while(!q.isEmpty()) {
				int u = q.peek();
				if(pq.peek().w == dis[u] && !vis[pq.peek().v]) {
					Pair p = pq.poll();
					u = p.v;
					dis[u] =p.w;
				} else {
					u = q.poll();
				}
				vis[u] = true;
				for(int v: walk[u]) {
					if(!vis[v]) {
						q.offer(v);
						dis[v] = dis[u] + 1;
					}
				}
				if(!vis[nxt[u]]) {
					q.offer(nxt[u]);
				}
			}
			System.out.println(dis[N]);
			
		}
		
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
}
