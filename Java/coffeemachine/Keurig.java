package coffeemachine;

import java.util.Scanner;

public class Keurig extends CoffeeMachine {

	/**Members for Specs*/
	private String brand;
	private String[] acceptedTypesOfCoffee;
	private float price;
	private int model;
	
	private String specString;
	private String stateString;

	/**Members for state*/
	private int sizeOfCoffeeToBeBrewed;
	private int currentWater;
	private boolean occupiedWithHolder;
	private boolean power;
	
	private int amountOfCoffeeBrewed;	
	
	final private int MAXWATERCAPACITY = 25;

	public Keurig(String brand, String[] acceptedTypesOfCoffee, float price, int model,
			int currentWater, boolean occupiedWithHolder, boolean power, int amountOfCoffeeBrewed){
		this.brand = brand;
		this.acceptedTypesOfCoffee = acceptedTypesOfCoffee;
		this.price = price;
		this.model = model;
		this.currentWater = currentWater;
		this.occupiedWithHolder = occupiedWithHolder;
		this.power = power;
		this.amountOfCoffeeBrewed = amountOfCoffeeBrewed;
	}
	
	public Keurig(String brand, String[] acceptedTypesOfCoffee, float price, int model){
		this.brand = brand;
		this.acceptedTypesOfCoffee = acceptedTypesOfCoffee;
		this.price = price;
		this.model = model;
		specString = "Specifications of Coffee Machine:\n\tBrand: \t"+this.brand+"\n\tAcceptedTypesOfCoffee: \t";
		for(int i = 0; i < acceptedTypesOfCoffee.length; i++){
			specString += acceptedTypesOfCoffee[i]+" ";
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
	protected boolean holderPresentState() {
		if(holder == null || !holder.isHolderPresent() || occupiedWithHolder){
			return false;
		}else{
			occupiedWithHolder = true;
			return true;
		}
	}
	
	@Override
	protected boolean enoughWater(int sizeOfCoffeToBeBrewed) {
		if(currentWater < sizeOfCoffeeToBeBrewed){
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
	protected boolean holderFillCapacityExceeded(int sizeOfCoffeeToBeBrewed, Holder holder){//int holderFillingCapacity) {
		if(holder.getSize()/*FillingCapacity*/ < sizeOfCoffeeToBeBrewed){
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
			if(holderPresentState()){
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
					if(ans != "" &&( ans == "Y" || ans == "y" || ans == "yes" || ans == "Yes")){
						System.out.println("Please enter the amount of water you would like to add in ounces.\n"
								+ "The current water level is now "+currentWater+" ounces \n");
						addedWater = scan.nextInt();
						fillWater(addedWater);
						System.out.println("The current water level is now "+currentWater+" ounces \n");
					}else{
						
					}
				}
			}
		}
	}
	
	@Override
    public String toString(){
		stateString = specString+"Stats of Coffee Machine System State: \n";
		stateString += "\tPowered ON: \t"+power+"\n\tCurrent Water Level:\t"
				+currentWater+"\n\tCup Holder Occuppied: \t"
				+occupiedWithHolder+"\n\tAmount of Coffee Brewed: \t"
				+amountOfCoffeeBrewed+"\n";
		return stateString;
	}
	
	public boolean getPower(){
		return power;
	}
	
	public int getCurrentWater(){
		return currentWater;
	}
	
	public boolean getOccupied(){
		return occupiedWithHolder;
	}
	
	public int getCoffeeBrewed(){
		return amountOfCoffeeBrewed;
	}
}
