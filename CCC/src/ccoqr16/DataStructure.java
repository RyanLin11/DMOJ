package ccoqr16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.math.BigDecimal;

public class DataStructure {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt();
		TreeMap<Integer, Integer>pt = new TreeMap<>();
		for(int i = 0; i<M; i++) {
			int c = readInt()-1;
			int r = readInt()-1;
			c-=r;
			if(pt.containsKey(r)) {
				pt.put(r, Math.min(pt.get(r), c));
			} else {
				pt.put(r, c);
			}
		}
		int minC = Integer.MAX_VALUE;
		int prevR = 0;
		long cnt = 0;
		BigDecimal two = new BigDecimal(2);
		for(int r: pt.keySet()) {
			long LR = N-prevR-minC;
			long RR = N-(r-1)-minC;
			int r2 = r;
			if(LR>0 && minC != Integer.MAX_VALUE) {
				if(RR<0) {
					RR = 0;
					r2 = N - minC+1;
				}
				BigDecimal bg = new BigDecimal(r2-prevR);
				BigDecimal factor = new BigDecimal(LR+RR);
				bg = bg.divide(two).multiply(factor);
				cnt += bg.longValue();
				//cnt += (long)(((r2-prevR)/2.0)*(LR+RR));
			}
			minC = Math.min(minC, pt.get(r));
			prevR = r;
		}
		int r = N;
		long LR = N-prevR-minC;
		long RR = N-(r-1)-minC;
		int r2 = r;
		if(LR>0) {
			if(RR<0) {
				RR = 0;
				r2 = N - minC+1;
			}
			BigDecimal bg = new BigDecimal(r2-prevR);
			BigDecimal factor = new BigDecimal(LR+RR);
			bg = bg.divide(two).multiply(factor);
			cnt += bg.longValue();
			//cnt += (long)(((r2-prevR)/2.0)*(LR+RR));
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
