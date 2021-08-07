package rte16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class GuidanceCounselling {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair implements Comparable<Pair>{
		int a, b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int compareTo(Pair other) {
			if(this.a<other.a) {
				return 1;
			} else if(this.a>other.a) {
				return -1;
			} else {
				if(this.b<other.b) {
					return -1;
				} else if(this.b>other.b) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		int Q = readInt();
		PriorityQueue<Pair>pq = new PriorityQueue<>();
		for(int i = 0; i<Q; i++) {
			String s = next();
			if(s.equals("ADD")) {
				String color = next();
				int id = readInt();
				if(color.equals("BLUE")) {
					pq.offer(new Pair(3,id));
				} else if(color.equals("PINK")) {
					pq.offer(new Pair(2,id));
				} else {
					pq.offer(new Pair(1,id));
				}
			} else {
				if(pq.isEmpty()) {
					System.out.println("NONE");
				} else {
					Pair p = pq.poll();
					String c = "";
					if(p.a==3) c = "BLUE";
					else if(p.a==2)c = "PINK";
					else c = "GREEN";
					System.out.println(c+" "+p.b);
				}
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
