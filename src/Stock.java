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
	
	public void addProduct(){
		iterations++;
		if (isFull())
			System.out.println("Estoque cheio!");
		else
			System.out.println("Produto adicionado! Produtos em estoque: " + counter++);
		
		
	}
	
	public void removeProduct(){
		iterations++;
		if (isEmpty())
			System.out.println("Estoque vazio!");
		else
			System.out.println("Produto removido! Produtos em estoque: " + counter--);
		
		
	}

	public boolean isFinished() {
		if(iterations < total_iterations)
			return false;
		return true;
	}
	
}
