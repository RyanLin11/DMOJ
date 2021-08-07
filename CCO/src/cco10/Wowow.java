package cco10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Wowow {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]bit;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		ArrayList<Integer>rating = new ArrayList<>();
		char[]c = new char[N];
		int[]a = new int[N];
		int[]b = new int[N];
		for(int i = 0; i<N; i++) {
			c[i] = readCharacter();
			if(c[i]=='N') {
				a[i] = readInt(); 
				b[i] = readInt();
				rating.add(b[i]);
			} else if(c[i]=='M') {
				a[i] = readInt(); 
				b[i] = readInt();
				rating.add(b[i]);
			} else {
				a[i] = readInt();
			}
		}
		Collections.sort(rating, Collections.reverseOrder());
		HashMap<Integer, Integer>map = new HashMap<>();
		for(int i: rating) {
			map.put(i, map.size()+1);
		}
		int[]val = new int[1000001]; //val[i] is the value/rating of person i
		int[]id = new int[map.size()+2]; //id[i] is the person at rating i
		bit = new int[map.size()+2];
		for(int i = 0; i<N; i++) {
			if(c[i]=='N') {
				val[a[i]] = map.get(b[i]);
				id[val[a[i]]] = a[i];
				update(val[a[i]], 1);
			} else if(c[i]=='M') {
				update(val[a[i]], -1);
				val[a[i]] = map.get(b[i]);
				id[val[a[i]]] = a[i];
				update(val[a[i]], 1);
			} else {
				int l = 1, r = bit.length-1;
				int ans = -1;
				while(l<=r) {
					int mid = (l+r)/2;
					int sum = sum(mid);
					if(sum<a[i]) {
						l = mid+1;
					} else if(sum>a[i]){
						r = mid-1;
					} else {
						ans = mid;
						r = mid-1;
					}
				}
				System.out.println(id[ans]);
			}
		}
		
	}
	public static void update(int x, int v) {
		for(int i = x; i<bit.length; i+=i&(-i)) {
			bit[i]+=v;
		}
	}
	public static int sum(int x) {
		int sum = 0;
		for(int i = x; i>0; i-=i&(-i)) {
			sum += bit[i];
		}
		return sum;
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
