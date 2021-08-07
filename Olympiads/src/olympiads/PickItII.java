package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class PickItII {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), K = readInt();
		long[]arr = new long[K+1];
		long sum = 0;
		Deque<Long>maxq = new LinkedList<>();
		for(int i = 0; i<arr.length; i++) maxq.offerLast(0L);
		int j = 0; 
		for(int i = 0; i<N; i++) {
			long x = readInt();
			sum += x;
			long max = maxq.peekFirst();
			if(maxq.peekFirst()==arr[j]) maxq.pollFirst();
			arr[j] = max - x;
			while(!maxq.isEmpty() && maxq.peekLast()<arr[j]) {
				maxq.pollLast();
			}
			maxq.offerLast(arr[j]);
			j--;
			if(j<0) j+=K+1;
		}
		System.out.println(sum+maxq.pollFirst());
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
