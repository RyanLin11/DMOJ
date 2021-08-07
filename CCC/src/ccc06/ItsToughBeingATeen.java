package ccc06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ItsToughBeingATeen {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		ArrayList<Integer>[]list = new ArrayList[8];
		ArrayList<Integer>[]in = new ArrayList[8];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
			in[i] = new ArrayList<>();
		}
		boolean[]root = new boolean[8];
		for(int i = 0; i<root.length; i++) root[i] = true;
		list[1].add(7); root[7] = false; in[7].add(1);
		list[1].add(4); root[4] = false; in[4].add(1);
		list[2].add(1); root[1] = false; in[1].add(2);
		list[3].add(4); root[4] = false; in[4].add(3);
		list[3].add(5); root[5] = false; in[5].add(3);
		int x = readInt(), y = readInt();
		while(x!=0 && y!=0) {
			list[x].add(y);
			in[y].add(x);
			root[y] = false;
			x = readInt();
			y = readInt();
		}
		PriorityQueue<Integer>q = new PriorityQueue<>();
		ArrayList<Integer>order = new ArrayList<>();
		boolean[]visited = new boolean[8];
		for(int i = 1; i<root.length; i++) {
			if(root[i]) {
				q.offer(i);
			}
		}
		if(q.isEmpty()) {
			System.out.println("Cannot complete these tasks. Going to bed.");
			return;
		}
		while(!q.isEmpty()) {
			int u = q.poll();
			visited[u] = true;
			order.add(u);
			for(int v: list[u]) {
				if(visited[v]) {
					System.out.println("Cannot complete these tasks. Going to bed.");
					return;
				}
				boolean fulfilled = true; //T if all prerequisites are visited
				for(int a: in[v]) {
					if(!visited[a]) {
						fulfilled = false;
						break;
					}
				}
				if(fulfilled) {
					q.offer(v);
				}
			}
		}
		for(int i = 1; i<visited.length; i++) {
			if(!visited[i]) {
				System.out.println("Cannot complete these tasks. Going to bed.");
				return;
			}
		}
		for(int i = 0; i<order.size(); i++) {
			System.out.print(order.get(i)+" ");
		}
		System.out.println();
	}
	public static String next () throws IOException {
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
