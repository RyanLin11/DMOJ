package vm7wc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		char[][]arr = {{'G','G','G','G','G'},{'G','.','.','.','.'},{'G','.','.','G','G'},{'G','.','.','.','G'},{'G','G','G','G','G'}};
		int N = readInt();
		char[][]ans = new char[N*5][N*5];
		for(int i = 0; i<5; i++) {
			for(int j = 0; j<5; j++) {
				for(int k = i*N; k<(i+1)*N; k++) {
					for(int l = j*N; l<(j+1)*N; l++) {
						ans[k][l] = arr[i][j];
					}
				}
			}
		}
		for(int i = 0; i<ans.length; i++) {
			for(int j = 0; j<ans[i].length; j++) {
				System.out.print(ans[i][j]);
			}
			System.out.println();
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
