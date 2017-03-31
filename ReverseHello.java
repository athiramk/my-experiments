/***************
* Reverse hello
*
* Write a program called ReverseHello.java that creates a thread (let's call it Thread 1). 
* Thread 1 creates another thread (Thread 2); Thread 2 creates Thread 3; and so on, up to Thread 50. 
* Each thread should print "Hello from Thread <num>!", but you should structure your program 
* such that the threads print their greetings in reverse order.
*****************/

class ReverseHello extends Thread{
	int counter;
	public App(int counter){
		this.counter=counter;
	}
	public void run()
	{
		if(counter<50)
		{
			createThread(counter+1);	
		}
		System.out.println("hello" + counter);	
	}
	public void createThread(int counter) {
		App t=new App(counter);
		t.start();		
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	public static void main(String[] arg){		
		ReverseHello t = new ReverseHello(1);
		t.start();		
	}
}
