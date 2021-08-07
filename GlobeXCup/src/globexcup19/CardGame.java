package globexcup19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashMap;

public class CardGame {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), k = readInt();
		HashMap<Integer, Integer>map = new HashMap<>();
		int freq[] = new int[n+1];
		for(int i = 0; i<n; i++) {
			int x = readInt();
			if(map.containsKey(x)) {
				freq[map.get(x)]++;
			} else {
				map.put(x, map.size());
				freq[map.get(x)]++;
			}
		}
		Arrays.sort(freq);
		long sum = 0;
		for(int i = freq.length-1; i>=0; i--) {
			if(k==0||freq[i]==0) break;
			//System.out.println(freq[i]);
			if(k>=freq[i]) {
				k-=freq[i];
				sum+=sum(freq[i]-1);
			} else {
				sum+=sum(k-1);
				k = 0;
			}
			//System.out.println(sum);
		}
		System.out.println(sum);
	}
	public static long sum(int n) {
		long sum = 0;
		for(int i = 1; i<=n; i++) {
			sum+=i;
		}
		return sum;
	}
	/*public static int sum(int n) {
		return (int)(n*((1+n)/2.0));
	}*/
	public static String next () throws IOException {
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
