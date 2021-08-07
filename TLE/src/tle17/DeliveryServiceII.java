package tle17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DeliveryServiceII {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), D = readInt();
		int minDl = Integer.MAX_VALUE, maxDl = Integer.MIN_VALUE; //left to right
		int minDr = Integer.MAX_VALUE, maxDr = Integer.MIN_VALUE; //right to left
		int minP = Integer.MAX_VALUE, maxP = Integer.MIN_VALUE; //pickups
		int[]pos = new int[N];
		for(int i = 0; i<N; i++) {
			pos[i] = readInt();
		}
		for(int i = 0; i<D; i++) {
			int x = readInt()-1, y = readInt()-1;
			minP = Math.min(minP, pos[x]);
			maxP = Math.max(maxP, pos[x]);
			if(pos[x] > pos[y]) minDl = Math.min(minDl, pos[y]);
			minDr = Math.min(minDr, pos[y]);
			if(pos[x] < pos[y]) maxDr = Math.max(maxDr, pos[y]);
			maxDl = Math.max(maxDl, pos[y]);
		}
		/*int ans = 0;
		if(minDl >= maxP) ans = maxDl - minP; //Deliveries are entirely to the right of Pickups
		else if(maxDl >= maxP) ans = maxP - Math.min(minDl, minP) + maxDl - Math.min(minDl, minP); //Delivery is to the right but overlaps
		else if(minP >= maxDr) ans = maxP - minDr; //Pickups are entirely to the right of Deliveries
		else ans = maxP - Math.min(minDr, minP) + maxDr - Math.min(minDr, minP);//Pickups are to the right but overlaps*/
		
		int ans = Integer.MAX_VALUE;
		if(minDl >= maxP || maxDr <= minP) {
			if(minDl >= maxP) ans = Math.min(ans, maxDl - minP);
			if(maxDr <= minP) ans = Math.min(ans, maxP - minDr);
		} else {
			ans = Math.min(ans, Math.max(maxDl, maxP) - minP + Math.max(maxDl, maxP) - minDl); //left to right initial motion
			ans = Math.min(ans, maxP - Math.min(minP, minDr) + maxDr - Math.min(minP, minDr)); //right to left initial motion
		}
		System.out.println(ans);
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
