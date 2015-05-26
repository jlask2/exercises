package coffeemachine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CoffeeMaker extends CoffeeMachine {

	/**Members for Specs*/
	private String brand;
	private ArrayList<String> acceptedTypesOfCoffee;
	private float price;
	private int model;
	
	private String specString;
	private String stateString;

	/**Members for state*/
	private int sizeOfCoffeeToBeBrewed;
	private int currentWater;
	private boolean holderPresent;
	private boolean occupiedWithHolder;
	private boolean power;
	
	private int amountOfCoffeeBrewed;	
	
	final private int MAXWATERCAPACITY = 25;
	
	public CoffeeMaker(String brand, ArrayList<String> acceptedTypesOfCoffee, float price, int model){
		this.brand = brand;
		this.acceptedTypesOfCoffee = acceptedTypesOfCoffee;
		this.price = price;
		this.model = model;
		specString = "Specifications of Coffee Machine:\n\tBrand: \t"+this.brand+"\n\tAcceptedTypesOfCoffee: \t";
		Iterator<String> ite = this.acceptedTypesOfCoffee.iterator();
		while(ite.hasNext()){
			specString += ite.next()+" ";
		}
		specString += "\n\tPrice: \t"+this.price+"\n\tModel: \t"+this.model+"\n";
	}
	
	@Override
	protected boolean isPowered() {
		if(power){
			return true;
		}else{
			return false;
		}
	}
	
	@Override 
	protected void setPower(boolean power){
		this.power = power;
	}

	@Override
	public void setHolder(Holder selectedHolder){
	    holder = selectedHolder;
	}
	
	@Override
	public void setHolderPresence(){
		if(!holderPresent){
			holderPresent = true;
		}else{
			System.out.println("The Coffee Machine already has a holder present");
		}
	}
	
	@Override
	public void removeHolder(){
		if(holder == null || (!isHolderPresent())){
			System.out.println("There is no holder to remove!\n");
		}else{
			holderPresent = false;
		}
	}
	
	@Override
	protected boolean enoughWater(int amtOfCoffeToBeBrewed) {
		if(currentWater < amtOfCoffeToBeBrewed){
			return false;
		}else{
			return true;
		}
	}

	@Override
	protected void fillWater(int cups) {
		currentWater += cups;
		if(currentWater > MAXWATERCAPACITY){
			System.out.println("Too much water trying to be added to machine. \n"+
					"Filling current water level to max water level " + MAXWATERCAPACITY );
			currentWater = MAXWATERCAPACITY;
		}
	}
	
	@Override
	protected boolean holderFillCapacityExceeded(int amtOfCoffeeToBeBrewed, Holder holder){
		if(holder.getSize() < amtOfCoffeeToBeBrewed){
			return true;
		}else{
			return false;
		}
	}

	@Override
	protected void brew(int sizeSelected, Holder holder, Coffee typeOfCoffee) {
		Scanner scan = new Scanner(System.in);
		String ans = "";
		int addedWater = 0;
		if(isPowered()){
			if(isHolderPresent()){
				if(enoughWater(sizeSelected)){
					if(!holderFillCapacityExceeded(sizeSelected, holder)){
						currentWater -= sizeSelected;
						if(currentWater < 0){
							amountOfCoffeeBrewed = sizeSelected + currentWater;
							currentWater = 0;
						}else{
							amountOfCoffeeBrewed = sizeSelected;
						}
						System.out.println("Cup O' Java Successfully Brewed! \n\n"+toString());
					}
				}else{
					System.out.println("Would you like to add some water? y/n \n");
					ans = scan.next();
					if(!ans.equals("") &&( ans.equals("Y") || ans.equals("y") || ans.equals("yes") || ans.equals("Yes"))){
						System.out.println("Please enter the amount of water you would like to add in ounces.\n"
								+ "The current water level is now "+currentWater+" ounces \n");
						addedWater = scan.nextInt();
						fillWater(addedWater);
						System.out.println("The current water level is now "+currentWater+" ounces \n");
						if(!holderFillCapacityExceeded(sizeSelected, holder)){
							currentWater -= sizeSelected;
							if(currentWater < 0){
								amountOfCoffeeBrewed = sizeSelected + currentWater;
								currentWater = 0;
							}else{
								amountOfCoffeeBrewed = sizeSelected;
							}
							System.out.println("Cup O' Java Successfully Brewed! \n\n"+toString());
						}
					}else{
						if(!holderFillCapacityExceeded(sizeSelected, holder)){
							currentWater -= sizeSelected;
							if(currentWater < 0){
								amountOfCoffeeBrewed = sizeSelected + currentWater;
								currentWater = 0;
							}else{
								amountOfCoffeeBrewed = sizeSelected;
							}
							System.out.println("Cup O' Java Successfully Brewed! \n\n"+toString());
						}
					}
				}
			}else{
				System.out.println("Would you like to place a holder? y/n\n");
				ans = scan.next();
				if(!ans.equals("") &&( ans.equals("Y") || ans.equals("y") || ans.equals("yes") || ans.equals("Yes"))){
					setHolder(holder);
					setHolderPresence();
					System.out.println("Holder has been placed.\n");
				}else{
					System.out.println("Remaining in waiting state");
				}
			}
		}else{
			System.out.println("Would you like to turn the Coffee Machine On? y/n\n");
			ans = scan.next();
			if(!ans.equals("") &&( ans.equals("Y") || ans.equals("y") || ans.equals("yes") || ans.equals("Yes"))){
				power = true;
				System.out.println("Coffee Machine is powered on: Power State = "+power+"\n");
			}else{
				System.out.println("Remaining in waiting state");
			}
		}
	}
	
	@Override
    public String toString(){
		stateString = specString+"Stats of Coffee Machine System State: \n";
		stateString += "\tPowered ON: \t"+power+"\n\tCurrent Water Level:\t"
				+currentWater+"\n\tCup Holder Occuppied: \t"
				+holderPresent+"\n\tAmount of Coffee Brewed: \t"
				+amountOfCoffeeBrewed+"\n";
		return stateString;
	}
	
	public boolean getPower(){
		return power;
	}
	
	public int getCurrentWater(){
		return currentWater;
	}
	
	public int getCoffeeBrewed(){
		return amountOfCoffeeBrewed;
	}
	
	public boolean isHolderPresent() {
		return holderPresent;
	}
}
