package icpc2005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.Collections;

public class Countdown {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int maxdepth;
	static ArrayList<Integer>[]list;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for(int i = 0; i<t; i++) {
			int n = readInt();
			maxdepth = readInt();
			HashMap<String, Integer>map = new HashMap<>();
			list = new ArrayList[1000];
			for(int j = 0; j<list.length; j++) list[j] = new ArrayList<>();
			for(int j = 0; j<n; j++) {
				String parent = next();
				if(!map.containsKey(parent)) {
					map.put(parent, map.size());
				}
				int pi = map.get(parent);
				int m = readInt();
				for(int k = 0; k<m; k++) {
					String child = next();
					if(!map.containsKey(child)) {
						map.put(child, map.size());
					}
					int ci = map.get(child);
					list[pi].add(ci);
				}
			}
			TreeMap<Integer, ArrayList<String>>tm = new TreeMap(new reverseSort());
			for(String s: map.keySet()) {
				int v = map.get(s);
				int num = dfs(0,v);
				if(!tm.containsKey(num)) {
					tm.put(num, new ArrayList<String>());
				}
				tm.get(num).add(s);
			}
			int cnt = 0;
			System.out.println("Tree "+(i+1)+":");
			for(int x: tm.keySet()) {
				if(x==0) break;
				if(cnt<3) {
					Collections.sort(tm.get(x));
					for(String y: tm.get(x)) {
						System.out.println(y+" "+x);
						cnt++;
					}
				} else {
					break;
				}
			}
			if(i!=t-1) System.out.println();
		}
	}
	public static int dfs(int d, int u) {
		if(d==maxdepth) return 1;
		int cnt = 0;
		for(int v: list[u]) {
			cnt += dfs(d+1, v);
		}
		return cnt;
	}
	public static class reverseSort implements Comparator<Integer>{
		public int compare(Integer a, Integer b) {
			return Integer.compare(b, a);
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
