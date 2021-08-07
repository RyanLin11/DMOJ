package kickstart17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kicksort {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for(int i = 0; i<T; i++) {
			int N = readInt();
			int[]arr = new int[N];
			for(int j = 0; j<arr.length; j++) {
				arr[j] = readInt();
			}
			int[]ind = new int[N];
			if(N%2==0) {
				for(int j = (N-1)/2, k = 1; j>=0;) {
					ind[k-1] = j;
					if(k%2==0) j -= k;
					else j += k;
					k++;
				}
			} else {
				for(int j = (N-1)/2, k = 1; j>=0;) {
					ind[k-1] = j;
					if(k%2==0) j += k;
					else j -= k;
					k++;
				}
			}
			int l = 1, r = N;
			boolean flag = true;
			for(int j = 0; j<ind.length; j++) {
				if(arr[ind[j]]==l) {
					l++;
				} else if(arr[ind[j]]==r) {
					r--;
				} else {
					flag = false;
					break;
				}
			}
			if(flag) System.out.println("Case #"+(i+1)+": YES");
			else System.out.println("Case #"+(i+1)+": NO");
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
