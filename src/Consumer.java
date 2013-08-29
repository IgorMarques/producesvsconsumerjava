
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
	
		while(true){
			
			lock.requestCS(myNumber);
			
			stock.removeProduct();
			
			yield();
			
			lock.releaseCS(myNumber);
			yield();
			
		}
		
	}
	

}
