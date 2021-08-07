package ccc02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BridgeCrossing {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]arr;
	static int[]memo;
	static int M;
	static int Q;
	static int minTime = Integer.MAX_VALUE;
	static ArrayList<Integer>ans;
	static ArrayList<Integer>temp;
	static ArrayList<String>list;
	
	public static void main(String[] args) throws IOException {
		M = readInt();
		Q = readInt();
		arr = new int[Q];
		memo = new int[Q];
		list = new ArrayList<>();
		temp = new ArrayList<>();
		ans = new ArrayList<>();
		for(int i = 0; i<Q; i++){
			list.add(next());
			arr[i] = readInt();
		}
		f(0,0);
		System.out.println("Total Time: "+minTime);
		int ind = 0;
		for(int i = 0; i<list.size(); i++) {
			if(i==ans.get(ind)) {
				System.out.println(list.get(i)+" ");
				ind++;
			} else {
				System.out.print(list.get(i)+" ");
			}
		}
	}
	public static void f(int s, int v) {
		if(s>=arr.length) {
			if(v<minTime) {
				minTime = v;
				ans.clear();
				for(int i = 0; i<temp.size(); i++) {
					ans.add(temp.get(i));
				}
			}
		}
		int maxcross = 0;
		for(int i = s; i<s+M && i<arr.length; i++) {
			maxcross = Math.max(maxcross,arr[i]);
			temp.add(i);
			f(i+1,v+maxcross);
			temp.remove(temp.size()-1);
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
