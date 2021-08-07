package ccc06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class CircleOfLife {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), a = readInt(), b = readInt(), c = readInt();
		int curState = 0;
		char[][]ch = new char[n][m];
		for(int i = 0; i<n; i++) {
			ch[i] = next().toCharArray();
			for(int j = 0; j<m; j++) {
				if(ch[i][j]=='*')curState = curState|(1<<(i*m+j));
			}
		}
		int sz = 1<<(n*m);
		ArrayList<Integer>[]lis = new ArrayList[sz];
		int[][]dir = {{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1}};
		for(int i = 0; i<lis.length; i++) lis[i] = new ArrayList<>();
		for(int i = 0; i<sz; i++) {
			int nxt = 0;
			for(int j = 0; j<n; j++) {
				for(int k = 0; k<m; k++) {
					int cnt = 0;
					for(int l = 0; l<dir.length; l++) {
						int dr = j+dir[l][0];
						int dc = k+dir[l][1];
						if(dr>=0 && dr<n && dc>=0 && dc<m && ((1<<(dr*m+dc))&i)>0) {
							cnt++;
						}
					}
					int curBit = (1<<(j*m+k))&i;
					if(curBit>0) {
						if(cnt>=a && cnt<=b) nxt = nxt|(1<<(j*m+k));
					} else {
						if(cnt>c) nxt = nxt|(1<<(j*m+k));
					}
				}
			}
			lis[nxt].add(i);
		}
		Queue<Integer>q = new LinkedList<>();
		q.offer(curState);
		boolean[]vis = new boolean[sz];
		int[]dis = new int[sz];
		boolean flag = false;
		int ans = 0;
		while(!q.isEmpty()) {
			int u = q.poll();
			if(lis[u].isEmpty()) {
				flag = true;
				ans = dis[u];
				break;
			}
			for(int v: lis[u]) {
				if(!vis[v]) {
					q.offer(v);
					dis[v] = dis[u]+1;
					vis[v] = true;
				}
			}
		}
		if(flag) System.out.println(ans);
		else System.out.println(-1);
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
