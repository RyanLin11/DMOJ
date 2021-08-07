package ccc12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

public class ACoinGame {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		HashMap<Long, Integer>pow2 = new HashMap<>();
		long pow = 1;
		pow2.put(0L, -1);
		for(int i = 0; i<63; i++) {
			pow2.put(pow, i);
			pow *= 2;
		}
		int n = readInt();
		while(n!=0) {
			long y = 0;
			for(int i = 0; i<n; i++) {
				y |= (1L<<(n*i+readInt()-1));
			}
			Queue<Long>q = new LinkedList<>();
			HashMap<Long, Integer>map = new HashMap<>();
			q.offer(y);
			map.put(y, 0);
			long end = 0;
			for(int i = 0; i<n; i++) {
				end = end | (1L<<i*n+i);
			}
			boolean flag = false;
			while(!q.isEmpty()) {
				long num = q.poll();
				long tmp = num;
				int prev = 0;
				for(int i = 0; i<n; i++) {
					long x = tmp;
					int a = pow2.get(num & (-num));
					if(a<0) a = n;
					num = num>>n;
					if(i>0) {
						if(prev>=n && a>=n) continue;
						if(a<prev) {
							x = x|(1L<<((i-1)*n+a));
							x = x & ~(1L<<(i*n +a));
						} else {
							x = x|(1L<<(i*n+prev));
							x = x & ~(1L<<((i-1)*n + prev));
						}
						if(!map.containsKey(x)) {
							map.put(x, map.get(tmp)+1);
							if(x==end) {
								flag = true;
								q.clear();
								break;
							} else {
								q.offer(x);
							}
						}
					}
					prev = a;
				}
			}
			if(map.containsKey(end)) {
				System.out.println(map.get(end));
			} else {
				System.out.println("IMPOSSIBLE");
			}
			n = readInt();
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
