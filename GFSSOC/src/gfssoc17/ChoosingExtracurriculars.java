package gfssoc17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;

public class ChoosingExtracurriculars {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[]mem = new int[16];
		//precompute all unset numbers
		ArrayList<Integer>[]set = new ArrayList[16];//unset numbers
		for(int i = 0; i<set.length; i++) {
			set[i] = new ArrayList<>();
			for(int j = 0; j<4; j++) {
				int d = i&(1<<j);
				if(d==0) {
					set[i].add(j);
				}
			}
		}
		Arrays.fill(mem, -1);
		mem[0] = 0;
		//read input and online dp
		for(int i = 0; i<n; i++) {
			int[]arr = new int[4];
			for(int j = 0; j<arr.length; j++) {
				arr[j] = readInt();
			}
			for(int j = mem.length-1; j>=0; j--) {
				for(int k: set[j]) {
					if(mem[j]!=-1)mem[j|(1<<k)] = Math.max(mem[j|(1<<k)],mem[j]+arr[k]);
				}
			}
		}
		int max = 0;
		for(int i = 0; i<mem.length; i++) {
			max = Math.max(max, mem[i]);
		}
		//System.out.println(Arrays.toString(mem));
		System.out.println(max);
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
