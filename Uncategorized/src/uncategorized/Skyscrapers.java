package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Skyscrapers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt(), c = readInt(), C = readInt();
		int[]arr1 = new int[N+1];
		for(int i = 0; i<N; i++) {
			arr1[i] = readInt();
		}
		arr1[N] = Integer.MAX_VALUE;
		int[]arr2 = new int[M+1];
		for(int i = 0; i<M; i++) {
			arr2[i] = readInt();
		}
		arr2[M] = Integer.MAX_VALUE;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int cur = -1, curr = 0, curc = 0, ir = 0, ic = 0;
		long min = 0, max = 0;
		for(int i = 0; i<N+M; i++) {
			if(arr1[ir] <= arr2[ic]) {
				if(arr1[ir] != cur) {
					min += (long)cur*(curr + curc - Math.min(curr, curc));
					cur = arr1[ir];
					curr = 0;
					curc = 0;
				}
				if(M - ic + curc > 0) {
					max += (M - ic) * (long)cur;
					curr++;
					ir++;
				} else {
					min = -1;
					break;
				}
			} else {
				if(arr2[ic] != cur) {
					min += (long)cur*(curr + curc - Math.min(curr, curc));
					cur = arr2[ic];
					curr = 0;
					curc = 0;
				}
				if(N - ir + curr > 0) {
					max += (N - ir) * (long)cur;
					curc++;
					ic++;
				} else {
					min = -1;
					break;
				}
			}
		}
		if(min>=0) min += cur*(curr + curc - Math.min(curr, curc));
		min *= c;
		max *= C;
		if(min>=0) System.out.println("Minimum: "+min+", maximum: "+max);
		else System.out.println("Impossible");
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
