package bfs17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class CrowdedCities {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Block implements Comparable<Block> {
		int id, l, w, h; long p;
		public Block(int id, int l, int w, int h, long p) {
			this.id = id;
			this.l = l;
			this.w = w;
			this.h = h;
			this.p = p;
		}
		public int compareTo(Block other) {
			if(this.l<other.l) {
				return -1;
			} else if(this.l>other.l) {
				return 1;
			} else {
				if(this.w<other.w) {
					return -1;
				} else if(this.w>other.w) {
					return 1;
				} else {
					if(this.h<other.h) {
						return -1;
					} else if(this.h>other.h) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		}
	}
	static int[][]bit;
	static int[]pre;
	static ArrayList<Block>list;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		list = new ArrayList<>();
		for(int i = 0; i<N; i++) {
			int l = readInt(), w = readInt(), h = readInt(); long p = readLong();
			//lw wl
			list.add(new Block(i+1,l,w,h,p));
			if(w!=l) {
				list.add(new Block(i+1,w,l,h,p));
			}
		}
		Collections.sort(list);
		bit = new int[5001][5001];
		pre = new int[list.size()];
		for(int i = 0; i<list.size(); i++) {
			update(i);
		}
		long max = 0;
		int maxIndex = 0;
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).p>max) {
				max = list.get(i).p;
				maxIndex = i+1;
			}
		}
		System.out.println(max);
		ArrayList<Integer>lis = new ArrayList<>();
		for(int i = maxIndex; i>0; i=pre[i-1]) {
			lis.add(i);
		}
		System.out.println(lis.size());
		for(int i: lis) {
			System.out.print(list.get(i-1).id+" ");
		}
		System.out.println();
	}
	public static void update(int idx) {
		Block b = list.get(idx);
		//find maximum less than it
		long max = 0;
		int maxidx = 0;
		for(int i = b.w; i>0; i-=i&(-i)) {
			for(int j = b.h; j>0; j-=j&(-j)) {
				if(bit[i][j]!=0 && list.get(bit[i][j]-1).p>max) {
					max = list.get(bit[i][j]-1).p;
					maxidx = bit[i][j];
				}
			}
		}
		b.p += max;
		pre[idx] = maxidx;
		//add point to 2d array
		for(int i = b.w; i<bit.length; i+=i&(-i)) {
			for(int j = b.h; j<bit[i].length; j+=j&(-j)) {
				if(bit[i][j]==0 || b.p>list.get(bit[i][j]-1).p) {
					bit[i][j] = idx+1;
				}
			}
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
