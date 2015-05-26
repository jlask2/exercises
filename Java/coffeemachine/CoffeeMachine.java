/**
 * 
 */
package coffeemachine;

/**
 * @author Jay
 *
 */
public abstract class CoffeeMachine {
	
	protected Holder holder;
	private Coffee typeOfCoffee;
	
	abstract protected boolean isPowered();
	abstract protected void setPower(boolean power);
	abstract protected void setHolder(Holder holder);
	abstract protected boolean isHolderPresent();
	abstract protected void setHolderPresence();
	abstract protected void removeHolder();
	abstract protected boolean enoughWater(int sizeOfCoffeToBeBrewed);
	abstract protected void fillWater(int cups);	
	abstract protected boolean holderFillCapacityExceeded(int sizeOfCoffeeToBeBrewed, Holder holder);
	abstract protected void brew(int sizeSelected, Holder holder, Coffee typeOfCoffee);
}
