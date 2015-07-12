package tony.java.exe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;




public class MyInput {

	public String nextString(){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		try{
			str = br.readLine();
		} catch (IOException e){
			e.printStackTrace();
		}
		return str;
	}
	public int nextInt(){
		return Integer.parseInt(nextString());
	}
	public boolean nextBoolean(){
		return Boolean.parseBoolean(nextString());
	}
	
	
	public static void main(String[] args) {
		MyInput i = new MyInput();
		System.out.println("Please input s String: ");
		String str = i.nextString();
		System.out.println(str);
	}
}
