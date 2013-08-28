import java.lang.reflect.Array;
import java.util.ArrayList;


public class Consumer extends Thread{
	
	Stock stock;
	Lockable lock;
	int myNumber;
	
	public Consumer(Stock s, Lockable lck, int n){
		stock = s;
		lock = lck;
		myNumber = n;
	}
	
	@Override
	public void run() {
	
		while(!stock.isFinished()){
			
			lock.requestCS(myNumber);
			
			if (stock.removeProduct()) 
				System.out.println("Produto removido!");
			else
				System.out.println("Estoque vazio!");
			
			yield();
			
			lock.releaseCS(myNumber);
			yield();
		}
		
	}
	

}
