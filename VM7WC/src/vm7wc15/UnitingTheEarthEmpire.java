package vm7wc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class UnitingTheEarthEmpire {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		Stack<Long>st = new Stack<>();
		Stack<Integer>fr = new Stack<>();
		long cnt = 0;
		for(int i = 0; i<N; i++) {
			long x = readLong();
			while(!st.isEmpty() && st.peek()<x) {
				st.pop();
				cnt += fr.pop();
			}
			if(!st.isEmpty() && st.peek()==x) {
				if(st.size()>1) cnt++;
				cnt += fr.peek();
				fr.push(fr.pop()+1);
			} else {
				if(st.size()>=1) cnt++;
				st.push(x);
				fr.push(1);
			}
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
