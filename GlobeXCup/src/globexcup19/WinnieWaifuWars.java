package globexcup19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class WinnieWaifuWars {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][]dif;
	static long maxSum = 0;
	public static void main(String[] args) throws IOException{
		int n = readInt(), m = readInt(), a = readInt(), b = readInt();
		int[][]arr = new int[6][10];
		for(int i = 0; i<6; i++) {
			for(int j = 0; j<10; j++) {
				arr[i][j] = readInt();
			}
		}
		long sum = 0;
		int num = Math.min(n/a, m/b);
		dif = new int[6][9];
		for(int i = 0; i<6; i++) {
			for(int j = 1; j<10; j++) {
				dif[i][j-1] = arr[i][j]-arr[i][j-1];
			}
		}
		recur(num, 0, 0);
		int index = 0;
		for(int i = 0; i<cur.size(); i++) {
			sum+=arr[i][cur.get(i)];
			index++;
		}
		for(int i = index; i<arr.length; i++) {
			sum+=arr[i][0];
		}
		System.out.println(sum);
	}
	static ArrayList<Integer>list = new ArrayList<>();
	static ArrayList<Integer>cur = new ArrayList<>();
	public static void recur(int n, int lvl, long sum) {
		if(n==0||lvl>=6) {
			if(sum>maxSum) {
				maxSum = sum;
				cur = copy(list);
			}
			return;
		}
		for(int i = 0; i<=Math.min(9,n); i++) {
			list.add(i);
			recur(n-i, lvl+1, sum+sum(lvl, i));
			list.remove(list.size()-1);
		}
	}
	public static int sum(int lvl, int depth) {
		int sum = 0;
		for(int i = 0; i<depth; i++) {
			sum+=dif[lvl][i];
		}
		return sum;
	}
	public static ArrayList<Integer> copy(ArrayList<Integer>orig){
		ArrayList<Integer>copy = new ArrayList<>();
		for(int i = 0; i<orig.size(); i++) {
			copy.add(orig.get(i));
		}
		return copy;
	}
	public static String next () throws IOException {
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
