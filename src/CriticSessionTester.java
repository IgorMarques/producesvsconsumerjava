import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class CriticSessionTester {
	
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(6);
		
		System.out.println("---Iniciando Peterson---\n\n");
		
		Counter c = new Counter(10);
		
		PetersonAlgorithm petersonLock= new PetersonAlgorithm();
		
		
		MyThread p1 = new MyThread(0, c, petersonLock);
		MyThread p2 = new MyThread(1, c, petersonLock);
			
		//long start = System.nanoTime();
		
		executor.execute(p1);
		executor.execute(p2);	
		
		try {
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//long finish = System.nanoTime();
		
		//System.out.println(finish-start);
		
		System.out.println("\n\n\n\n\n\n---Iniciando Bakery---\n\n");
		
		c = new Counter(10);
		
		Bakery bakeryLock = new Bakery(2);
		
		MyThread b1 = new MyThread(0, c, bakeryLock);
		MyThread b2 = new MyThread(1, c, bakeryLock);
		
		//start = System.nanoTime();
		
		executor.execute(b1);
		executor.execute(b2);	
		
		try {
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//finish = System.nanoTime();
		
		//System.out.println(finish-start);
	}

}
