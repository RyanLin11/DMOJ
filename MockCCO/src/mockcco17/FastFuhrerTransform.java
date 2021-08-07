package mockcco17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class FastFuhrerTransform {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[]arr = new int[n];
		PriorityQueue<Integer>pq = new PriorityQueue<>();
		for(int i = 0; i<n; i++) {
			arr[i] = readInt();
		}
		int sum = 0, cnt = 0, last = 0;
		pq.offer(arr[0]);
		while(!pq.isEmpty() && sum<arr.length) {
			while(!pq.isEmpty() && pq.peek()<=last) pq.poll();
			if(pq.isEmpty()) break;
			last = pq.poll();
			for(int i = sum+1; i<=sum+last && i<arr.length; i++) {
				pq.offer(arr[i]);
			}
			sum+=last;
			cnt++;
		}
		System.out.println(sum<arr.length?-1:cnt);
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
