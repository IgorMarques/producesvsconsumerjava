
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
	
		while(true){
			
			lock.requestCS(myNumber);
			
			stock.addProduct();	
			
			yield();
			
			lock.releaseCS(myNumber);
			yield();

		}
		
	}
	

}
