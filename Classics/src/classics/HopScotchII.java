package classics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class HopScotchII {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), K = readInt();
		long[]min = new long[N+1];
		int[]idx = new int[N+1];
		int[]path = new int[N+1];
		min[0] = 0; idx[0] = 0;
		int cur = 0, end = 1;
		for(int i = 1; i<=N; i++) {
			long x = readLong();
			if(idx[cur]==i-K-1) {
				cur++;
			}
			long minans = min[cur]+x;
			path[i] = idx[cur];
			while(cur<end && min[end-1]>=minans) {
				end--;
			}
			min[end] = minans;
			idx[end] = i;
			end++;
		}
		if(idx[cur]==N-K) {
			cur++;
		}
		long m = Long.MAX_VALUE; int index = -1;
		while(cur<end) {
			if(min[cur]<m) {
				m = min[cur];
				index = idx[cur];
			}
			cur++;
		}
		Stack<Integer>st = new Stack<>();
		while(index!=0) {
			st.push(index);
			index = path[index];
		}
		System.out.println(m);
		while(!st.isEmpty()) System.out.print(st.pop()+" ");
		System.out.println();
		
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
