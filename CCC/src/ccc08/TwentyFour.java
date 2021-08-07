package ccc08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;

public class TwentyFour {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		for(int a = 0; a<n; a++) {
			int[]arr = new int[4];
			for(int i = 0; i<4; i++) {
				arr[i] = readInt();
			}
			//generate all permutations
			ArrayList<Integer>lis = new ArrayList<>();
			for(int i = 0; i<4; i++) lis.add(arr[i]);
			int ans = 0;
			for(int i = 0; i<4; i++) {
				arr[0] = lis.remove(0);
				for(int j = 0; j<3; j++) {
					arr[1] = lis.remove(0);
					for(int k = 0; k<2; k++) {
						arr[2] = lis.remove(0);
						for(int l = 0; l<1; l++) {
							arr[3] = lis.remove(0);
							HashSet<Integer>[]set = new HashSet[4];
							for(int b = 0; b<4; b++) {
								set[b] = new HashSet<>();
							}
							set[0].add(arr[0]);
							for(int b = 1; b<4; b++) {
								for(int c = b; c>0; c--) { 
									set[b].addAll(combine(add(arr,c,b), set[c-1]));
								}
							}
							for(int b: set[3]) {
								if(b<=24 && b>ans) {
									ans = b;
								}
							}
							lis.add(arr[3]);
						}
						lis.add(arr[2]);
					}
					lis.add(arr[1]);
				}
				lis.add(arr[0]);
			}
			System.out.println(ans);
		}
	}
	public static HashSet<Integer> combine(HashSet<Integer>set1, HashSet<Integer>set2) {
		HashSet<Integer>ret = new HashSet<>();
		for(int i: set1) {
			for(int j: set2) {
				ret.add(i+j);
				ret.add(i-j);
				ret.add(i*j);
				if(j!=0 && i%j==0) ret.add(i/j);
			}
		}
		return ret;
	}
	public static HashSet<Integer>add(int[]arr, int end, int cur){
		HashSet<Integer>ret = new HashSet<>();
		if(cur==end) {
			ret.add(arr[cur]);
			return ret;
		}
		for(int i: add(arr, end, cur-1)) {
			ret.add(arr[cur]+i);
			ret.add(arr[cur]-i);
			ret.add(arr[cur]*i);
			if(i!=0 && arr[cur]%i==0) ret.add(arr[cur]/i);
		}
		return ret;
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
