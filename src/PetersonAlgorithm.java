public class PetersonAlgorithm implements Lockable  {
	
	public PetersonAlgorithm() {
	}

	boolean wantAccess[] = {false, false};

	int turn = 1;
	
	@Override
	public void requestCS(int pid) {
		
		int otherpid= 1 - pid;
		
		wantAccess[pid]=true;
		
		turn = otherpid;
		
		while(wantAccess[otherpid] && (turn==otherpid));
				
	}

	@Override
	public void releaseCS(int pid) {
		
		wantAccess[pid] = false;
		
	}

}
