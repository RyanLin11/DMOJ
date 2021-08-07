package thicc17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Smarties {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), K = readInt();
		int[]freq = new int[1000001];
		int[]arr = new int[N];
		long ans = 0;
		int cnt = 0;
		for(int l = 0, r = 0; r<N; r++) {
			int x = readInt();
			arr[r] = x;
			if(freq[x]==0) {
				cnt++;
			}
			freq[x]++;
			while(cnt>K || (cnt==K && freq[arr[l]]!=1)) {
				freq[arr[l]]--;
				if(freq[arr[l]]==0) cnt--;
				l++;
			}
			if(cnt>=K) ans+=l+1;
		}
		System.out.println(ans);
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
