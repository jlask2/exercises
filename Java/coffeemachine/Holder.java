/**
 * 
 */
package coffeemachine;

/**
 * @author Jay
 *
 */            
public final class Holder {
	
	private String type;
	private int fillingCapacity; // in oz.
	private int currentFill;
	
	
	public Holder(String type, int fillingCapacity){
		this.type = type;
		this.fillingCapacity = fillingCapacity;
	}

	public String getType() {
		return type;
	}

	public int getSize() {
		return fillingCapacity;
	}
	
	protected void setCurrentFill(int amtToAdd){
	   if((amtToAdd + currentFill) > fillingCapacity){
		   currentFill = fillingCapacity;
		   System.out.println("\nThis will result in a overflow (In the physical sense, your coffeee is spilling!)\n");
	   }else{
		   currentFill = currentFill + amtToAdd;
	   }
	}
	
	public int getCurrentFill(){
		return currentFill;
	}
	
	public void emptyHolder(){
		currentFill = 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Holder [type=" + type + ", fillingCapacity=" + fillingCapacity
				+ ", currentFill=" + currentFill + "]\n";
	}
}
