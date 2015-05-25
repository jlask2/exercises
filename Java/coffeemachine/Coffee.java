/**
 * 
 */
package coffeemachine;

/**
 * @author Jay
 *
 */
public final class Coffee {

	private String brand;
	private String type;
	private float price;
	private int size;
	
	public Coffee(String brand, String type, float price, int size){
		this.brand = brand;
		this.type = type; 
		this.price = price;
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}
	
	public String getType() {
		return type;
	}
	
	public float getPrice() {
		return price;
	}
	
	public int getSize() {
		return size;
	}
}
