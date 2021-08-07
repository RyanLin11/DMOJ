package ccc02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Numbers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String[]arr = new String[9];
		arr[0] = " 0 0 0";
		arr[1] = "1     2";
		arr[2] = "1     2";
		arr[3] = "1     2";
		arr[4] = " 3 3 3";
		arr[5] = "4     5";
		arr[6] = "4     5";
		arr[7] = "4     5";
		arr[8] = " 6 6 6";
		HashSet<Integer>[]set = new HashSet[10];
		for(int i = 0; i<set.length; i++) set[i] = new HashSet<>();
		set[0].add(0); set[0].add(1); set[0].add(2); set[0].add(4); set[0].add(5); set[0].add(6);
		set[1].add(2); set[1].add(5);
		set[2].add(0); set[2].add(2); set[2].add(3); set[2].add(4); set[2].add(6);
		set[3].add(0); set[3].add(2); set[3].add(3); set[3].add(5); set[3].add(6);
		set[4].add(1); set[4].add(2); set[4].add(3); set[4].add(5);
		set[5].add(0); set[5].add(1); set[5].add(3); set[5].add(5); set[5].add(6);
		set[6].add(0); set[6].add(1); set[6].add(3); set[6].add(4); set[6].add(5); set[6].add(6);
		set[7].add(0); set[7].add(2); set[7].add(5);
		set[8].add(0); set[8].add(1); set[8].add(2); set[8].add(3); set[8].add(4); set[8].add(5); set[8].add(6);
		set[9].add(0); set[9].add(1); set[9].add(2); set[9].add(3); set[9].add(5); set[9].add(6);
		int n = readInt();
		for(int i = 0; i<arr.length; i++) {
			String str = "";
			boolean isEmpty = true;
			for(int j = 0; j<arr[i].length(); j++) {
				if(Character.isDigit(arr[i].charAt(j)) && set[n].contains(Integer.parseInt(arr[i].charAt(j)+""))) {
					isEmpty = false;
					str+="*";
				} else {
					str+=" ";
				}
			}
			for(int j = str.length()-1; j>=0; j--) {
				if(str.charAt(j)==' ')str = str.substring(0,j);
				else break;
			}
			if(!isEmpty) {
				System.out.println(str);
			} else if(i!=0 && i!=arr.length-1) {
				System.out.println();
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
