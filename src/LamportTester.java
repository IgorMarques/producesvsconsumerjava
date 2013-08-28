import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class LamportTester {


	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(6);
		
		int nInstances = 5;
		int stockSize = 10;
		int iterations = 100;
		
		Bakery lck= new Bakery(nInstances);
		
		Stock s = new Stock(stockSize, iterations);
		
		Producer p1 = new Producer(s, lck, 0);
		Producer p2 = new Producer(s, lck, 1);
		
		Consumer c1 = new Consumer(s, lck, 2);
		Consumer c2 = new Consumer(s, lck, 3);
		Consumer c3 = new Consumer(s, lck, 4);
	
		
		executor.execute(p1);
		executor.execute(p2);	
		executor.execute(c1);	
		executor.execute(c2);	
		executor.execute(c3);	


		
	}

}
