/**
 * 
 */
package coffeemachine;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jay
 *
 */
public class TestCoffeeMachine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\\n");
		String ans = "";
		
		int amtToAdd = 0;
		int amtToBrew = 0;
		
		String brand = "";
		String[] acceptedTypes;
		ArrayList<String> coffeeTypes = new ArrayList<String>();
		float price = (float) 0.00;
		int model = 0;
		
		String coffeeBrand = "";
		String coffeeType = "";
		float coffeePrice = (float) 0.00;
		int coffeeWeight = 0;
		
		String holderType = "";
		int holderCapacity = 0;
		
		coffeeBrand = "Maxwell House";
		coffeeType = "k-cup";
		coffeePrice = (float)1.00;
		coffeeWeight = 8;
		
		Coffee coffee = new Coffee(coffeeBrand, coffeeType, coffeePrice, coffeeWeight);
		
		holderType = "Cup";
		holderCapacity = 10;
		
		Holder holder = new Holder(holderType, holderCapacity);
		
		brand = "Keurig 2.0";
		price = (float)120.00;
		model = 123456;
		
		coffeeTypes.add("coffee");
		coffeeTypes.add("expresso");
		coffeeTypes.add("k-cups");
		
		
		CoffeeMaker coffeeMaker = new CoffeeMaker(brand, coffeeTypes, price, model);
		
		coffeeMaker.setPower(true);
		coffeeMaker.setHolder(holder);
		coffeeMaker.setHolderPresence();
		
		amtToAdd = 12;
		amtToBrew = 8;
	
		coffeeMaker.fillWater(amtToAdd);
		
		System.out.println("This is the initial test run of my Virtual Coffee Machine System.\n\n" +
				"This is the pre-condition of the test run with hard coded values:\n\n"
		+coffeeMaker.toString()
		+holder.toString()
		+coffee.toString());
		
		coffeeMaker.brew(amtToBrew, holder, coffee);
		
		System.out.println("This is the post-condition of the test run with hard coded values:\n\n"
				+coffeeMaker.toString()
				+holder.toString()
				+coffee.toString());
		
		System.out.println("\nHere is a interactive loop to test different aspects of the system.\n\n");
		do{
			System.out.println("Would you like to use a different coffee machine?");
			ans = scan.next();
			if(!ans.equals("") &&( ans.equals("Y") || ans.equals("y") || ans.equals("yes") || ans.equals("Yes"))){
				System.out.println("Enter the machine brand name:\n");
				brand = scan.next();
				System.out.println("Enter the machine price:\n");
				price = scan.nextFloat();
				System.out.println("Enter the machine model number:\n");
				model = scan.nextInt();
				System.out.println("Enter the accepted types of coffee (i.e. \"coffee\", \"tea\", \"k-cups\") :\n");
	
				String line = "";
				
				line = scan.next()+" ";
				acceptedTypes = line.split(" ");
				coffeeTypes = new ArrayList<String>();
				for(int i = 0; i < acceptedTypes.length; i++){
					coffeeTypes.add(acceptedTypes[i]);
				}
				coffeeMaker = new CoffeeMaker(brand, coffeeTypes, price, model);
				System.out.println("Initial condition of new machine:\n"+coffeeMaker.toString()+"\n");
				
			}else{
				System.out.println("Using the previous machine and state:\n"+coffeeMaker.toString()+"\n");
			}
			System.out.println("Would you like to use a new holder?\n");
			ans = scan.next();
			if(!ans.equals("") &&( ans.equals("Y") || ans.equals("y") || ans.equals("yes") || ans.equals("Yes"))){
				System.out.println("Enter the type of Holder you wish to use:\n");
				holderType = scan.next();
				System.out.println("Enter the max filling capacity of this holder:\n");
				holderCapacity = scan.nextInt();
				holder = new Holder(holderType, holderCapacity);
				System.out.println("Initial condition of new holder:\n"+ holder.toString()+"\n");
			}else{
				System.out.println("Using previous holder and state:\n"+ holder.toString()+"\n");
			}
			System.out.println("Would you like to use another kind of coffee?\n");
			ans = scan.next();
			if(!ans.equals("") &&( ans.equals("Y") || ans.equals("y") || ans.equals("yes") || ans.equals("Yes"))){
				System.out.println("Enter the coffee brand name:\n");
				coffeeBrand = scan.next();
				System.out.println("Enter the coffee type (i.e. \"coffee\", \"tea\", \"k-cup\"):\n");
				coffeeType = scan.next();
				System.out.println("Enter the coffee price:\n");
				coffeePrice = scan.nextFloat();
				System.out.println("Enter the coffee weight in ounces:\n");
				coffeeWeight = scan.nextInt();
				coffee = new Coffee(coffeeBrand, coffeeType, coffeePrice, coffeeWeight);
				System.out.println("Initial condition of new coffee: \n"+coffee.toString()+"\n");
			}else{
				System.out.println("Using previous coffee and state: \n"+coffee.toString()+"\n");	
			}
			
			System.out.println("Would you like to turn the machine on? y/n\n");
			ans = scan.next();
			if(!ans.equals("") &&( ans.equals("Y") || ans.equals("y") || ans.equals("yes") || ans.equals("Yes"))){
				if(coffeeMaker.getPower()){
					System.out.println("This machine is already on!\n");
				}else{
					coffeeMaker.setPower(true);
				}
			}else{
				if(!coffeeMaker.getPower()){
					System.out.println("Power is already off!\n");
				}else{
					coffeeMaker.setPower(false);
					System.out.println("Setting power off: machine powerState = "+coffeeMaker.getPower()+"\n");
				}
			}
			System.out.println("Would you like to place the holder? y/n\n");
			ans = scan.next();
			if(!ans.equals("") &&( ans.equals("Y") || ans.equals("y") || ans.equals("yes") || ans.equals("Yes"))){
				if(coffeeMaker.isHolderPresent()){
					System.out.println("This machine is occupied\n Would you like to replace the holder with the current one? y/n\n");
					ans = scan.next();
					if(!ans.equals("") &&( ans.equals("Y") || ans.equals("y") || ans.equals("yes") || ans.equals("Yes"))){
						coffeeMaker.removeHolder();
						coffeeMaker.setHolder(holder);
						coffeeMaker.setHolderPresence();
					}else{
						System.out.println("Using previos holder: \n"+holder.toString()+ "\n");
					}
				}else{
					coffeeMaker.setHolder(holder);
					coffeeMaker.setHolderPresence();
				}
			}else{
				System.out.println("Current holder presence for this machine: "+coffeeMaker.isHolderPresent());
			}
			System.out.println("The curernt water level for this machine is: "+coffeeMaker.getCurrentWater()+" ounces"
					+"\nWould you like to fill the machine with water? y/n\n");
			ans = scan.next();
			if(!ans.equals("") &&( ans.equals("Y") || ans.equals("y") || ans.equals("yes") || ans.equals("Yes"))){
				System.out.println("How much water would you like to add?\n");
				amtToAdd = scan.nextInt();
				coffeeMaker.fillWater(amtToAdd);
			}else{
				System.out.println("No water added\n");
			}
	
			System.out.println("How much would you like to brew?\n");
			amtToBrew =scan.nextInt();
			
			System.out.println("Attempting to brew a cup o' joe!");
			
			System.out.println("This is the pre-condition of the test run in interactive mode before brew():\n\n"
					+coffeeMaker.toString()
					+holder.toString()
					+coffee.toString());
			
			coffeeMaker.brew(amtToBrew, holder, coffee);
			
			System.out.println("This is the post-condition of the test run in interactive mode after brew():\n\n"
					+coffeeMaker.toString()
					+holder.toString()
					+coffee.toString());
			
			System.out.println("Would you like to brew anther cup?"); 
			ans = scan.next();
		}while(!ans.equals("") &&( ans.equals("Y") || ans.equals("y") || ans.equals("yes") || ans.equals("Yes")));
		System.out.println("Thanks for using this virtual Coffee Machine! Exiting system.");
		System.exit(0);
	}
	
}