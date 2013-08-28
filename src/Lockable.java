
public interface Lockable {

	public void requestCS(int pid);
	
	public void releaseCS(int pid);
}
