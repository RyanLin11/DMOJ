package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

public class RogersHomework {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		ArrayList<Integer>[]list = new ArrayList[1000001];
		for(int i = 0; i<list.length; i++) list[i] = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			list[readInt()].add(readInt());
		}
		PriorityQueue<Integer>pq = new PriorityQueue<>(new ascending());
		long sum = 0;
		for(int i = list.length-1; i>0; i--) {
			pq.addAll(list[i]);
			if(!pq.isEmpty()) sum+=pq.poll();
		}
		System.out.println(sum);
	}
	static class ascending implements Comparator<Integer>{
		public int compare(Integer a, Integer b) {
			return b-a;
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
