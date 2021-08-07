package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class CatchTheCat {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int x = readInt();
		int y = readInt();
		int[]pos = new int[1000000];
		Queue<Integer>q = new LinkedList<>();
		q.offer(x);
		while(!q.isEmpty()) {
			int u = q.poll();
			if(u==y) {
				System.out.println(pos[u]);
				return;
			}
			if(u+1<pos.length && pos[u+1]==0) {
				q.offer(u+1);
				pos[u+1] = pos[u]+1;
			}
			if(u-1>=0 && pos[u-1]==0) {
				q.offer(u-1);
				pos[u-1] = pos[u]+1;
			}
			if(u*2<pos.length && pos[u*2]==0) {
				q.offer(u*2);
				pos[u*2] = pos[u]+1;
			}
		}
		
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
