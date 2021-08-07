package cco09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Arrays;
import java.text.DecimalFormat;
import java.util.*;

public class AWeightyProblem {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int C = readInt(), D = readInt(), K = readInt();
		HashMap<Integer,Double>dtow = new HashMap<>();
		HashMap<Integer,Integer>dtoc = new HashMap<>();
		int[]d = new int[D];
		double[]w = new double[D];
		int[]c = new int[D];
		for(int i = 0; i<D; i++) {
			d[i] = readInt();
			dtow.put(d[i], readDouble());
		}
		double wt = 0;
		for(int i = 0; i<K; i++) {
			int x = readInt();
			if(dtoc.containsKey(d[x-1])) dtoc.put(d[x-1], dtoc.get(d[x-1])+1);
			else dtoc.put(d[x-1], 1);
		}
		Arrays.sort(d);
		for(int i = 0; i<d.length; i++) {
			w[i] = dtow.get(d[i]);
			if(dtoc.containsKey(d[i]))c[i] = dtoc.get(d[i]);
			wt+=w[i]*c[i];
		}
		double[]ch = new double[200001];
		int in = 0;
		for(int i = 1; i<ch.length; i++) {
			for(int j = in+1; j<d.length; j++) {
				if(i>=d[j]) in++;
				else break;
			}
			ch[i] = ch[i-d[in]]+w[in];
		}
		TreeSet<Integer>set = new TreeSet<>();
		HashSet<Integer>temp = new HashSet<>();
		double[]p = new double[200001];
		p[0] = 0; set.add(0);
		for(int i = 0; i<d.length; i++) {
			Iterator<Integer>it = set.descendingIterator();
			while(it.hasNext()) {
				int x = it.next();
				for(int j = 1; j<=c[i]; j++) {
					int y = x+j*d[i];
					p[y] = Math.max(p[x]+j*w[i],p[y]);
					if(!set.contains(y)) temp.add(y);
				}
			}
			set.addAll(temp);
			temp.clear();
		}
		double min = Integer.MAX_VALUE;
		Iterator<Integer> it = set.descendingIterator();
		while(it.hasNext()) {
			int x = it.next();
			if(x>=C) {
				min = Math.min(min, wt-p[x]+ch[x-C]);
			} else break;
		}
		if(min==Integer.MAX_VALUE) {
			System.out.println("too poor");
			return;
		}
		min = Math.round(min*100)/100.0;
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(df.format(min));
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
