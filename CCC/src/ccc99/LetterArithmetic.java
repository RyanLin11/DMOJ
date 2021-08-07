package ccc99;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashSet;

public class LetterArithmetic {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]a,b,c,v;
	static String sa, sb, ans;
	static HashSet<Integer>set;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for(int i = 0; i<t; i++) {
			sa = next();
			sb = next();
			ans = next();
			a = new int[ans.length()];
			b = new int[ans.length()];
			c = new int[ans.length()];
			v = new int[27];
			Arrays.fill(v, -1);
			set = new HashSet<>();
			//for(int j = 0; j<9; j++) set.add(j);
			v[0] = 0;
			for(int j = 1; j<=ans.length(); j++) {
				c[ans.length()-j] = ans.charAt(ans.length()-j)%64;
				if(sa.length()-j>=0) a[ans.length()-j]=sa.charAt(sa.length()-j)%64;
				else a[ans.length()-j] = 0;
				if(sb.length()-j>=0) b[ans.length()-j]=sb.charAt(sb.length()-j)%64;
				else b[ans.length()-j] = 0;
			}
			//System.out.println(Arrays.toString(a));
			//System.out.println(Arrays.toString(b));
			//System.out.println(Arrays.toString(c));
			//f(ans.length()-1, 0);
			a(ans.length()-1, 0);
		}
	}
	public static void print() {
		if(v[sa.charAt(0)%64]!=0 && v[sb.charAt(0)%64]!=0) {
			for(int i = 0; i<sa.length(); i++) {
				System.out.print(v[sa.charAt(i)%64]);
			}
			System.out.println();
			for(int i = 0; i<sb.length(); i++) {
				System.out.print(v[sb.charAt(i)%64]);
			}
			System.out.println();
			for(int i = 0; i<ans.length(); i++) {
				System.out.print(v[ans.charAt(i)%64]);
			}
			System.out.println();
		}
	}
	public static void a(int in, int carry) {
		if(in<0) {
			print();
			return;
		}
		if(v[a[in]]<0) {
			for(int i = 0; i<10; i++) {
				if(!set.contains(i)) {
					set.add(i);
					v[a[in]] = i;
					b(in, carry);
					set.remove(i);
				}
			}
			v[a[in]] = -1;
		} else {
			b(in, carry);
		}
	}
	public static void b(int in, int carry) {
		if(v[b[in]]<0) {
			for(int i = 0; i<10; i++) {
				if(!set.contains(i)) {
					set.add(i);
					v[b[in]] = i;
					c(in, carry);
					set.remove(i);
				}
			}
			v[b[in]]= -1;
		} else {
			c(in, carry);
		}
	}
	public static void c(int in, int carry) {
		int add = v[a[in]]+v[b[in]]+carry;
		if(v[c[in]]<0) {
			if(!set.contains(add%10)) {
				v[c[in]] = add%10;
				set.add(v[c[in]]);
				a(in-1, add/10);
				set.remove(v[c[in]]);
			}
			v[c[in]] = -1;
		} else if(add%10==v[c[in]]) {
			a(in-1, add/10);
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
