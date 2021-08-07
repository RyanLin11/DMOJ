package dmopc14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

public class NotEnoughServers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		char[][]arr = new char[n][m];
		HashSet<Integer>set = new HashSet<>();
		int[]dp = new int[(int)Math.pow(2, n)];
		int[]pre = new int[(int)Math.pow(2, n)];
		int[]layer = new int[(int)Math.pow(2, n)];
		int[]bit = new int[m];
		for(int i = 0; i<n; i++) {
			arr[i] = next().toCharArray();
		}
		int y = 0;
		for(int i = 0; i<m; i++) {
			for(int j = 0; j<n; j++) {
				if(arr[j][i]=='X')bit[i] = bit[i]|(1<<j);
			}
			y = y|bit[i];
		}
		int z = 0;
		for(int i = n-1; i>=0; i--) {
			int b = y&(1<<i);
			if(b==0) {
				z = z|(1<<i);
			}
		}
		set.add(z);
		HashSet<Integer>temp = new HashSet<>();
		for(int i = 0; i<m; i++) {
			for(int j: set) {
				int x = j|bit[i];
				if(set.contains(x)||temp.contains(x)) {
					if(dp[j]+1<dp[x]) {
						dp[x] = dp[j]+1;
						pre[x] = j;
						layer[x] = i;
					}
				} else {
					temp.add(x);
					dp[x] = dp[j]+1;
					pre[x] = j;
					layer[x] = i;
				}
			}
			set.addAll(temp);
			temp.clear();
		}
		if(dp[dp.length-1]==0) {
			System.out.println(1);
			System.out.println(1);
		} else {
			System.out.println(dp[dp.length-1]);
			System.out.print(layer[dp.length-1]+1);
			for(int i = pre[dp.length-1]; i!=z; i=pre[i]) {
				
				System.out.print(" "+(layer[i]+1));
			}
			System.out.println();
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
