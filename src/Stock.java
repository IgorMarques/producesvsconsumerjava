import java.util.ArrayList;


public class Stock {

	int capacity;
	int counter;
	int iterations;
	int total_iterations;
	
	public Stock(int n, int i){
		capacity = n;
		counter = 0;
		total_iterations = i;
	}
	
	public boolean isEmpty(){
		if (counter==0)
			return true;
		return false;
	}
	
	public boolean isFull(){
		if(counter < capacity)
			return false;
		return true;
	}
	
	public boolean addProduct(){
		System.out.println(iterations++);
		if (isFull())
			return false;
		else
			System.out.println(counter++);
		return true;
	}
	
	public boolean removeProduct(){
		System.out.println(iterations++);
		if (isEmpty())
			return false;
		else
			System.out.println(counter--);
		return true;
	}

	public boolean isFinished() {
		if(iterations < total_iterations)
			return false;
		return true;
	}
	
}
