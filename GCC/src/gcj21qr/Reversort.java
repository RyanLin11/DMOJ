package gcj21qr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Reversort {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair implements Comparable<Pair> {
	    int v, x;
	    public Pair(int v, int x){
	        this.v = v;
	        this.x = x;
	    }
	    public int compareTo(Pair other){
	        return Integer.compare(this.v, other.v);
	    }
	}
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for(int t = 1; t<=T; t++){
		    int N = readInt();
		    int cost = 0;
		    Pair[]arr = new Pair[N];
		    for(int i = 0; i<N; i++){
		        arr[i] = new Pair(readInt(), i);
		    }
		    Arrays.sort(arr);
		    for(int i = 0; i<N-1; i++){
		        double pivot = (arr[i].x + i)/2.0;
		        cost += arr[i].x - i + 1;
		        for(int j = i+1; j<N; j++) {
		        	if(arr[j].x <= arr[i].x) {
		        		arr[j].x += (int)((pivot - arr[j].x) * 2);
		        	}
		        }
		    }
		    System.out.println("Case #"+t+": "+cost);
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