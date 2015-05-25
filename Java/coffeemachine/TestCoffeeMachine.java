/**
 * 
 */
package coffeemachine;

/**
 * @author Jay
 *
 */
public class TestCoffeeMachine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Coffee coffee = new Coffee("Maxwell House", "k-cup", (float)1.00, 8);
		Holder holder = new Holder("Cup", 10);
		String[] coffeetypes = {"coffee", "expresso", "k-cup"};
		Keurig keurig = new Keurig("Keurig 2.0", coffeetypes, (float)120.00, 123456);
		keurig.setPower(true);
		keurig.setHolder(holder);
		holder.setHolderPresence(true, keurig.holderPresentState());
		keurig.fillWater(12);
		keurig.brew(8, holder, coffee);
	}
	
	public void menu(){
		
		switch(choice){
		case 0:
			if(CoffeeMachine.getPower() == false){
				CoffeeMachine.setPower(true);
			}else{
				CoffeeMachine.setPower(false);
			}
			break;
		case 1:
			break;
		case 2:
			break;
		default:
			break;
		}
	}

}
