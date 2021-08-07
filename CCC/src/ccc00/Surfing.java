package ccc00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;

public class Surfing {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static HashMap<String,Integer>map;
	static ArrayList<Integer>[]list;
	static boolean[]vis;
	public static void main(String[] args) throws IOException {
		String a = "<A HREF=\"";
		int n = readInt();
		map = new HashMap<>();
		list = new ArrayList[101];
		for(int i = 0; i<list.length; i++) list[i] = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			String url = readLine();
			if(!map.containsKey(url))map.put(url,map.size());
			String s = readLine();
			while(!s.equals("</HTML>")) {
				int in = s.indexOf(a); 
				while(in>=0) {
					String str = s.substring(in+a.length(),s.indexOf("\"",in+a.length()+1));
					if(!map.containsKey(str)) map.put(str, map.size());
					list[map.get(url)].add(map.get(str));
					System.out.println("Link from "+url+" to "+str);
					in = s.indexOf(a,in+1);
				}
				s = readLine();
			}
		}
		String s1 = readLine();
		while(!s1.equals("The End")) {
			String s2 = readLine();
			vis = new boolean[101];
			System.out.println(dfs(map.get(s1),map.get(s2))?"Can surf from "+s1+" to "+s2+".":"Can't surf from "+s1+" to "+s2+".");
			s1 = readLine();
		}
	}
	public static boolean dfs(int u, int x) {
		if(u==x) return true;
		vis[u] = true;
		for(int v: list[u]) {
			if(!vis[v] && dfs(v,x)) return true;
		}
		return false;
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
