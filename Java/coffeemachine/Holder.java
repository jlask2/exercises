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
	private boolean holderPresent;
	
	public Holder(String type, int fillingCapacity){
		this.type = type;
		this.fillingCapacity = fillingCapacity;
		this.holderPresent = false;
	}

	public String getType() {
		return type;
	}

	public int getSize() {
		return fillingCapacity;
	}

	public boolean isHolderPresent() {
		return holderPresent;
	}
	
	public void setHolderPresence(boolean set, boolean holderPresentState){
		if(set && !holderPresentState){
			holderPresent = true;
		}else{
			holderPresent = false;
		}
	}
}
