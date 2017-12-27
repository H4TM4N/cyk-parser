import src.*;
import java.io.*;
/**
*ParseMain contains main method.
*
*<p>Usage:
*<code>java ParseMain textdata(.txt) ruledata(.csv)</code>
*<p>Use 2 Command-line arguments
*<p>args[0] : textdata written with txt extension
*<p>    e.g. the child runs quickly to the large house
*<p>args[1] : ruledata written with csv extension
*<p>    e.g. S,NP,VP
*
*@author Ryo Hatakenaka
*/
public class ParseMain{
    public static void main(String[] args){
        if(args.length != 2){
            System.out.println("\u001b[00;41m[Error\t]\u001b[00m File Load Error: please Run with 'text & Syntax-Rule'");
            return ;
        }
        String s;
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(args[0]));
            while((s = br.readLine()) != null){
                Rules.setRuleMap(args[1]);
                String[] text = s.split(" ");
                System.out.println("[INPUT\t] "+s+"\n");
                Parser.cykParse(text);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null)
                    br.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
