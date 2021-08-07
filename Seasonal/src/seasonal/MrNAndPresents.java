package seasonal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.HashSet;

public class MrNAndPresents {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair{
		int x, v;
		public Pair(int x, int v) {
			this.x = x;
			this.v = v;
		}
	}
	public static void main(String[] args) throws IOException {
		Deque<Pair>deque = new LinkedList<>();
		HashMap<Integer,Integer>map = new HashMap<>();
		HashSet<Integer>remove = new HashSet<>();
		int Q = readInt();
		for(int i = 0; i<Q; i++) {
			char c = readCharacter();
			int x = readInt();
			if(c=='F') {
				if(map.containsKey(x)) {
					map.put(x, map.get(x)+1);
				} else {
					map.put(x, 1);
				}
				deque.offerFirst(new Pair(x,map.get(x)));
				remove.remove(x);
			} else if(c=='E') {
				if(map.containsKey(x)) {
					map.put(x, map.get(x)+1);
				} else {
					map.put(x, 1);
				}
				deque.offerLast(new Pair(x,map.get(x)));
				remove.remove(x);
			} else {
				remove.add(x);
			}
		}
		int sz = deque.size();
		for(int i = 0; i<sz; i++) {
			Pair p = deque.pollFirst();
			if(!remove.contains(p.x)&&map.get(p.x)==p.v) {
				System.out.println(p.x);
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
