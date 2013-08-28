
public class Bakery implements Lockable {

	int n;	
	boolean[] choosing;	
	int[] number;
	
	public Bakery(int numProc){
		n = numProc;
		choosing = new boolean[n];
		number= new int[n];
		
		for (int i = 0; i < n; i++) {
			choosing[i] = false;
			number[i]=0;
		}
	}
	
	@Override
	public void requestCS(int pid) {
		
		choosing[pid]=true;
		
		for (int i = 0; i < n; i++){
			if(number[i] > number[pid]){
				number[pid]=number[i];
			}
		}	
		
		number[pid]++;
		choosing[pid]=false;
		
		for (int i = 0; i < n; i++) {
			while(choosing[i]);
			
			while((number[i]!= 0) &&
					((number[i]< number[pid]) ||
					((number[i]== number[pid]) && i <pid))
					);
		}

	}

	@Override
	public void releaseCS(int pid) {
		number[pid]=0;

	}

}
