package tony.java.exe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

public class TestObjectInputOutputStream {
	//对象的反序列化过程： 将硬盘中的文件通过ObjectInputStream转换为相应的对象
	@Test
	public void test2(){
		
		ObjectInputStream ois = null;
		
		try{
			ois = new ObjectInputStream(new FileInputStream("person.txt"));
			Person p1 = (Person)ois.readObject();
			System.out.println(p1);
			Person p2 = (Person)ois.readObject();
			System.out.println(p2);
			
			
		} catch (IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ois != null) {
				
				try{
					ois.close();
				} catch (IOException e){
					e.printStackTrace();
				}
				
			}

			
			
		}
		
		
	}
	
	
	
	
	
	
	
	//对象的序列化过程: 将内存中的对象通过ObjectOutputStream转换为二进制流，存储在硬盘文件中
	@Test
	public void test1(){
		
		Person p1 = new Person("xiao", 23, new Pet("huahua"));
		Person p2 = new Person("hong", 26, new Pet("xiaohua"));
		
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
			
			oos.writeObject(p1);
			oos.flush();
			oos.writeObject(p2);
			oos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			if(oos != null)
				try {
						oos.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		}
		
	
	}
}

/*
 * 要实现序列化的类：
 * 1. 要求此类是可序列华的：实现Serializable 接口
 * 2. 要求类的属性同样的要实现Serializable 接口
 * 3. 提供一个版本号: private static final long serialVersionUID
 * 4. static的属性不能反序列化
 *
 *
 *
 */
class Person implements Serializable{
	private static final long serialVersionUID = 12412;
	
	
	String name;
	Integer age;
	Pet pet;
	
	public Person(String name, Integer age, Pet pet){
	this.name = name;
	this.age = age;
	this.pet = pet;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", pet=" + pet + "]";
	}


	
	
	
}


class Pet implements Serializable{
	
	String name;
	public Pet(String name){
		this.name = name;
	}
	@Override
	public String toString() {
		return "Pet [name=" + name + "]";
	}
	
	
	
	
	
	
	
}

