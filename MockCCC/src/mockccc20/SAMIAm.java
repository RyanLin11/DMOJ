package mockccc20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;

public class SAMIAm {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String s = next(); 
		int q = readInt();
		int mod = (int)1e9+7;
		int f = 31;
		long[]pow = new long[s.length()+q+1];
		pow[0] = 1;
		for(int i = 1; i<pow.length; i++) {
			pow[i] = (pow[i-1]*f)%mod;
		}
		HashMap<Long,Integer>[]map = new HashMap[s.length()+q+1];
		for(int i = 0; i<map.length; i++) {
			map[i] = new HashMap<>();
		}
		long basehash = 0;
		for(int i = 0; i<s.length(); i++) {
			basehash = (basehash + (s.charAt(i)%96)*pow[i])%mod;
			map[i+1].put(basehash, 0);
		}
		ArrayList<Long>h = new ArrayList<>();
		ArrayList<Integer>len = new ArrayList<>();
		h.add(basehash); len.add(s.length());
		int curIndex = 1;
		for(int i = 0; i<q; i++) {
			char c = readCharacter();
			if(c=='C') {
				int in = readInt()-1, ch = readCharacter()%96;
				long hash = (h.get(in)+ch*pow[len.get(in)])%mod;
				int length = len.get(in)+1;
				h.add(hash);
				len.add(length);
				if(!map[length].containsKey(hash))map[length].put(hash, curIndex);
				curIndex++;
			} else {
				char[]ch = next().toCharArray();
				long hash = 0;
				int ans = -2;
				for(int j = 0; j<ch.length; j++) {
					hash = (hash+(ch[j]%96)*pow[j])%mod;
					if(map[j+1].containsKey(hash)) {
						ans = map[j+1].get(hash);
					} else {
						break;
					}
				}
				System.out.println(ans+1);
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
