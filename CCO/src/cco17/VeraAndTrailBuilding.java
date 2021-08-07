package cco17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class VeraAndTrailBuilding {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int k;
	public static void main(String[] args) throws IOException {
		k = readInt();
		int lastNode = 0;
		Queue<Integer>q1 = new LinkedList<>();
		Queue<Integer>q2 = new LinkedList<>();
		while(k>0) {
			int c = largestCycle();
			for(int i = lastNode+1; i<lastNode+c; i++) {
				q1.offer(i);
				q2.offer(i+1);
			}
			q1.offer(lastNode+c);
			q2.offer(lastNode+1);
			if(lastNode!=0) {
				q1.offer(lastNode+1);
				q2.offer(lastNode);
			}
			lastNode = lastNode+c;
		}
		System.out.println(lastNode+" "+q1.size());
		while(!q1.isEmpty()) {
			System.out.println(q1.poll()+" "+q2.poll());
		}
	}
	public static int largestCycle() {
		int n = 2;
		int combo = 1;
		for(int i = 2; i<=5000; i++) {
			if((i*(i-1))/2<=k) {
				n = i;
				combo = i*(i-1)/2;
			} else {
				break;
			}
		}
		k-=combo;
		return n;
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
