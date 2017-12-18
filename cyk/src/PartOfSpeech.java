package src; 
import java.io.*;
import java.util.*;
/*
*PartOfSpeech is class for read dictionary data and associate Word with PartOfSpeech.
*
*<p>This class has no constructor.	
*Used PartOfSpeech.getPart(String) in Parser.java
*
*@author Ryo Hatakenaka
*
*/
public class PartOfSpeech{

	//HashMap corresponding to duplicate key
	private static Map<String,List<String>> partMap = new HashMap<>();
	
	/**
	*Return list contains some PartOfSpeech.
	*	e.g.  In :flies, out :[NOUN,VERB]
	*/
	protected static Vector<String> getPart(String word){
		if(partMap.isEmpty()){
			setMap();
		}
		//Variable-length object Array:Vector
		Vector<String> part = new Vector<>();
		//not found in dictionary data
		if(!partMap.containsKey(word)){
			System.out.println("Error\t|"+word+" was not found in dics");
			return null;
		}
		//return some part with one word
		for(String s: partMap.get(word))
			part.addElement(s);
		return part;
	}

	private static void setMap(){
		BufferedReader br = null;
		//Need try-catch to use filereader
		try{
			br = new BufferedReader(new FileReader("./data/dics.csv"));
			String s;
			while((s = br.readLine()) != null){
				String[] tmp = s.split(",");
				List<String> list = new ArrayList<>();
				if(partMap.containsKey(tmp[0]))
					list = partMap.get(tmp[0]);
				list.add(tmp[1]);
				partMap.put(tmp[0],list);
			}
		}catch(Exception e){
			//show where Exception occurred
			e.printStackTrace();
		}finally{
			//Close BufferedReader in any situation;
			try{
				if(br != null)
					br.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
