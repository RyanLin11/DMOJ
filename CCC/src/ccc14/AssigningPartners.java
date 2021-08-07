package ccc14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class AssigningPartners {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		String[]arr1 = new String[n];
		String[]arr2 = new String[n];
		HashMap<String,String>map = new HashMap<>();
		for(int i = 0; i<n; i++) {
			arr1[i] = next();
		}
		for(int i = 0; i<n; i++) {
			arr2[i] = next();
		}
		boolean good = true;
		for(int i = 0; i<n; i++) {
			if(arr1[i].equals(arr2[i])) {
				good = false;
				break;
			}
			if(map.containsKey(arr2[i])) {
				if(!map.get(arr2[i]).equals(arr1[i])) {
					good = false;
					break;
				}
			}
			map.put(arr1[i], arr2[i]);
		}
		System.out.println(good?"good":"bad");
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
