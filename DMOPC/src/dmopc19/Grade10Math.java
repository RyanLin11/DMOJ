package dmopc19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Grade10Math {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int a = readInt(), b = readInt();
		//Prime 
		HashMap<Integer, Integer>amap = new HashMap<>();
		for(int i = 2; i<=Math.sqrt(a); i++) {
			if(a % i == 0) {
				if(amap.containsKey(i)) {
					amap.put(i, amap.get(i)+1);
				} else {
					amap.put(i, 1);
				}
				a/=i;
				i = 1;
			}
		}
		if(a > 1) {
			if(amap.containsKey(a)) {
				amap.put(a, amap.get(a)+1);
			} else {
				amap.put(a, 1);
			}
		}
		HashMap<Integer, Integer>bmap = new HashMap<>();
		for(int i = 2; i<=b; i++) {
			int n = i;
			for(int j: amap.keySet()) {
				while(n % j == 0) {
					if(bmap.containsKey(j)) {
						bmap.put(j, bmap.get(j)+1);
					} else {
						bmap.put(j, 1);
					}
					n /= j;
				}
			}
		}
		int exp = Integer.MAX_VALUE;
		for(int j: amap.keySet()) {
			if(!bmap.containsKey(j)) {
				exp = 0;
				break;
			}
			exp = Math.min(exp, bmap.get(j) / amap.get(j));
		}
		System.out.println(exp);
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
