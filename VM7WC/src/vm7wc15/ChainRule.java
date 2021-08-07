package vm7wc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class ChainRule {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Node>[]list;
	static HashSet<Integer>settled;
	static PriorityQueue<Node>pq;
	int V;
	public ChainRule(int V){
		settled = new HashSet<Integer>();
		list = new ArrayList[V];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		pq = new PriorityQueue<>(new Node());
		this.V = V;
	}
	public int[] dijkstra(int src) {
		int[]dist = new int[V];
		pq.offer(new Node(src,0));
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		while(settled.size()<V) {
			int u = pq.poll().node;
			settled.add(u);
			for(Node v: list[u]) {
				if(!settled.contains(v.node)&& dist[u]+v.cost<dist[v.node]) {
					dist[v.node]= dist[u]+v.cost;
					pq.offer(new Node(v.node,dist[v.node]));
				}
			}
		}
		pq.clear();
		settled.clear();
		return dist;
	}
	public static void main(String[] args) throws IOException {
		int n = readInt();
		ChainRule c = new ChainRule(n);
		int m = readInt();
		for(int i = 0; i<m; i++) {
			int x = readInt();
			int y = readInt();
			int w = readInt();
			list[x].add(new Node(y,w));
			list[y].add(new Node(x,w));
		}
		int[]dist1 = c.dijkstra(0);
		int[]dist2 = c.dijkstra(n-1);
		int max = 0;
		for(int i = 0; i<dist1.length; i++) {
			max = Math.max(max, dist1[i]+dist2[i]);
		}
		System.out.println(max);
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
class Node implements Comparator<Node>{
	int node, cost;
	public Node(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}
	public Node() {
		
	}
	public int compare(Node first, Node second) {
		if(first.cost>second.cost) {
			return 1;
		} else if(first.cost<second.cost) {
			return -1;
		} else {
			return 0;
		}
	}
}
