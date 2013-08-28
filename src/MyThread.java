public class MyThread extends Thread{
	
	public int myNumber;
	public Counter counter;
	//public PetersonAlgorithm lock;
	public Lockable lock;
	
	public MyThread(int n, Counter c, Lockable lck){
		counter = c;		
		myNumber = n;
		lock = lck;
	}

	@Override
	public void run() {
		while(!counter.isFinished()){
			System.out.println("[Thread " + myNumber +"] Regiao nao Critica");
		
			System.out.println("[Thread "+ myNumber +"] Entrou na Regiao Critica");
			
			lock.requestCS(myNumber);
			
			System.out.println(myNumber + " " + counter.count);
			counter.increments();
			
			yield();
			
			lock.releaseCS(myNumber);
			
			yield();
		}
		
	}

}
