package dmopc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class GreatSequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt(), q = readInt();
		int[]psa = new int[n+1];
		ArrayList<Integer>[]list = new ArrayList[2001];
		for(int i = 0; i<list.length; i++) list[i] = new ArrayList<>();
		for(int i = 1; i<=n; i++) {
			int x = readInt();
			psa[i] = psa[i-1]+x;
			list[x+1000].add(i);
		}
		for(int i = 0; i<q; i++) {
			int a = readInt(), b = readInt(), l = readInt(), r = readInt();
			int u = Collections.binarySearch(list[a+1000], l);
			int v = Collections.binarySearch(list[a+1000], r);
			int x = Collections.binarySearch(list[b+1000], l);
			int y = Collections.binarySearch(list[b+1000], r);
			boolean flag = false;
			flag = (((u>=0||v>=0)||-v-1+u+1>0)&&((x>=0||y>=0)||-y-1+x+1>0))&&(psa[r]-psa[l-1]>k);
			System.out.println(flag?"Yes":"No");
			
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
