package icpc2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class NinePacks {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		HashMap<Integer, Integer>map = new HashMap<>();
		int h = readInt();
		int[]hot = new int[h*1000+1];
		Set<Integer>set = new HashSet<>();
		Set<Integer>temp = new HashSet<>();
		ArrayList<Integer>tempset = new ArrayList<>();
		ArrayList<Integer>tempval = new ArrayList<>();
		for(int i = 0; i<h; i++) {
			int x = readInt();
			for(int j: set) {
				if(set.contains(x+j)) {
					//hot[x+j] = Math.min(hot[x+j], hot[j]+1);
					tempset.add(x+j);
					tempval.add(Math.min(hot[x+j], hot[j]+1));
				} else {
					hot[x+j] = hot[j]+1;
					temp.add(x+j);
				}
			}
			set.add(x);
			set.addAll(temp);
			for(int j=0; j<tempset.size(); j++) {
				hot[tempset.get(j)] = tempval.get(j);
			}
			tempset.clear();
			tempval.clear();
			temp.clear();
			hot[x] = 1;
		}
		int b = readInt();
		int[]bun = new int[b*1000+1];
		Set<Integer>set2 = new HashSet<>();
		for(int i = 0; i<b; i++) {
			int x = readInt();
			for(int j: set2) {
				if(set2.contains(x+j)) {
					//bun[x+j] = Math.min(bun[x+j], bun[j]+1);
					tempset.add(x+j);
					tempval.add(Math.min(bun[x+j], bun[j]+1));
				} else {
					bun[x+j] = bun[j]+1;
					temp.add(x+j);
				}
			}
			set2.add(x);
			set2.addAll(temp);
			for(int j=0; j<tempset.size(); j++) {
				bun[tempset.get(j)] = tempval.get(j);
			}
			tempset.clear();
			tempval.clear();
			temp.clear();
			bun[x] = 1;
		}
		int min = Integer.MAX_VALUE;
		for(int x: set) {
			if(set2.contains(x)) {
				min = Math.min(min, hot[x]+bun[x]);
			}
		}
		System.out.println(min==Integer.MAX_VALUE?"impossible":min);
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
