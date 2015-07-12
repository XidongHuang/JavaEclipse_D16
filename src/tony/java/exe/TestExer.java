package tony.java.exe;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestExer {
	
	//利用程序复制test.txt为test1.txt
	@Test
	public void test4(){
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			br = new BufferedReader(new FileReader("test1.txt"));
			bw = new BufferedWriter(new FileWriter("test4.txt"));
			
			char []c = new char[1024];
			int len;
			while((len = br.read(c)) != -1){
				bw.write(c, 0, len);
				bw.flush();
				
			} 
		
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null){
				try {
					br.close();
				} catch (IOException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			
			if(bw != null){
				try {
					bw.close();
				} catch (IOException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	
	
	//使用字符流实现内容的读入
	@Test
	public void test3(){
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("test1.txt")));

			String str;
			while((str = br.readLine()) != null){
				System.out.println(str);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally{
		if(br != null){
		try {
			br.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
			
		}
		}
	}
	
	//使用字符流实现内容的输出
	@Test
	public void test2(){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("test1.txt"));
			String str = "Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，"
					+ "是由Sun Microsystems公司于1995年5月推出的Java程序设计语言和Java平台"
					+ "（即JavaSE, JavaEE, JavaME）的总称。"
					+ "Java 技术具有卓越的通用性、高效性、平台移植性和安全性，广泛应用于个人PC、数据中心、游戏控制台、科学超级计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。"
					+ "在全球云计算和移动互联网的产业环境下，Java更具备了显著优势和广阔前景.";
			
			bw.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
		
		if(bw != null){
		try{
			bw.close();
		}catch (IOException e){
			e.printStackTrace();
		}
		}
		}
		
	}
	
	
	
	
	
	
	
	
	
	//使用字节流实现内容的输出
	@Test
	public void test1(){
//		FileOutputStream fos = new FileOutputStream(new File("test.txt"));
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(new File("test.txt")));
			
			String str = "Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，"
					+ "是由Sun Microsystems公司于1995年5月推出的Java程序设计语言和Java平台"
					+ "（即JavaSE, JavaEE, JavaME）的总称。"
					+ "Java 技术具有卓越的通用性、高效性、平台移植性和安全性，广泛应用于个人PC、数据中心、游戏控制台、科学超级计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。"
					+ "在全球云计算和移动互联网的产业环境下，Java更具备了显著优势和广阔前景.";
			
			bos.write(str.getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		if(bos != null){
			try{
				bos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		}
	}
	
}
