package dmopc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class AClassicProblem {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		int[]arr = new int[n];
		Deque<Integer>max = new LinkedList<>();
		Deque<Integer>min = new LinkedList<>();
		int j = 0;
		long cnt = 0;
		for(int i = 0; i<n; i++) {
			arr[i] = readInt();
			while(!max.isEmpty() && max.peekLast()<arr[i]) max.pollLast();
			while(!min.isEmpty() && min.peekLast()>arr[i]) min.pollLast();
			max.offerLast(arr[i]); min.offerLast(arr[i]);
			while(max.peekFirst()-min.peekFirst()>k) {
				if(max.peekFirst()==arr[j]) max.pollFirst();
				if(min.peekFirst()==arr[j]) min.pollFirst();
				j++;
			}
			cnt+=i-j+1;
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
