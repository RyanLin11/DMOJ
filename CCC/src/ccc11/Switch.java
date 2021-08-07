package ccc11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Switch {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static byte[]arr;
	static int k, min;
	public static void main(String[] args) throws IOException {
		k = readInt();
		min = Integer.MAX_VALUE;
		int num = 0;
		for(int i = 0; i<k; i++) {
			num = num|(readInt()<<i);
		}
		arr = new byte[(1<<k)];
		Arrays.fill(arr, Byte.MAX_VALUE);
		f(0, num);
		System.out.println(min);
	}
	public static void f(int step, int state) {
		if(step>=arr[state]) {
			return;
		} else {
			arr[state] = (byte)step;
		}
		int cnt = 0;
		for(int i = 0; i<k; i++) {
			if(((state>>i)&1)>0) {
				cnt++;
			} else {
				if(cnt>=4) {
					state = state^(((1<<cnt)-1)<<(i-cnt));
				}
				cnt = 0;
			}
		}
		if(cnt>=4) state = state^(((1<<cnt)-1)<<(k-cnt));
		if(state==0) {
			min = Math.min(min, step);
			return;
		}
		for(int i = 0; i<k-1; i++) {
			if((state&(5<<i))>0 && ((state>>(i+1))&1)==0) {
				f(step+1, state|(1<<(i+1)));
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
