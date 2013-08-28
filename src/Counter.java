public class Counter{
	public int count=0;
	public int total;
	
	public Counter(int t){
		total = t;
	}
	
	public void increments(){
		count++;
	}

	public boolean isFinished() {
		if (count < total)
			return false;
		return true;
	}
}
