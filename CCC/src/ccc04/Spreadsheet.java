package ccc04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Spreadsheet {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<String>[][]list = new ArrayList[10][9];
	static boolean[][]visited = new boolean[10][9];
	static String[][]arr = new String[10][9];
	static int[][]val = new int[10][9];
	public static void main(String[] args) throws IOException {
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<9; j++) {
				arr[i][j] = next();
			}
		}
		for(int i = 0; i<list.length; i++) {
			for(int j = 0; j<list[i].length; j++) {
				list[i][j] = new ArrayList<>();
			}
		}
		for(int i = 0; i<val.length; i++) {
			for(int j = 0; j<val[i].length; j++) {
				val[i][j] = -1;
			}
		}
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<9; j++) {
				if(!isNumber(arr[i][j])) {
					String[]cell = arr[i][j].split("\\+");
					for(int k = 0; k<cell.length; k++) {
						list[i][j].add(cell[k]);
					}
				} else {
					val[i][j] = Integer.parseInt(arr[i][j]);
				}
			}
		}
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<9; j++) {
				if(!isNumber(arr[i][j])&&arr[i][j]!="*") {
					visited = new boolean[10][9];
					int val = recurse(i, j);
					if(val==-1) {
						arr[i][j] = "*";
					} else {
						arr[i][j] = Integer.toString(val);
					}
				}
			}
		}
		for(int i = 0; i<val.length; i++) {
			for(int j = 0; j<val[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static boolean isNumber(String str) {
		for(int i = 0; i<str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	public static int recurse(int r, int c) {
		if(visited[r][c]||arr[r][c]=="*") return -1;
		if(val[r][c]!=-1) return val[r][c];
		ArrayList<String>al = list[r][c];
		int sum = 0;
		for(int i = 0; i<al.size(); i++) {
			int rx = ((int)al.get(i).charAt(0))%65;
			int cx = Integer.parseInt(al.get(i).charAt(1)+"")-1;
			visited[r][c] = true;
			int val = recurse(rx,cx);
			visited[r][c] = false;
			if(val>=0) {
				sum+=val;
			} else {
				arr[rx][cx] = "*";
				
				return -1;
			}
		}
		val[r][c] = sum;
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
