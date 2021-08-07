package ccc05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashMap;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PinballRanking {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[]bit;
	static long sum;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		int[]arr = new int[t];
		int[]tmp = new int[t];
		bit = new long[t+1];
		sum = 0;
		for(int i = 0; i<t; i++) {
			arr[i] = readInt();
			tmp[i] = arr[i];
		}
		Arrays.sort(tmp);
		HashMap<Integer,Integer>map = new HashMap<>();
		for(int i = 0; i<tmp.length; i++) {
			map.put(tmp[i], i+1);
		}
		long cnt = 0;
		for(int i = 0; i<t; i++) {
			sum++;
			cnt += query(map.get(arr[i]));
			update(map.get(arr[i]));
		}
		BigDecimal ans = new BigDecimal(cnt);
		BigDecimal divisor = new BigDecimal(t);
		ans = ans.divide(divisor).setScale(2, RoundingMode.HALF_EVEN);
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(df.format(ans.doubleValue()));
	}
	public static void update(int x) {
		for(int i = x; i<bit.length; i+=i&(-i)) {
			bit[i]++;
		}
	}
	public static long query(int x) {
		long s = 0;
		for(int i = x; i>0; i-=i&(-i)) {
			s += bit[i];
		}
		return sum - s;
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
