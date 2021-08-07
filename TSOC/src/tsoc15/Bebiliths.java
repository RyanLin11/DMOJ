package tsoc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Bebiliths {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int s;
	static class Bebilith implements Comparable<Bebilith>{
		int id, speed, dist, sharp;
		public Bebilith(int id, int speed, int dist, int sharp){
			this.id = id;
			this.speed = speed;
			this.dist = dist;
			this.sharp = sharp;
		}
		public int compareTo(Bebilith other) {
			if(this.speed==other.speed) {
				if(this.speed>=s) {
					if(this.sharp>other.sharp) {
						return -1;
					} else if(this.sharp<other.sharp) {
						return 1;
					} else {
						if(this.id<other.id) return -1;
						else return 1;
					}
				} else {
					if(this.dist>other.dist) {
						return -1;
					} else if(this.dist<other.dist) {
						return 1;
					} else {
						if(this.id<other.id) return -1;
						else return 1;
					}
				}
			} else {
				if(this.speed>other.speed) return -1;
				else return 1;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		s = readInt(); int n = readInt();
		Bebilith[]arr = new Bebilith[n];
		for(int i = 0; i<n; i++) {
			arr[i] = new Bebilith(i+1,readInt(), readInt(), readInt());
		}
		Arrays.sort(arr);
		int q = readInt();
		for(int i = 0; i<q; i++) {
			System.out.println(arr[readInt()-1].id);
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
