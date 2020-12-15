package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class TestIO {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("txt\\test.txt")));
		String s = br.readLine();
		System.out.println(s);
		String[] s1=s.split(" ");
		Set<String> s2 = new HashSet<String>();
		for(int i = 0;i<s1.length;i++) {
			s2.add(s1[i]);
		}
		for (String string : s2) {
			System.out.print(string);
		}
		String zm = br.readLine();
		System.out.println(zm.toUpperCase());
		System.out.println(zm.toLowerCase());
		
		char[] c = new char[26];
		for(int i = 0;i<c.length;i++) {
			c[i] =(char) ('A' +i);
		}
		for (char ch : c) {
			System.out.println(ch);
		}
	}

}
