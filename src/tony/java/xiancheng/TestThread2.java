package tony.java.xiancheng;
//创建两个子线程，让其中一个输出1-100之间的偶数，另一个输出1-100之间的奇数


public class TestThread2 {
	public static void main(String[] args) {
//		ForOdd fo = new ForOdd();
//		ForEven fe = new ForEven();
//		
//		
//		fo.start();
//		fe.start();
		
		//继承于Thread类的匿名类的对象
		new Thread(){
			public void run(){
				for(int i =1; i<=100; i++){
					if(i %2 ==1){
						System.out.println(Thread.currentThread().getName()+": ===="+i);
						
					}
					
				}	
			}
			
			
			
			
		}.start();
		
		
		
		new Thread(){
			public void run(){
				for(int i =1; i<=100; i++){
					if(i %2 ==0){
						System.out.println(Thread.currentThread().getName()+": ===="+i);
						
					}
					
				}	
			}
			
			
			
			
		}.start();
		
		
		
	}
	

}


class ForOdd extends Thread{
	public void run(){
		for(int i =1; i<=100; i++){
			if(i %2 ==1){
				System.out.println(Thread.currentThread().getName()+": ===="+i);
				
			}
			
		}
		
		
	}
	
}



class ForEven extends Thread{
	public void run(){
		for(int i = 1;i<=100;i++){
			if(i %2 == 0){
				System.out.println(Thread.currentThread().getName()+": " +i);
				
				
			}
			
			
		}
		
		
	}
	
	
}