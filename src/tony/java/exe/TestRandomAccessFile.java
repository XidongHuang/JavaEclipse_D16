package tony.java.exe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;
/*
 * RandomAccessFile: 支持随机访问
 * 1. 既可以充当一个输入流，又可以充当一个输出流
 * 2. 支持从文件的开头读取，写入
 * 3. 支持从文件的任意位置读取，写入（插入）
 * 
 * 
 * 
 */
import org.omg.CORBA.IRObject;

public class TestRandomAccessFile {
	
	
	//相对于test3，更通用
	@Test
	public void test4(){
		
		RandomAccessFile raf1 = null;
		try {
			raf1 = new RandomAccessFile(new File("Random.txt"), "rw");
			raf1.seek(4);
			
			byte[] bs = new byte[10];
			int len;
			StringBuffer sb = new StringBuffer();
			while((len = raf1.read(bs))!= -1){
				sb.append(new String(bs, 0, len));
			}
			raf1.seek(4);
			raf1.write("su".getBytes());
			raf1.write(sb.toString().getBytes());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(raf1 != null){
				try {
					raf1.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
			
		}
		}
	
	
	
	
	
	//实现插入的效果: 在d字符后面插入"xy“
	@Test
	public void test3(){
		
		RandomAccessFile raf1 = null;
		try {
			raf1 = new RandomAccessFile(new File("Random.txt"), "rw");
			raf1.seek(4);
			String str1 = raf1.readLine();
			raf1.seek(4);
			
			raf1.write("^^".getBytes());
			raf1.write(str1.getBytes());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(raf1 != null){
				try {
					raf1.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
			
			
		}
		
		
		
		
		
	}
	
	//实现的实际上是覆盖的效果
	@Test
	public void test2(){
		
		RandomAccessFile raf1 = null;
		try {
			raf1 = new RandomAccessFile(new File("Random.txt"), "rw");
			raf1.seek(3);
			raf1.write("&&".getBytes());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(raf1 != null){
				try {
					raf1.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
			
			
		}
		
	}
	
	
	
	//进行文件的读，写
	@Test
	public void test1(){
		RandomAccessFile raf1 = null;
		RandomAccessFile raf2 = null;
		try {
			raf1 = new RandomAccessFile(new File("Random.txt"), "r");
			raf2 = new RandomAccessFile(new File("Random1.txt"), "rw");
			
			byte[] b = new byte[20];
			
			int len;
			while((len = raf1.read(b)) != -1){
				raf2.write(b, 0, len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			if(raf1 != null){
			try{
				raf1.close();
			}catch (IOException e){
				e.printStackTrace();
			}
			}
			if(raf2 != null){
			try{
				raf2.close();
			}catch (IOException e){
				e.printStackTrace();
			}
			}
		}
	}
}
