/**
 * 
 */
package coffeemachine;

/**
 * @author Jay
 *
 */
public final class Coffee extends CBeverages{

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Coffee [brand=" + brand + ", type=" + type + ", price=" + price
				+ ", size=" + size + "]\n";
	}
	
}