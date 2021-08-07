package icpc2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class SafePassage {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[]arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = readInt();
		}
		Arrays.sort(arr);
		int[]min = new int[(1<<n)]; //stores index of min in combination
		for(int i = 0; i<n; i++) min[(1<<i)] = i;
		for(int i = 1; i<min.length; i++) {
			for(int j = n-1; j>=0; j--) {
				if((i>>j)!=0) break;
				//System.out.println(i+" "+j);
				min[i|(1<<j)] = arr[j]<arr[min[i]]?j:min[i];
			}
		}
		/*for(int i = 0; i<min.length; i++) {
			System.out.println(Integer.toBinaryString(i)+" "+min[i]);
		}*/
		int[]dp = new int[(1<<n)];
		Arrays.fill(dp, Integer.MAX_VALUE/2);
		dp[0] = 0;
		for(int i = 0; i<dp.length; i++) {
			int a = -1, b = -1;
			for(int j = n-1; j>=0; j--) {
				if(((i>>j)&1)==0) {
					if(a<0){
						a = j;
					} else {
						b = j;
						int k = (i|(1<<a))|(1<<b);
						//System.out.println(k+" "+a+" "+b+" "+((min[k])));
						if(k==dp.length-1) dp[k] = Math.min(dp[k], dp[i]+Math.max(arr[a], arr[b]));
						else dp[k^(1<<min[k])] = Math.min(dp[k^(1<<min[k])],dp[i]+Math.max(arr[a],arr[b])+arr[min[k]]);
						a = b;
					}
				}
			}
		}
		System.out.println(dp[dp.length-1]);
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
