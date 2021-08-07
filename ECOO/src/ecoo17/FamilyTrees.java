package ecoo17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;

public class FamilyTrees {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Node{
		HashMap<Integer, Node>adj;
		int max;
		public Node() {
			adj = new HashMap<>();
			max = 0;
		}
	}
	public static void main(String[] args) throws IOException {
		for(int k = 0; k<10; k++) {
			int n = readInt();
			Node root = new Node();
			ArrayList<Node>list = new ArrayList<>();
			list.add(root);
			for(int i = 0; i<n; i++) {
				String[] s = next().split("\\.");
				int[]a = new int[s.length];
				for(int j = 0; j<s.length; j++) a[j] = Integer.parseInt(s[j]);
				Node cur = root;
				for(int j = 1; j<a.length; j++) {
					if(!cur.adj.containsKey(a[j])) {
						Node nd = new Node();
						cur.adj.put(a[j], nd);
						list.add(nd);
						
					}
					cur.max = Math.max(cur.max, a[j]);
					cur = cur.adj.get(a[j]);
				}
			}
			long cnt = 1;
			for(Node node: list) {
				cnt += node.max;
				cnt %= 1000000007;
			}
			System.out.println(cnt);
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
