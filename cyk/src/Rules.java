package src;
import java.io.*;
import java.util.*;
/**
*Rules : for check Syntax Rules.
*
*<p>Usage:
*	First: call setRuleMap(String) in main method
*	Then : use getRule method if you want to check
*
*/
public class Rules{
	//HashMap with Multiple Keys
    private static HashMap<CompositeKey,String> map = new HashMap<>();
	
	//get one-to-one(A->B: getA)
    protected static String getRule(String left){
        if(left == null)
            return null;
        if(map.containsKey(new CompositeKey(left)))
            return map.get(new CompositeKey(left));
        return null;
    }
	//get two-to-one(A->B+C: getA)
    protected static String getRule(String left, String right){
        if(left == null || right == null)
            return null;
        if(map.containsKey(new CompositeKey(left, right)))
            return map.get(new CompositeKey(left, right));
        return null;
    }
	//set HashMap which has Multiple Keys with one value(from CompositeKey Class)
    public static void setRuleMap(String filename){
        String s;
        BufferedReader br = null;
        String[] tmp = new String[3];
        try{
            br = new BufferedReader(new FileReader(filename));
            while((s = br.readLine()) != null){
                tmp = s.split(",");
				//System.out.println(Arrays.toString(tmp));
                if(tmp.length==3)
                    map.put(new CompositeKey(tmp[1],tmp[2]),tmp[0]);
                else 
                    map.put(new CompositeKey(tmp[1]),tmp[0]);
            }
        }catch(Exception e){
			//show where an Exception occurred(Code place & Details)
            e.printStackTrace();
        }finally{
			//Close BufferedReader in any situation
            try{
                if(br != null)
                    br.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
