/**
 * 
 */
package tensorArithmetic;

/**
 * @author Jay
 *
 */
public class TestTensorArithmetic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nLengths = {1, 2};
		Tensor tensor = new Tensor(nLengths);
		System.out.println(tensor.toString());
		//for(int i = 0; i < nLengths.length; i++){
			nLengths[0] = 2;
			nLengths[1] = 1;
		//}
		tensor = new Tensor(nLengths);
		System.out.println(tensor.toString());
		//System.out.println(tensor.getTempKeys());
	}

}
