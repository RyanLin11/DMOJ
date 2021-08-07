package nychallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Rocks {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int C = readInt();
		int[]bit = new int[10001];
		int[]arr = new int[10001];
		HashMap<String, Integer>map = new HashMap<>();
		int cur = 1;
		for(int i = 0; i<C; i++) {
			char ch = readCharacter();
			if(ch=='A') {
				String s = next();
				if(map.containsKey(s)) {
					System.out.println("Can't add "+s);
				} else {
					int mass = getMass(s);
					arr[cur] = mass;
					update(bit, cur, mass);
					map.put(s, cur);
					cur++;
				}
			} else if(ch=='S') {
				String x = next(), y = next();
				update(bit, map.get(y), arr[map.get(x)]-arr[map.get(y)]);
				update(bit, map.get(x), arr[map.get(y)]-arr[map.get(x)]);
				int tmp = arr[map.get(x)];
				arr[map.get(x)] = arr[map.get(y)];
				arr[map.get(y)] = tmp;
				tmp = map.get(x);
				map.put(x, map.get(y));
				map.put(y, tmp);
			} else if(ch=='M') {
				String x = next(), y = next();
				int xin = map.get(x), yin = map.get(y);
				System.out.println(sum(bit, Math.max(xin, yin))-sum(bit, Math.min(xin, yin)-1));
			} else if(ch=='R') {
				String x = next(), y = next();
				int mass = getMass(y);
				map.put(y, map.get(x));
				update(bit, map.get(x), mass-arr[map.get(x)]);
				arr[map.get(x)] = mass;
				map.remove(x);
			} else {
				System.out.println(map.size());
			}
		}
	}
	public static int sum(int[]bit, int x) {
		int sum = 0;
		for(int i = x; i>0; i-=i&(-i)) {
			sum += bit[i];
		}
		return sum;
	}
	public static void update(int[]bit, int x, int v) {
		for(int i = x; i<bit.length; i+=i&(-i)) {
			bit[i] += v;
		}
	}
	public static int getMass(String s) {
		int mass = 0;
		for(int i = 0; i<s.length(); i++) {
			mass += s.charAt(i) - 96;
		}
		return mass;
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
