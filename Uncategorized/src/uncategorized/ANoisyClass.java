package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Stack;

public class ANoisyClass {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		ArrayList<Integer>[]list = new ArrayList[n+1];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		int[]in = new int[n+1];
		for(int i = 0; i<m; i++) {
			int x = readInt();
			int y = readInt();
			if(!list[x].contains(y)) {
				list[x].add(y);
				in[y]++;
			}
		}
		Stack<Integer>s = new Stack<>();
		for(int i = 1; i<in.length; i++) {
			if(in[i]==0) s.push(i);
		}
		while(!s.isEmpty()) {
			int u = s.pop();
			for(int v: list[u]) {
				in[v]--;
				if(in[v]==0) {
					s.push(v);
				}
			}
		}
		for(int i = 1; i<in.length; i++) {
			if(in[i]!=0) {
				System.out.println("N");
				return;
			}
		}
		System.out.println("Y");
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
