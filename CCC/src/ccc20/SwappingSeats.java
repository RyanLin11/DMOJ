package ccc20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwappingSeats {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		char[]arr = next().toCharArray();
		int n = arr.length;
		int[]cnt = new int[3];
		for(int i = 0; i<n; i++) {
			cnt[arr[i]-65]++;
		}
		//size of A
		int[]aa = new int[n];
		int[]ba = new int[n];
		int[]ca = new int[n];
		for(int i = 0; i<cnt[0]; i++) {
			if(arr[i]=='A') aa[0]++;
			else if(arr[i]=='B') ba[0]++;
			else ca[0]++;
		}
		for(int i = 1; i<n; i++) {
			aa[i] = aa[i-1];
			ba[i] = ba[i-1];
			ca[i] = ca[i-1];
			if(arr[i-1]=='A') aa[i]--;
			else if(arr[i-1]=='B') ba[i]--;
			else ca[i]--;
			if(arr[(i+cnt[0]-1)%n]=='A') aa[i]++;
			else if(arr[(i+cnt[0]-1)%n]=='B') ba[i]++;
			else ca[i]++;
		}
		//size of B
		int[]ab = new int[n];
		int[]bb = new int[n];
		int[]cb = new int[n];
		for(int i = 0; i<cnt[1]; i++) {
			if(arr[i]=='A') ab[0]++;
			else if(arr[i]=='B') bb[0]++;
			else cb[0]++;
		}
		for(int i = 1; i<n; i++) {
			ab[i] = ab[i-1];
			bb[i] = bb[i-1];
			cb[i] = cb[i-1];
			if(arr[i-1]=='A') ab[i]--;
			else if(arr[i-1]=='B') bb[i]--;
			else cb[i]--;
			if(arr[(i+cnt[1]-1)%n]=='A') ab[i]++;
			else if(arr[(i+cnt[1]-1)%n]=='B') bb[i]++;
			else cb[i]++;
			
		}
		//size of C
		int[]ac = new int[n];
		int[]bc = new int[n];
		int[]cc = new int[n];
		for(int i = 0; i<cnt[2]; i++) {
			if(arr[i]=='A') ac[0]++;
			else if(arr[i]=='B') bc[0]++;
			else cc[0]++;
		}
		for(int i = 1; i<n; i++) {
			ac[i] = ac[i-1];
			bc[i] = bc[i-1];
			cc[i] = cc[i-1];
			if(arr[i-1]=='A') ac[i]--;
			else if(arr[i-1]=='B') bc[i]--;
			else cc[i]--;
			if(arr[(i+cnt[2]-1)%n]=='A') ac[i]++;
			else if(arr[(i+cnt[2]-1)%n]=='B') bc[i]++;
			else cc[i]++;
		}
		//greedy algorithm
		int minswap = Integer.MAX_VALUE;
		for(int i = 0; i<n; i++) {
			//A B C, C A B, B C A
			int swappedA = Math.min(ca[i], ac[(i+cnt[0]+cnt[1])%n])+Math.min(ba[i], ab[(i+cnt[0])%n]);
			int oneswap = swappedA+Math.min(cb[(i+cnt[0])%n], bc[(i+cnt[0]+cnt[1])%n]);
			int twoswap = cnt[0]-aa[i]-swappedA;
			minswap = Math.min(minswap, oneswap+2*twoswap);
			//A C B, B A C, C B A
			swappedA = Math.min(ca[i], ac[(i+cnt[0])%n])+Math.min(ba[i], ab[(i+cnt[0]+cnt[2])%n]);
			oneswap = swappedA+Math.min(bc[(i+cnt[0])%n], cb[(i+cnt[0]+cnt[2])%n]);
			twoswap = cnt[0]-aa[i]-swappedA;
			minswap = Math.min(minswap, oneswap+2*twoswap);
		}
		System.out.println(minswap);
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
