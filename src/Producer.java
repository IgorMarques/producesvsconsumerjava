import java.lang.reflect.Array;
import java.util.ArrayList;


public class Producer extends Thread{
	
	Stock stock;
	Lockable lock;
	int myNumber;
	
	public Producer(Stock s, Lockable lck, int n){
		stock = s;
		lock = lck;
		myNumber = n;
	}
	
	@Override
	public void run() {
	
		while(!stock.isFinished()){
			
			lock.requestCS(myNumber);
			
			if (stock.addProduct()) 
				System.out.println("Produto adicionado!");
			else
				System.out.println("Estoque cheio!");
			
			yield();
			
			lock.releaseCS(myNumber);
			yield();
		}
		
	}
	

}
