package dmopc14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class ChemistryHomework {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[]list;
	static int[]in;
	static int energy = 0;
	static int n, m, hcount = 0, ccount = 0;
	static boolean[] visited;
	static boolean valid = true;
	static class Edge{
		int u, v;
		public Edge(int u, int v) {
			this.u = u;
			this.v = v;
		}
	}
	public static void main(String[] args) throws IOException {
		n = readInt();
		m = readInt();
		in = new int[n+1];
		visited = new boolean[n+1];
		int[][]graph = new int[n+1][n+1];
		Edge[]edges = new Edge[m];
		for(int i = 0; i<m; i++) {
			int x = readInt();
			int y = readInt();
			edges[i] = new Edge(x, y);
			in[x]++;
			in[y]++;
		}
		for(int i = 1; i<in.length; i++) {
			if(in[i]==1) {
				hcount++;
			} else if(in[i]==4) {
				ccount++;
			} else {
				System.out.println("Impossible");
				return;
			}
		}
		for(Edge e: edges) {
			if(in[e.u]==1 && in[e.v]==4 || in[e.u]==4 && in[e.v]==1) {
				energy+=413;
			} else if(in[e.u]==4 && in[e.v]==4) {
				graph[e.u][e.v]++;
				graph[e.v][e.u]++;
				if(graph[e.u][e.v]==1) {
					energy+=346;
				} else if(graph[e.u][e.v]==2) {
					energy+=269;
				} else {
					System.out.println("Impossible");
					return;
				}
			} else {
				System.out.println("Impossible");
				return;
			}
		}
		System.out.println(energy);
		if(ccount==1) {
			if(hcount==1) System.out.println("CH");
			else System.out.println("CH"+hcount);
		} else if(hcount==1) {
			System.out.println("C"+ccount+"H");
		} else {
			System.out.println("C"+ccount+"H"+hcount);
		}
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
