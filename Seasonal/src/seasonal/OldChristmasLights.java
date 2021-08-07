package seasonal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class OldChristmasLights {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]seg, best, bestans;
	static int tmp = 0;
	public static void main(String[] args) throws IOException {
		int N = readInt(), K = readInt();
		int[]arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = readInt();
		}
		best = new int[N];
		bestans = new int[N+1];
		bestans[N] = Integer.MIN_VALUE;
		Deque<Integer>min = new LinkedList<>();
		Deque<Integer>max = new LinkedList<>();
		int in = 0;
		for(int i = 0; i<N; i++) {
			while(!min.isEmpty() && min.peekLast() > arr[i]) min.pollLast();
			while(!max.isEmpty() && max.peekLast() < arr[i]) max.pollLast();
			min.offer(arr[i]); max.offer(arr[i]);
			while(!max.isEmpty() && !min.isEmpty() && max.peekFirst() - min.peekFirst() > K) {
				if(min.peekFirst() == arr[in]) min.pollFirst();
				if(max.peekFirst() == arr[in]) max.pollFirst();
				in++;
			}
			best[i] = in;
			bestans[i] = i - in + 1;
		}
		seg = new int[4*N];
		construct(1, 0, N-1);
		int Q = readInt();
		for(int i = 0; i<Q; i++) {
			int tl = readInt()-1, tr = readInt()-1;
			int l = tl, r = tr;
			while(l <= r) {
				int mid = (l+r)/2;
				if(best[mid] >= tl) {
					r = mid-1;
				} else {
					l = mid+1;
				}
			}
			int x = query(1, 0, N-1, l, tr);
			if(l - tl >= bestans[x]) {
				System.out.println((tl+1)+" "+(l));
			} else {
				System.out.println((best[x]+1)+" "+(x+1));
			}
		}
	}
	public static void construct(int v, int l, int r) {
		if(l == r) {
			seg[v] = l;
		} else {
			int mid = (l+r)/2;
			construct(v*2, l, mid);
			construct(v*2+1, mid+1, r);
			seg[v] = bestans[seg[v*2]] >= bestans[seg[v*2+1]]? seg[v*2] : seg[v*2+1];
		}
	}
	public static int query(int v, int l, int r, int tl, int tr) {
		if(tl > tr) return bestans.length-1;
		if(tl == l && tr == r) {
			return seg[v];
		} else {
			int mid = (l + r)/2;
			int lft = query(v*2, l, mid, tl, Math.min(tr, mid));
			int rt = query(v*2+1, mid+1, r, Math.max(mid+1, tl), tr);
			if(bestans[lft] >= bestans[rt]) {
				return lft;
			} else {
				return rt;
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
