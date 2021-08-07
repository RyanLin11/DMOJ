package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.*;

public class BobsGates {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class reverse implements Comparator<Integer>{
		public int compare(Integer a, Integer b) {
			if(a<b) {
				return 1;
			} else if(b<a) {
				return -1;
			} else {
				return 0;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		int g = readInt(), p = readInt();
		ArrayList<Integer>[]list = new ArrayList[g+1];
		for(int i = 0; i<list.length; i++) list[i] = new ArrayList<>();
		for(int i = 0; i<p; i++) {
			list[readInt()].add(readInt());
		}
		PriorityQueue<Integer>pq = new PriorityQueue<>(new reverse());
		int cnt = 0;
		for(int i = g; i>=1; i--) {
			for(int j: list[i]) {
				pq.add(j);
			}
			if(!pq.isEmpty())cnt+=pq.poll();
		}
		System.out.println(cnt);
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
