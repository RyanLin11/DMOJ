package boi2007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Sound {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		int c = readInt();
		Deque<Integer>min = new LinkedList<>();
		Deque<Integer>max = new LinkedList<>();
		int[]arr = new int[m+1];
		boolean silence = false;
		for(int i = 0; i<n; i++) {
			arr[i%arr.length] = readInt();
			while(!min.isEmpty() && min.peekLast()>arr[i%arr.length]) min.removeLast();
			while(!max.isEmpty() && max.peekLast()<arr[i%arr.length]) max.removeLast();
			min.offerLast(arr[i%arr.length]); max.offerLast(arr[i%arr.length]);
			if(i-m>=0 && min.peekFirst()==arr[(i%arr.length+1+arr.length)%arr.length])min.removeFirst();
			if(i-m>=0 && max.peekFirst()==arr[(i%arr.length+1+arr.length)%arr.length])max.removeFirst();
			if(i-m>=-1 && max.peekFirst()-min.peekFirst()<=c) { System.out.println(i-m+2); silence = true;}
		}
		if(!silence) System.out.println("NONE");
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
