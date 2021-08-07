package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TopCoder {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair implements Comparable<Pair>{
		int id, val;
		public Pair(int id, int val) {
			this.id = id;
			this.val = val;
		}
		public int compareTo(Pair other) {
			return Integer.compare(this.val, other.val);
		}
	}
	public static void main(String[] args) throws IOException {
		int N = readInt(), K = readInt();
		HashSet<Integer>[]set = new HashSet[N];
		for(int i = 0; i<set.length; i++)set[i] = new HashSet<>();
		PriorityQueue<Pair>[]pq = new PriorityQueue[K];
		for(int i = 0; i<pq.length; i++)pq[i] = new PriorityQueue<>();
		int[]cur = new int[K];
		for(int i = 0; i<K; i++) {
			cur[i] = readInt();
		}
		int[][]arr = new int[N][K];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<K; j++) {
				arr[i][j] = readInt();
				pq[j].offer(new Pair(i,arr[i][j]));
				
			}
		}
		boolean update = true;
		int cnt = 0;
		while(update) {
			update = false;
			for(int i = 0; i<K; i++) {
				while(!pq[i].isEmpty() && pq[i].peek().val<=cur[i]) {
					Pair p = pq[i].poll();
					set[p.id].add(i);
					if(set[p.id].size()==K) {
						update = true;
						for(int j = 0; j<K; j++) {
							cur[j]+=arr[p.id][j];
						}
						cnt++;
					}
				}
			}
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
