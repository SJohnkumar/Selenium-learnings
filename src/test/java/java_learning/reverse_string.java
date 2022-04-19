package java_learning;

import java.util.Scanner;

import org.testng.annotations.Test;

public class reverse_string {
	@Test
	public void reverse_string() {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the String");
		String n = s.next();
		char[] string=n.toCharArray();
		System.out.println(string.length);
		
		for(int i=string.length-1;i>=0;i--)
		{
			System.out.print(string[i]);
		}
	}
}


