package kickstart20f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class ATM {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]arr;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for(int i = 0; i<T; i++) {
			int N = readInt(), X = readInt();
			//HashMap<Integer, ArrayList<Integer>>map = new HashMap<>();
			arr = new int[N];
			for(int j = 0; j<arr.length; j++) {
				arr[j] = (int)Math.ceil(readInt()/(double)X);
			}
			ArrayList<Integer>order = new ArrayList<>();
			for(int j = 0; j<N; j++) order.add(j);
			Collections.sort(order, new sort());
			System.out.print("Case #"+(i+1)+":");
			for(int j = 0; j<order.size(); j++) {
				System.out.print(" "+(order.get(j)+1));
			}
			System.out.println();
		}

	}
	public static class sort implements Comparator<Integer>{
		public int compare(Integer a, Integer b) {
			if(arr[a]<arr[b]) {
				return -1;
			} else if(arr[a]>arr[b]){
				return 1;
			} else {
				return 0;
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
