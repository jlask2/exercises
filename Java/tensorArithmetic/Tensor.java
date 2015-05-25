/**
 * 
 */
package tensorArithmetic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Jay
 *
 */
public class Tensor {

	private Map<String, Integer> tensor;
	private HashMap<String, Integer> tempKeys;
	private String keys = "";
    private String resultString;
	
	public Tensor(int[] nLengths){
		if(nLengths.length < 2){
			System.out.println("This Tensor is trivial or invalid\n");
		}else{
			tempKeys = new HashMap<String, Integer>();
			tensor = new HashMap<String, Integer>();
			int index = 1;
			for(int i = 0; i < nLengths.length-1; i++){
				generateKeys(nLengths, index);
				index++;
				//System.out.println(index+" :: "+nLengths.length);		
			}
		}
	}
	
	private void generateKeys(int[] nLengths, int index){
		//System.out.println(index+" :: "+nLengths[index]);
		Iterator<Map.Entry<String, Integer>> it = tempKeys.entrySet().iterator();
		tempKeys = new HashMap<String, Integer>();
		if(it.hasNext()){
			while(it.hasNext()){
				Map.Entry<String, Integer> entry = it.next();
				for(int j = 0; j < nLengths[index]; j++){
					keys += entry.getKey()+", "+j;
					if(index == nLengths.length-1){
						tensor.put(keys, 0);
					}
					else{
						tempKeys.put(keys, 0);
					}
					keys = "";
				}
			}
		}else{
			for(int i = 0; i < nLengths[index-1]; i++){
				for(int j = 0; j < nLengths[index]; j++){
						keys += i+", "+j;
						if(nLengths.length == 2){
							tensor.put(keys, 0);
						}else{
							tempKeys.put(keys, 0);
						}
						keys = "";
				}
				/*try {
					finalize();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		}	
	}
	
	@Override 
	protected void finalize(){
		try{
			
		}catch(Throwable e){
			e.printStackTrace();
		}
	}
	
	public String getTempKeys(){
		return tempKeys.toString();
	}
	
	@Override
	public String toString(){
		int i = 1;
		resultString = "";
		Iterator<Map.Entry<String, Integer>> it = tensor.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, Integer> entry = it.next();
			resultString += i+".)\t ("+entry.getKey()+")\t = "+entry.getValue()+"\n";
			i++;
		}
		return	resultString;
	}
}
