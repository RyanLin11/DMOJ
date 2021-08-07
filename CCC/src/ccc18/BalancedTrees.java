package ccc18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class BalancedTrees {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static HashMap<Integer, Long>map;
	static int N;
	public static void main(String[] args) throws IOException {
		N = readInt();
		map = new HashMap<>();
		System.out.println(f(N));
		//System.out.println(map.size());
	}
	public static long f(int w) {
		if(w==1) return 1;
		else if(map.containsKey(w)) return map.get(w);
		long sum = 0;
		int prev = 0;
		for(int i = w; i>1; i--) {
			int cur = w/i;
			//System.out.println(w+" "+i+" "+cur);
			if(prev==cur) {
				//int x = binSearch(w, i, cur);
				double tmp = (double)w/(cur+1);
				int x = (int)Math.ceil(tmp);
				if(tmp==x) x++;
				sum += (i-x+1)*f(cur);
				i = x;
			} else {
				sum += f(cur);
			}
			prev = cur;
		}
		map.put(w, sum);
		return sum;
	}
	public static int binSearch(int n, int s, int w) {
		int l = 2, r = s;
		int ans = 0;
		while(l<=r) {
			int mid = (l+r)/2;
			if(n/mid==w) {
				ans = mid;
				r = mid-1;
			} else if(n/mid>w){
				l = mid+1;
			} else {
				r = mid-1;
			}
		}
		return ans;
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
