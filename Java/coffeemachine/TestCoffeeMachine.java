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
		CoffeeMaker coffeeMaker = new CoffeeMaker("Keurig 2.0", coffeetypes, (float)120.00, 123456);
		coffeeMaker.setPower(true);
		coffeeMaker.setHolder(holder);
		holder.setHolderPresence(true, coffeeMaker.holderPresentState());
		coffeeMaker.fillWater(12);
		coffeeMaker.brew(8, holder, coffee);
	}
	
	public void menu(){
		
		/*switch(choice){
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
			break;*/
		//}
	}

}
