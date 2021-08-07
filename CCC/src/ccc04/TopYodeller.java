package ccc04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class TopYodeller {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int c = readInt();
		int r = readInt();
		int[]rank = new int[c];
		Arrays.fill(rank, 1);
		int[]score2 = new int[c];
		for(int i = 0; i<r; i++) {
			int[]score = new int[c];
			for(int j = 0; j<c; j++) {
				int num = readInt();
				score2[j]+= num;
				score[j] = score2[j];
			}
			Arrays.sort(score);
			int ranking = 0;
			int rankscore = -1001;
			int[]roundrank = new int[c];
			for(int j = score.length-1; j>=0; j--) {
				if(score[j]!=rankscore) ranking = score.length-j;
				for(int k = 0; k<score2.length; k++) {
					if(score2[k]==score[j]) roundrank[k] = ranking;
				}
				rankscore = score[j];
			}
			for(int j = 0; j<roundrank.length; j++) {
				if(rank[j]<roundrank[j]) rank[j] = roundrank[j];
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<c; i++) {
			if(score2[i]>max) {
				max = score2[i];
			}
		}
		for(int i = 0; i<c; i++) {
			if(score2[i]==max) {
				System.out.println("Yodeller "+(i+1)+" is the TopYodeller: score "+score2[i]+", worst rank "+rank[i]);
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
